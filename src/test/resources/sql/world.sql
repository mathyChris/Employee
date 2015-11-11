


select *from dept ;

select *from city ;

select count(*) from city ;

select *from country; 

select count(*) from country; 


drop table member; 

create table member(
	
	id 				int not null auto_increment,
	email  			varchar(255),  
	name 			varchar(255), 
	password 		varchar(255), 
	register_date 	date, 
	constraint pk_id primary key (id)
	
); 


-- create 에 해당 
insert into member
(email, name, password, register_date)
values
('xxxx@xxxx', 'Hong', '1234', '2015/11/09')

-- read 에 해당 
select *from member ;


-- delete 
delete from member
	where id = 5; 


-- update 에 해당 
update member 
	set name = 'Hong_sun',
		password = '9876'
		
	where name = 'Hong'; 


	
	
	
-- member2의 CRUD 

create table member2(
	
	id 				int not null auto_increment primary key,
	email  			varchar(255),  
	name 			varchar(255), 
	password 		varchar(255), 
	register_date 	datetime not null default now() 
	
); 


-- read 
select *from member2 ; 

-- create 
insert into member2
(email, name, password)
values
('xxx@yyyy', 'Hong', '1234')

-- update 
update member2 
	set name = 'Hong_sun', 
		password = '9876' 
	where id = 1 ; 
	
-- delete 
delete from member2
	where id = 3 ; 


--
-- city 
--	
-- query 문은 한줄로 작성하지 않는다. 
select * from city ;


--
--
--
select  id, 
		name,
		countrycode,
		district, 
		population
		
   from city ; 

   
--
--
-- 
select  id, 
		name,
		countryCode,
		district, 
		population
		
   from city    
  where countrycode = 'KOR'; 
   








