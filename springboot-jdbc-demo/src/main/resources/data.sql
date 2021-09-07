create table person (id integer not null ,
 name varchar(255) not null,
  location varchar(255),
   birth_date timestamp,
   primary key(id)
   );
   
 INSERT INTO PERSON (ID,NAME,LOCATION,BIRTH_DATE) VALUES(10001,'kaushal','bangalore', sysdate());
  INSERT INTO PERSON (ID,NAME,LOCATION,BIRTH_DATE) VALUES(10002,'kaushlender','bangalore', sysdate());
   INSERT INTO PERSON (ID,NAME,LOCATION,BIRTH_DATE) VALUES(10003,'divyansh','bangalore', sysdate());