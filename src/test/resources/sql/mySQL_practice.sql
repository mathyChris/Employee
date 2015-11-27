


show databases;

use mysql; 

show tables ; 

desc city ; 

desc member ; 

select * from member ;

create table division(

	dno int not null primary key, 
	dname varchar(20) not null, 
	phone varchar(20) not null,
	position varchar(20) not null 
)

show tables ;


insert into division
	values
	(10, 
	'Accounting',
	'02-555-5555', 
	'Kangnam') ; 
	
insert into division values(20, 'Management', '02-545-2345', 'Inchon'); 
insert into division values(30, 'SALES', '02-546-2345', 'Gyunggy'); 
insert into division values(40, 'Operation', '02-547-2345', 'Daejeon'); 
	
desc division  ; 

select * from division  

delete table division 


drop table division 
 












