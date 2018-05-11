package com.websystique.spring.service;

import java.io.ByteArrayOutputStream;
import java.io.StringWriter;
import java.math.BigDecimal;
import java.util.Date;
import java.util.GregorianCalendar;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.datatype.DatatypeConstants;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.namespace.QName;
import javax.xml.soap.MessageFactory;
import javax.xml.soap.SOAPBody;
import javax.xml.soap.SOAPBodyElement;
import javax.xml.soap.SOAPElement;
import javax.xml.soap.SOAPEnvelope;
import javax.xml.soap.SOAPException;
import javax.xml.soap.SOAPMessage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.w3c.dom.CDATASection;

import com.websystique.spring.model.BOSLaneInterface;
import com.websystique.spring.model.BOSLaneInterface.TOLL;
import com.websystique.spring.model.ProductOrder;

@Service("orderService")
public class OrderServiceImpl implements OrderService {

	@Autowired
	MailService mailService;

	@Override
	public void sendOrderConfirmation(ProductOrder productOrder) {
		// mailService.sendEmail(productOrder);
		System.out.println("Test");
		MessageFactory factory;
		try {
			factory = MessageFactory.newInstance();
			SOAPMessage message = factory.createMessage();

			// set envelope
			SOAPEnvelope env = message.getSOAPPart().getEnvelope();
			env.addNamespaceDeclaration("com", "http://com.etcc.hostinterface.webservice/");

			// set body
			SOAPBody body = message.getSOAPBody();
			QName bodyName = env.createQName("saveTransactionData", "com");
			SOAPBodyElement bodyElement = body.addBodyElement(bodyName);

			//set element
			QName name = new QName("request");
			SOAPElement symbol = bodyElement.addChildElement(name);
			
			//generate xml request body
			BOSLaneInterface tollTransaction = new BOSLaneInterface();
			
			TOLL toll = new TOLL();
			toll.setMessageID("TOLL");
			toll.setRTCSTransactionID(0);
			toll.setTollScheduleCode("361");
			toll.setTVLVersionID(0);
			toll.setFacilityCode("0");
			toll.setPlazaCode("0");
			toll.setLaneNumber("0");
			
			GregorianCalendar c = new GregorianCalendar();
			c.setTime(new Date());
			XMLGregorianCalendar transactionDateTime = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
			transactionDateTime.setTimezone(DatatypeConstants.FIELD_UNDEFINED);
			toll.setTransactionDateTime(transactionDateTime);
			toll.setTollCollectorID(0);
			toll.setLineOfBusiness("TOLL");
			toll.setPaymentType("0");
			toll.setIndicatedClass("0");
			toll.setAVCClassification("0");
			toll.setForwardAxles(0);
			toll.setReverseAxles(0);
			toll.setAxlesExpected(0);
			toll.setFareAmount(new BigDecimal(0));
			toll.setAvcAxles(0);
			toll.setAvcExtraAxles(0);
			toll.setTransactionUTCTime(transactionDateTime);
			toll.setFeeType(0);
			toll.setFeeAmount(new BigDecimal(0));
			toll.setEntryFacilityCode("0");
			toll.setEntryPlazaCode("0");
			toll.setEntryLaneNumber(01);
			toll.setEntryTransactonDateTime(transactionDateTime.toString());
			toll.setImagesCaptured(0);
			toll.setTagClass("0");
			toll.setVehicleSpeed(0);
			toll.setUnusualOccurrenceCode("0");
			toll.setReverseDirectionFlag(false);
			toll.setLaneMode("0");
			toll.setMaintenanceOverride(0);
			toll.setCoinCount1(0);
			toll.setCoinCount2(0);
			toll.setCoinCount3(0);
			toll.setCoinCount4(0);
			toll.setCoinCount5(0);
			toll.setCoinCount6(0);
			toll.setCoinCount7(0);
			toll.setCoinCount8(0);
			toll.setCoinCount9(0);
			toll.setCompositeOCRFrontPlateNumber("0");
			toll.setCompositeOCRFrontPlateNumberConfidence(0);
			toll.setCompositeOCRFrontPlateState("0");
			toll.setCompositeOCRFrontPlateStateConfidence(0);
			toll.setCompositeOCRBackPlateNumber("0");
			toll.setCompositeOCRBackPlateNumberConfidence(0);
			toll.setCompositeOCRBackPlateState("0");
			toll.setCompositeOCRBackPlateStateConfidence(0);
			
			//Transponder transponder = new Transponder();
							
			tollTransaction.setTOLL(toll);
						
			JAXBContext context = JAXBContext.newInstance(BOSLaneInterface.class);
	        Marshaller m = context.createMarshaller();

	        m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE); // To format XML

	        StringWriter sw = new StringWriter();
	        m.marshal(tollTransaction, sw);
	        String xmlString = sw.toString();
	        
	        System.out.println(xmlString);
			
			CDATASection cdata = symbol.getOwnerDocument().createCDATASection(xmlString);
			
			symbol.appendChild(cdata);

			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			message.writeTo(baos);

			System.out.println(baos.toString());
			
			RestTemplate restTemplate = new RestTemplate();
	        String url = "http://dev1.hctra.etcchostedservices.local:7014/hostws/HostManager";
	        
	        HttpEntity<String> entity = new HttpEntity<String>(baos.toString());
	        ResponseEntity<String> result = restTemplate.exchange(url, HttpMethod.POST, entity, String.class, 100);
	        
	        System.out.println(result);
	        
		} catch (SOAPException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
