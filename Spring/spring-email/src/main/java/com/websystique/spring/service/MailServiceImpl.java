package com.websystique.spring.service;

import java.util.HashMap;
import java.util.Map;

import javax.mail.internet.MimeMessage;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.mail.MailException;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;
import org.springframework.ui.velocity.VelocityEngineUtils;

import com.websystique.spring.model.ProductOrder;

import freemarker.template.Configuration;

@SuppressWarnings("deprecation")
@Service("mailService")
public class MailServiceImpl implements MailService{

	@Autowired
	JavaMailSender mailSender;
	
	//@Autowired
	//VelocityEngine velocityEngine;
	
	@Autowired
	Configuration freemarkerConfiguration;
	

	@Override
	public void sendEmail(Object object) {

		ProductOrder order = (ProductOrder)object;
		
		MimeMessagePreparator preparator = getMessagePreparator(order);
		
		try {
            mailSender.send(preparator);
            System.out.println("Message has been sent.............................");
        }
        catch (MailException ex) {
            System.err.println(ex.getMessage());
        }
	}

	private MimeMessagePreparator getMessagePreparator(final ProductOrder order){
		
		MimeMessagePreparator preparator = new MimeMessagePreparator() {

			public void prepare(MimeMessage mimeMessage) throws Exception {
            	MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true);
 
               	helper.setSubject("Your order on Demoapp with Templates");
               	//helper.setFrom("srta-maint@etcchosted.com");
               	//helper.setTo(order.getCustomerInfo().getEmail());
               	helper.setTo("noreply-srta@devexchange.local");
     
               	Map<String, Object> model = new HashMap<String, Object>();
                model.put("order", order);
                
            	String text = geFreeMarkerTemplateContent(model);
                System.out.println("Template content : "+text);

                // use the true flag to indicate you need a multipart message
            	helper.setText(text, true);

            	//Additionally, let's add a resource as an attachment as well.
            	helper.addAttachment("cutie.png", new ClassPathResource("linux-icon.png"));

            }
        };
        return preparator;
	}
	
	//DEPRECATED
	/*
	public String geVelocityTemplateContent(Map<String, Object> model){
		StringBuffer content = new StringBuffer();
		try{
			content.append(VelocityEngineUtils.mergeTemplateIntoString(velocityEngine, "/vmtemplates/velocity_mailTemplate.vm", model));
			return content.toString();
		}catch(Exception e){
			System.out.println("Exception occured while processing velocity template:"+e.getMessage());
		}
	      return "";
	}*/


	public String geFreeMarkerTemplateContent(Map<String, Object> model){
		StringBuffer content = new StringBuffer();
		try{
         content.append(FreeMarkerTemplateUtils.processTemplateIntoString( 
        		 freemarkerConfiguration.getTemplate("fm_mailTemplate.txt"),model));
         return content.toString();
		}catch(Exception e){
			System.out.println("Exception occured while processing fmtemplate:"+e.getMessage());
		}
	      return "";
	}



}
