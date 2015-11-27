


select * from dept ;

select *from emp ;



create table member(
	
	id 				int,
	email  			varchar(255),  
	name 			varchar(255), 
	password 		varchar(255), 
	register_date 	date, 
	constraint pk_id primary key (id)
	
); 



select rownum, c.*
	from city c
--	where rownum >= 11 
--	and rownum <= 20
	order by countrycode asc, name asc 
	
-- 	
-- 
--	
	select out.*
	from (
			select rownum rn, c.* 
			  from city c
			  order by countrycode asc , name asc 
			
		 ) out
--	where out.rn >= 11 and out.rn <= 20
	where rn >= 11 and rn <= 20
	order by rn
	
	
	select out.*
	from (
			select rownum rn, c.* 
			  from city c
			  order by name asc 
			
		 ) out
	where rn >= 11 and rn <= 20
	order by rn	
	
--	
-- rownum 을 이용한 정렬 및 부분 추출 	
--
  select out.*
	from (
			select rownum rn, in_.* 
			  from (
			  		select * 
			  		from city 
			  		order by countrycode asc, name asc) in_
		 ) out
	where out.rn >= 11 and out.rn <= 20
	order by rn	
	
-----------------------------------------------------------------	
	


select *from member; 



create sequence member_id_seq 


-- create 에 해당 
-- mysql과 차이가 나는 것이 insert 부분이다. 
-- 앞부분에 id 를 추가해야 한다. 

insert into member
(id, email, name, password, register_date)
values
(member_id_seq.nextval, xxxx@xxxx, Hong, 1234, 2015/11/09)



-- read 에 해당 
select *from member ;



-- delete 
delete from member
	where id = 1; 


	
-- update 에 해당 
update member 
	set name = Hong_sun,
		password = 9876
		
	where name = Hong; 
	

-- 	
--mysql --> city table 을 oracle 에서 생성한다. 
-- city 
-- control + shift + y --> lower letter 

drop table city ; 	

create table city (

	  id 			numeric(11) not null,
	  name 			char(40) not null,
	  countrycode 	char(3) not null,
	  district 		char(30),
	  population 	numeric(11) not null,
	  constraint city_pk_id primary key (id)

	  )
	  
	  
--	  
--	  
select *from city ;

create sequence city_id_seq

insert into city 
(
	id, 
	name, 
	countrycode, 
	district, 
	population
	
)
values
(
	city_id_seq.nextval, 
	Seoul,
	KOR,
	GyungSang,
	10000000

) 


-- 
-- inner join 의 사용 예 
-- left outer join 
-- right outer join 
-- (full) outer join 
-- 
select *from dept order by deptno;

select *from emp  ;



--
-- inner join introduction 
--
select *
	from dept d inner join emp e
	on d.deptno = e.deptno
	order by d.deptno 
	

--
-- stage 2 
-- inner join 
--
select d.deptno as dept_deptno,
	   d.dname as dept_dname,
	   d.loc as dept_loc,
	   e.empno as emp_empno,
	   e.ename as emp_ename,
	   e.job as emp_job
  from dept d inner join emp e
  	on d.deptno = e.deptno
  order by d.deptno 
  
  
-- stage 3 
-- outer join 
-- left outer join  
 select d.deptno as dept_deptno,
	   d.dname as dept_dname,
	   d.loc as dept_loc,
	   e.empno as emp_empno,
	   e.ename as emp_ename,
	   e.job as emp_job
  from dept d left outer join emp e
  	on d.deptno = e.deptno
  order by d.deptno  
	

 
  --
  --
  -- selectAll
  
	  select *
	  	
	  	from emp  
  
  
  -- 
  --
  -- selectAllWithDept
 	   select 
  			    e.empno  as emp_empno,
	    		e.ename  as emp_ename,
	    		e.job    as emp_job,
	    		e.mgr	 as emp_mgr,
	    		e.hiredate as emp_hiredate,
	    		e.sal    as emp_sal, 
	    		e.comm   as emp_com,
	    		d.deptno as dept_deptno,
	    		d.dname  as dept_dname, 
	    		d.loc    as dept_loc 
	    		
	    	from emp e inner join dept d
	    	on e.deptno = d.deptno
	    	order by e.deptno
	    	
	    	
--	    	
--
-- selectByEmpnoWithDept
	    	
	   select 
  			    e.empno  as emp_empno,
	    		e.ename  as emp_ename,
	    		e.job    as emp_job,
	    		e.mgr	 as emp_mgr,
	    		e.hiredate as emp_hiredate,
	    		e.sal    as emp_sal, 
	    		e.comm   as emp_com,
	    		d.deptno as dept_deptno,
	    		d.dname  as dept_dname, 
	    		d.loc    as dept_loc 
	    		
	    	from emp e inner join dept d
	    	on e.deptno = d.deptno
	    	where e.deptno = 10

--
--
-- select 	
	    	    	
	    select 
  			    e.empno  as emp_empno,
	    		e.ename  as emp_ename,
	    		e.job    as emp_job,
	    		e.mgr	 as emp_mgr,
	    		e.hiredate as emp_hiredate,
	    		e.sal    as emp_sal, 
	    		e.comm   as emp_com,
	    		d.deptno as dept_deptno,
	    		d.dname  as dept_dname, 
	    		d.loc    as dept_loc 
	    		
	    	from emp e right outer join dept d
	    	on e.deptno = d.deptno
	    	order by e.deptno 	
	    		
	    		
--
        select 
        	    empno , 
	    		ename , 
	    		job , 
	    		mgr	, 
	    		hiredate , 
	    		sal ,  
	    		comm , 
	    		deptno 
        from emp 
        where deptno = 80

   
        
        select * 
        		from dept
        	order by deptno 
        	
        	
        		
       	select * 
       	 		from dept d left outer join emp e
       	 		on d.deptno = e.deptno 
       	 		where d.deptno = 80 

       	 		
       	 		
		select * 
				from emp 
	
				
				
		select * 
       	 		from dept d left outer join emp e
       	 		on d.deptno = e.deptno 

----------------------------------------------------------20151123

drop table country        	 		
       	 		
create table country (
  code 				char(3), 
  name 				char(52), 
  continent         char(50),
  region 			char(26)
  surfacearea 		numeric(10,2), 
  indepyear 		numeric(6) ,
  population 		numeric(11) ,
  lifeexpectancy 	numeric(3,1) ,
  gnp 				numeric(10,2) ,
  gnpold 			numeric(10,2) ,
  localname 		char(45) ,
  governmentform 	char(45) ,
  headofstate 		char(60) ,
  capital 			numeric(11) ,
  code2 			char(2)  ,
  
  constraint pk_country_code primary key (code)
)   	 		
       	 		

--  name 				char(52) not null default '',
--  continent 		enum(asia,europe,north america,africa,oceania,antarctica,south america) not null default asia '',
--  region 			char(26) not null default '',
--  surfacearea 		numeric(10,2) not null default 0.00,
--  indepyear 		numeric(6) default null '',
--  population 		numeric(11) not null default 0,
--  lifeexpectancy 	numeric(3,1) default null '',
--  gnp 				numeric(10,2) default null '',
--  gnpold 			numeric(10,2) default null '',
--  localname 		char(45) not null default '',
--  governmentform 	char(45) not null default '',
--  headofstate 		char(60) default null '',
--  capital 			numeric(11) default null '',
--  code2 			char(2) not null default '',
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
       	 		
	
	
