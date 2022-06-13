create database finalExam;
use finalExam;
create table user(
                     id int primary key not null auto_increment,
                     full_name varchar(60),
                     email varchar(60),
                     password varchar(15),
                     exp_in_year int,
                     pro_skill text,
                     project_id int,
                     role varchar(20)
)

insert table user values ()