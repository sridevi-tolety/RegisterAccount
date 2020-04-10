/*drop table user if exists;
create table user(

id integer ,
firstname varchar(255) not null,
lastname varchar(255) not null,
pan varchar(20) not null,
dob date

);*/

insert into user(id,firstname,lastname,pan,dob) values (1,'Sridevi','Tolety','PANNN111',sysdate());
insert into user(id,firstname,lastname,pan,dob) values (2,'S222222','AAAAAA','PANNN222',sysdate());
insert into user(id,firstname,lastname,pan,dob) values (3,'M111111','BBBBBB','PANNN333',sysdate());
insert into user(id,firstname,lastname,pan,dob) values (4,'M2222222','CCCCCC','PANNN444',sysdate());

insert into transaction(id,fromuserid,touserid,amount,transdate) values (100,1,2,12748.90,'2020-01-20 00:00:00' );
insert into transaction(id,fromuserid,touserid,amount,transdate) values (101,1,4,72094.00,'2020-01-30 00:00:00' );
insert into transaction(id,fromuserid,touserid,amount,transdate) values (102,3,1,38463.50,'2020-02-12 00:00:00');
insert into transaction(id,fromuserid,touserid,amount,transdate) values (103,3,2,9384.00,'2020-03-20 00:00:00');
insert into transaction(id,fromuserid,touserid,amount,transdate) values (104,4,2,193833.90,'2020-02-25 00:00:00');