CREATE TABLE user{
	id bigint(32) NOT NULL COMMENT '�û�id���ֻ���',
	nickname VARCHAR(255) NOT NULL,
	password' VARCHAR(32) DEFAULT NULL COMMENT 'MD5(MD5(pass����+�̶�salt)+salt)',
	salt VARCHAR(10) DEFAULT NULL,
	head VARCHAR(128) DEFAULT NULL COMMENT 'ͷ���ƴ洢id',
	register_date DATETIME DEFAULT NULL COMMENT 'ע��ʱ��',
	last_login_date DATETIME DEFAULT NULL COMMENT '�ϴε�¼ʱ��',
	login_count INT(11) DEFAULT '0' COMMENT '��¼����',
	PRIMARY KEY(`id`)
} ENGINE= InnoDB DEFAULT CHARSET= utf8mb4