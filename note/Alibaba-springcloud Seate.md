# Seata

seata中一个典型的分布式事务的过程：1+3，1代表一个全局的事务id，3表示三大组件，TC、TM、RM

**TC (Transaction Coordinator) - 事务协调者**: 维护全局和分支事务的状态，驱动全局事务提交或回滚。
**TM (Transaction Manager) - 事务管理器**: 定义全局事务的范围：开始全局事务、提交或回滚全局事务。
**RM (Resource Manager) - 资源管理器**: 管理分支事务处理的资源，与TC交谈以注册分支事务和报告分支事务的状态，并驱动分支事务提交或回滚。

### Seata-server安装使用：

修改/conf/file.conf文件，mode有三种存储模式，将mode改为db模式，并修改相应的mysql配置。

sql文件在source源码的/script/server/mysql.sql文件中

```sql
-- -------------------------------- The script used when storeMode is 'db' --------------------------------
-- the table to store GlobalSession data
CREATE TABLE IF NOT EXISTS `global_table`
(
    `xid`                       VARCHAR(128) NOT NULL,
    `transaction_id`            BIGINT,
    `status`                    TINYINT      NOT NULL,
    `application_id`            VARCHAR(32),
    `transaction_service_group` VARCHAR(32),
    `transaction_name`          VARCHAR(128),
    `timeout`                   INT,
    `begin_time`                BIGINT,
    `application_data`          VARCHAR(2000),
    `gmt_create`                DATETIME,
    `gmt_modified`              DATETIME,
    PRIMARY KEY (`xid`),
    KEY `idx_gmt_modified_status` (`gmt_modified`, `status`),
    KEY `idx_transaction_id` (`transaction_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- the table to store BranchSession data
CREATE TABLE IF NOT EXISTS `branch_table`
(
    `branch_id`         BIGINT       NOT NULL,
    `xid`               VARCHAR(128) NOT NULL,
    `transaction_id`    BIGINT,
    `resource_group_id` VARCHAR(32),
    `resource_id`       VARCHAR(256),
    `branch_type`       VARCHAR(8),
    `status`            TINYINT,
    `client_id`         VARCHAR(64),
    `application_data`  VARCHAR(2000),
    `gmt_create`        DATETIME(6),
    `gmt_modified`      DATETIME(6),
    PRIMARY KEY (`branch_id`),
    KEY `idx_xid` (`xid`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

-- the table to store lock data
CREATE TABLE IF NOT EXISTS `lock_table`
(
    `row_key`        VARCHAR(128) NOT NULL,
    `xid`            VARCHAR(128),
    `transaction_id` BIGINT,
    `branch_id`      BIGINT       NOT NULL,
    `resource_id`    VARCHAR(256),
    `table_name`     VARCHAR(32),
    `pk`             VARCHAR(36),
    `gmt_create`     DATETIME,
    `gmt_modified`   DATETIME,
    PRIMARY KEY (`row_key`),
    KEY `idx_branch_id` (`branch_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8;

CREATE TABLE IF NOT EXISTS `distributed_lock`
(
    `lock_key`       CHAR(20) NOT NULL,
    `lock_value`     VARCHAR(20) NOT NULL,
    `expire`         BIGINT,
    primary key (`lock_key`)
) ENGINE = InnoDB
  DEFAULT CHARSET = utf8mb4;

INSERT INTO `distributed_lock` (lock_key, lock_value, expire) VALUES ('AsyncCommitting', ' ', 0);
INSERT INTO `distributed_lock` (lock_key, lock_value, expire) VALUES ('RetryCommitting', ' ', 0);
INSERT INTO `distributed_lock` (lock_key, lock_value, expire) VALUES ('RetryRollbacking', ' ', 0);
INSERT INTO `distributed_lock` (lock_key, lock_value, expire) VALUES ('TxTimeoutCheck', ' ', 0);
```

除此之外，seata默认的mysql驱动是5.X版本的，如果mysql版本是8.X版本的，需要将驱动改为com.mysql.cj.jdbc.Driver，在连接参数上添加时区：serverTimezone=GMT%2B8

/conf/registry.conf中，需要将注册模式改为nacos，（为了支持阿里原生），启动前先启动nacos，再启动seata



### DEMO

建库，account、order、storage，完成下订单->减库存，扣费的操作，其中分为订单微服务，仓库微服务和支付微服务

每一个库都需要一个回滚日志

```sql
CREATE TABLE undo_log (
id bigint(20) NOT NULL AUTO_INCREMENT,
branch_id bigint(20) NOT NULL,
xid varchar(100) NOT NULL,
context varchar(128) NOT NULL,
rollback_info longblob NOT NULL,
log_status int(11) NOT NULL,
log_created datetime NOT NULL,
log_modified datetime NOT NULL,
ext varchar(100) DEFAULT NULL,
PRIMARY KEY (id),
UNIQUE KEY ux_undo_log (xid,branch_id)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
```

seata和openfeign存在版本冲突问题，我的程序没有跑起来。

seata管理全局事务只需要一个注解即可：

```java
@GlobalTransactional(name = "cn-create-order",rollbackFor = Exception.class)

```

name可以任意，但要与其他的不冲突（唯一性），rollbackFor表示遇到哪种异常的时候回滚。该注解还有其他的属性，如noRollbackFor表示遇那种错误的时候不用回滚，等等...


