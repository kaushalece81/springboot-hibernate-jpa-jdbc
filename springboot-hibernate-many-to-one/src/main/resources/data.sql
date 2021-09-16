insert into course (id, name) values (10001, 'JPA in 10 Steps');
insert into course (id, name) values (10002, 'Hibernate in 10 Steps');
insert into course (id, name) values (10003, 'Java in 100 Steps');

insert into passport (id, number) values (40001, 'E12345687');
insert into passport (id, number) values (40002, 'E12345688');
insert into passport (id, number) values (40003, 'E12345689');

insert into student (id, name, passport_id) values (20001, 'Ranga', 40001);
insert into student (id, name, passport_id) values (20002, 'Adam', 40002);
insert into student (id, name, passport_id) values (20003, 'kaushal', 40003);



insert into review (id, rating, description, course_id) values (40001, '5', 'great course',10001);
insert into review (id, rating, description, course_id) values (40002, '4', 'good course',10001);
insert into review (id, rating, description, course_id) values (40003, '3', 'okay course',10002);
insert into review (id, rating, description, course_id) values (40004, '2', 'not good course',10003);
