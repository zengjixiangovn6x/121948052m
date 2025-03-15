DROP TABLE IF EXISTS sms_platform;
DROP TABLE IF EXISTS sms_log;

CREATE TABLE sms_platform
(
    id          bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    platform    tinyint COMMENT '平台类型  0：阿里云   1：腾讯云   2：七牛云   3：华为云',
    sign_name   varchar(100) NOT NULL COMMENT '短信签名',
    template_id varchar(100) NOT NULL COMMENT '短信模板',
    app_id      varchar(100) NOT NULL COMMENT '短信应用ID，如：腾讯云等',
    sender_id   varchar(100) NOT NULL COMMENT '腾讯云国际短信、华为云等需要',
    url         varchar(200) NOT NULL COMMENT '接入地址，如：华为云',
    access_key  varchar(100) COMMENT 'AccessKey',
    secret_key  varchar(100) COMMENT 'SecretKey',
    status      tinyint COMMENT '状态  0：禁用   1：启用',
    version     int COMMENT '版本号',
    deleted     tinyint COMMENT '删除标识  0：正常   1：已删除',
    creator     bigint COMMENT '创建者',
    create_time datetime COMMENT '创建时间',
    updater     bigint COMMENT '更新者',
    update_time datetime COMMENT '更新时间',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='短信平台';

CREATE TABLE sms_log
(
    id             bigint NOT NULL AUTO_INCREMENT COMMENT 'id',
    platform_id    bigint COMMENT '平台ID',
    platform       tinyint COMMENT '平台类型',
    mobile         varchar(20) NOT NULL COMMENT '手机号',
    params         varchar(200) COMMENT '参数',
    status         tinyint COMMENT '状态  0：失败   1：成功',
    error          varchar(2000) COMMENT '异常信息',
    create_time    datetime COMMENT '创建时间',
    primary key (id)
) ENGINE = InnoDB DEFAULT CHARSET = utf8mb4 COMMENT ='短信日志';