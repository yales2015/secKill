CREATE TABLE user{
	id bigint(32) NOT NULL COMMENT '用户id，手机号',
	nickname VARCHAR(255) NOT NULL,
	password' VARCHAR(32) DEFAULT NULL COMMENT 'MD5(MD5(pass明文+固定salt)+salt)',
	salt VARCHAR(10) DEFAULT NULL,
	head VARCHAR(128) DEFAULT NULL COMMENT '头像，云存储id',
	register_date DATETIME DEFAULT NULL COMMENT '注册时间',
	last_login_date DATETIME DEFAULT NULL COMMENT '上次登录时间',
	login_count INT(11) DEFAULT '0' COMMENT '登录次数',
	PRIMARY KEY(`id`)
} ENGINE= InnoDB DEFAULT CHARSET= utf8mb4