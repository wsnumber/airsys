# 建立项目数据库的表

# Module one  权限模块  【RBAC设计模式设计表，非常灵活，扩展性好】

# airsys_user  
# airays_role 
# airsys_resource
# ......
# Module two	人资模块   【其实并没有统一的标准，就是根据实际情况设置表】
# ......
# Module three    行政模块   【考勤管理   车辆管理   办公用品管理】
# ......

# 例子模块   仅有一张表
create table if not exists account(
	id int primary key auto_increment,
	name varchar(50) not null,
	balance double
);
create table if not exists user(
	id int primary key auto_increment,
	name varchar(50) not null,
	age integer
);
insert into user(name,age) values('zs',10);
insert into user(name,age) values('ls',11);
insert into user(name,age) values('ww',12);
insert into user(name,age) values('zl',13);
insert into user(name,age) values('zq',14);
insert into user(name,age) values('ws',15);
insert into user(name,age) values('cs',16);
insert into user(name,age) values('es',17);
insert into user(name,age) values('zs',18);