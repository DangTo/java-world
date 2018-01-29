select * from dba_users d where d.username = 'DANG';

CREATE USER dang IDENTIFIED BY oracle99;

alter session set "_ORACLE_SCRIPT"=true;  

GRANT CONNECT TO dang;
GRANT CREATE ANY TABLE TO dang;
GRANT UNLIMITED TABLESPACE TO dang;
grant create sequence to dang;
ALTER USER dang quota unlimited on USERS;


select * from customer;

select * from all_tables a where a.table_name = 'CUSTOMER';
