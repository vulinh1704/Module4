-- insert user manage
insert into user (full_name, email, password, exp_in_year, project_id, role)
values ('Trương Đăng Vũ Linh' , 'truong.vulinh@vti.com.vn' , 123456 , 5 , 1 , 'manage');
insert into user (full_name, email, password, exp_in_year, project_id, role)
values ('Đào Như Anh' , 'dao.nhuanh@vti.com.vn' , 12345698 , 7 , 2 , 'manage');
insert into user (full_name, email, password, exp_in_year, project_id, role)
values ('Ngô Việt Hoàng' , 'ngo.viethoang@vti.com.vn' , 456789 , 5 , 2 , 'manage');
insert into user (full_name, email, password, exp_in_year, project_id, role)
values ('Nguyễn Thanh Phong' , 'nguyen.thanhphong@vti.com.vn' , 123456 , 5 , 1 , 'manage');
insert into user (full_name, email, password, exp_in_year, project_id, role)
values ('Đàm Xuân Đạt' , 'dam.xuandat@vti.com.vn' , 1234567 , 5 , 2 , 'manage');

-- insert user employee
insert into user (full_name, email, password, pro_skill, project_id, role)
values ('Ngô Thanh An', 'ngo.thanhan@vti.com.vn', 012345, 'dev , test', 1, 'employee');
insert into user (full_name, email, password, pro_skill, project_id, role)
values ('Đào Văn Xuân', 'dao.vanxuan@vti.com.vn', 123456, 'java , sql', 2, 'employee');
insert into user (full_name, email, password, pro_skill, project_id, role)
values ('Trương Ngọc Long', 'truong.ngoclong@vti.com.vn', 456789, 'jdbc , sql , dev', 2, 'employee');
insert into user (full_name, email, password, pro_skill, project_id, role)
values ('Nguyễn Đình Văn', 'nguyen.dinhvan@vti.com.vn', 123456, 'sql , javascript , css', 1, 'employee');
insert into user (full_name, email, password, pro_skill, project_id, role)
values ('Đàm Thanh Ngô', 'dam.thanhngo@vti.com.vn', 1234567, 'html , xml , java', 2, 'employee');