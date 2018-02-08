select * from all_tables a
where a.OWNER = 'DANG';

select * from tvlfull;

truncate table tvlfull;

select * from customer;

select * from people;

create table people
(
  id           NUMBER(19) not null,
  created_date TIMESTAMP(6),
  email        VARCHAR2(255 CHAR),
  name         VARCHAR2(255 CHAR)
);

CREATE TABLE people  (
    person_id NUMBER GENERATED ALWAYS AS IDENTITY,
    first_name VARCHAR(20),
    last_name VARCHAR(20)
);


CREATE TABLE TVLFULL  (
    column1 VARCHAR(40),
    column2 VARCHAR(40),
    column3 VARCHAR(40),
    column4 VARCHAR(40),
    column5 VARCHAR(40),
    column6 VARCHAR(40),
    column7 VARCHAR(40),
    column8 VARCHAR(40),
    column9 VARCHAR(40),
    column10 VARCHAR(40),
    column11 VARCHAR(40),
    column12 VARCHAR(40),
    column13 VARCHAR(40),
    column14 VARCHAR(40)
);

drop table people;
