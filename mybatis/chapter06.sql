
#创建一个名称为mybatis的数据库
create database mybatis;

#使用mybatis数据库
use mybatis;

#创建一个名称为t_customer的表
create table t_customer(
  id int(32) primary key auto_increment,
  username varchar(50),
  jobs varchar(50),
  phone varchar(16)
);

#插入3条数据
insert into t_customer values('1','joy','doctor','13745874587');
insert into t_customer values('2','jack','teacher','13521210112');
insert into t_customer values('3','tom','worker','15179405961');