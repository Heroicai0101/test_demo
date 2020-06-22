CREATE DATABASE demo;

CREATE TABLE `transfer_flow` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `transaction_no` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '交易单号',
  `self_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '扣款用户',
  `opposite_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '收款用户',
  `amount` bigint(20) NOT NULL DEFAULT '0' COMMENT '转账金额(分)',
  `state` tinyint(2) NOT NULL DEFAULT '0' COMMENT '流水状态: 0待处理 1已处理',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_transaction_no` (`transaction_no`),
  KEY `idx_gmt_created` (`gmt_created`),
  KEY `idx_gmt_modifid` (`gmt_modified`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='转账流水表';


CREATE TABLE `asset_account` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键',
  `account_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '扣款用户',
  `balance` bigint(20) NOT NULL DEFAULT '0' COMMENT '账户余额(分)',
  `state` tinyint(2) NOT NULL DEFAULT '0' COMMENT '账户状态: 0正常 1异常',
  `version` int(10) unsigned DEFAULT '0' COMMENT '版本号',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_account_id` (`account_id`),
  KEY `idx_gmt_created` (`gmt_created`),
  KEY `idx_gmt_modifid` (`gmt_modified`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='账户余额表';


CREATE TABLE `transfer_event` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT COMMENT '主键',
  `transaction_no` varchar(64) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '交易单号',
  `self_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '扣款用户',
  `opposite_user_id` bigint(20) NOT NULL DEFAULT '0' COMMENT '收款用户',
  `amount` bigint(20) NOT NULL DEFAULT '0' COMMENT '转账金额(分)',
  `gmt_created` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `gmt_modified` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`),
  UNIQUE KEY `uniq_transaction_no` (`transaction_no`),
  KEY `idx_gmt_created` (`gmt_created`),
  KEY `idx_gmt_modifid` (`gmt_modified`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='消费去重表';


INSERT INTO `asset_account` (`id`, `account_id`, `balance`, `state`, `version`, `gmt_created`, `gmt_modified`)
VALUES
  (1, 1, 500, 0, 0, NOW(), NOW()),
  (2, 2, 500, 0, 0, NOW(), NOW());