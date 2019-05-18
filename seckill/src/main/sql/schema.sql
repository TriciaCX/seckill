-- 数据库初始化脚本

-- 创建数据库
CREATE DATABASE seckill;
--使用数据库
use seckill;
--创建秒杀库存表
CREATE TABLE seckill(
`seckill_id`bigint NOT NULL AUTO_INCREMENT COMMENT '商品库存id',
`name` varchar (120) NOT NULL COMMENT '商品名称',
`number` int NOT NULL COMMENT '库存数量',
`start_time` timestamp not null comment '秒杀开始时间',
`end_time` timestamp not null comment '秒杀结束时间',
`create_time` timestamp not null default current_timestamp comment '创建时间',
PRIMARY KEY (seckill_id),
key idx_start_time(start_time),
key idx_end_time(end_time),
key idx_create_time(create_time)
)ENGINE = InnoDB AUTO_INCREMENT=1000 DEFAULT CHARSET =utf8 COMMENT='秒杀库存表';

-- 初始化数据
insert into seckill(name,number,start_time,end_time)
values
('3000元秒杀p30',100,'2019-5-18 00:00:00','2019-5-19 00:00:00'),
('2000元秒杀iPadMini',200,'2019-5-18 00:00:00','2019-5-19 00:00:00'),
('3000元秒杀iPadAir',300,'2019-5-18 00:00:00','2019-5-19 00:00:00'),
('4000元秒杀iPadPro',400,'2019-5-18 00:00:00','2019-5-19 00:00:00');

-- 秒杀成功明细表
--用户登陆认证相关信息
create table success_killed(
`seckill_id` bigint not null comment '秒杀商品id',
`user_phone` bigint not null comment '用户手机号',
`state` tinyint not null default -1 comment '状态标志：-1无效 0：成功 1：已付款 2：已发货',
`create_time` timestamp not null comment '创建时间',
PRIMARY  KEY (seckill_id,user_phone), /*联合主键*/
key idx_create_time(create_time)
)ENGINE = InnoDB DEFAULT CHARSET =utf8 COMMENT='秒杀成功明细表';

-- 连接数据库控制台
mysql -uroot -p123456