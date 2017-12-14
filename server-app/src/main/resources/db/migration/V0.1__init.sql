CREATE TABLE IF NOT EXISTS `user` (
  `id`              INT          NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `name`            VARCHAR(32)  NOT NULL COMMENT '用户账号',
  `nickName`        VARCHAR(32)  NOT NULL COMMENT '用户昵称',
  `mobile`          VARCHAR(11)  NOT NULL COMMENT '手机号',
  `uuid`            VARCHAR(22)  NOT NULL COMMENT 'uuid',
  `password`        VARCHAR(64)           DEFAULT NULL COMMENT '用户密码HASH',
  `money`           INT          NOT NULL DEFAULT 0 COMMENT '余额，单位分',
  `imgKey`          VARCHAR(255) NOT NULL COMMENT '用户头像图片KEY',
  `version`         INT          NOT NULL DEFAULT 0 COMMENT '版本号',
  `create_time`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time`     DATETIME     NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `real_name`       VARCHAR(64) COMMENT '真实姓名',
  `id_number`       VARCHAR(64) COMMENT '身份证号',
  `email`           VARCHAR(128) COMMENT '电子邮箱',
  `address`         VARCHAR(255) COMMENT '通讯地址',
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`),
  UNIQUE KEY `mobile` (`mobile`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1001
  DEFAULT CHARSET = utf8mb4
  COMMENT ='用户表';

# 插入默认用户数据
REPLACE INTO user (name, nickName, mobile, uuid, password, money, imgKey, version, create_time, update_time, real_name, id_number, email, address) VALUES ('user', '西门嘉宝', 12345678901, 'dsfdsf', 'S2B5QCSX3AdDMH67CpVjjMxLw19WdR_B7xnSSzb7zOE=', 0, 'http://ui.happy.cn/default/256%402x.png', 0, '2017-08-11 07:59:45', '2017-09-18 07:36:19', '李大个', 293198199907071830, 'asd3334fier@qq.com', '天津市某某某地区地址');

CREATE TABLE IF NOT EXISTS `access_token` (
  `id`          INT         NOT NULL AUTO_INCREMENT,
  `user_id`     BIGINT      NOT NULL COMMENT '用户id',
  `token`       VARCHAR(64) NULL COMMENT '登录token',
  `create_time` DATETIME    NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY (`token`)
)
  ENGINE = InnoDB
  AUTO_INCREMENT = 1001
  DEFAULT CHARSET = utf8mb4
  ROW_FORMAT = DYNAMIC
  COMMENT '登录token';
