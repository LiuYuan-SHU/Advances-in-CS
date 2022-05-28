-- ======================= sql注入 ========================
-- 创建一张表
use test;
create table admin(
	name varchar(32) not null unique,
    password varchar(32) not null default '' )
    character set utf8;

-- 添加数据
insert into admin values('tom', '123');

-- 查询管理员是否存在
select * from admin where name = 'tom' and password = '123';

-- SQL injection
-- name:        1' or
-- password:    or '1'='1
select * from admin where name = '1' or' and password = 'or '1'='1';

use test;
show tables;
select * from admin;
select * from admin where name = 'tom' and password = '123';