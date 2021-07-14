drop database if exists mp;

create database mp;

use mp;

drop table if exists tbl_employee;

create table tbl_employee(
	`id` int(11) primary key auto_increment,
    `last_name` varchar(50),
    `email` varchar(50),
    `gender` char(1),
    `age` int
);

INSERT INTO tbl_employee(`last_name`, `email`, `gender`, `age`)
VALUES 
	('Tom', 'tom@atguigu.com', 1, 22),
    ('Jerry', 'jerry@atguigu.com', 0, 25),
    ('Black', 'black@atguigu.com', 1, 30),
    ('White', 'white@atguigu.com', 0, 35);