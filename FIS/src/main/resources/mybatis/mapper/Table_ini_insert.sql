show databases;
create database testdb;
use testdb;
drop database testdb;

show table status;

create table member(
	id varchar(100) not null primary key,
    pw varchar(100) not null,
	userName varchar(100) not null,
    gender varchar(100),
    phone varchar(100),
    email varchar(100),
    address varchar(100),
    registerDate datetime
);

select * from member;
drop table member;

insert into member values('jun', 'jun', '허준성', '남', '01093702416', 'oksk476@naver.com', '성남시 분당구 수내동', now());

create table board(
	bno int not null auto_increment primary key,
    title varchar(100) not null,
    contents varchar(1000),
    userId varchar(100) not null,
	userName varchar(100) not null,
    registerDate datetime,
    hits int,
    foreign key(userId) references member(id)
);

select * from board;
drop table board;


create table product(
	p_id varchar(100) not null primary key,
	p_name varchar(20),
	p_unitPrice int,
	p_description varchar(200),
	p_manufacturer varchar(20),
	p_category varchar(20),
	p_unitsInStock long,
	p_condition varchar(20),
	p_filename varchar(20),
	p_user varchar(100),
    regiDate datetime,
    foreign key(p_user) references member(id)
);

select * from product;
drop table product;

insert into product values("P1234", "Galaxy S20", 1200000,"5.25-inch, 1334*750 HD display, 16-megapixel Camera",
                          "SAMSUNG","Smart Phone",1000,"New","P1234.jpg", "jun", now());
insert into product values("P1235", "LG GRAM", 2000000,"13.3-inch, IPS FULL HD display, Intel Core Processor",
                          "LG","Notebook",1000,"Refurbished","P1235.jpg", "jun", now());
insert into product values("P1236", "Galaxy Tab", 900000,"212.8*125.6*6.6mm, Super AMOLED display, Octa-Core Processor",
                          "SAMSUNG","Notebook",1000,"Old","P1236.jpg", "jun", now());

create table delivery(
	p_id varchar(100) not null primary key,
    p_user varchar(100),
    buyer varchar(100),
    buyer_name varchar(100),
    buyer_phone varchar(100),
    buyer_address varchar(100),
    foreign key(p_id) references product(p_id) on delete cascade
);

select * from delivery;
drop table delivery;

insert into delivery(p_id, p_user) values ( "P1234" , "jun" );
insert into delivery(p_id, p_user) values ( "P1235" , "jun" );
insert into delivery(p_id, p_user) values ( "P1236" , "jun" );

