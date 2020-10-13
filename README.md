# 简介
《十次方》是程序员的专属社交平台，包括头条、问答、活动、交友、吐槽、招聘六大频道



# 系统设计

## 系统架构

《十次方》采用前后端分离的系统架构，后端架构为：SpringBoot+SpringCloud+SpringMVC+SpringData



## 模块划分

十次方工程共分为18个子模块（其中17个是微服务）

| 模块名称                  | 描述           |
| ------------------------- | -------------- |
| tensquare_common          | 公共模块       |
| tensquare_article         | 文章微服务     |
| tensquare_base            | 基础微服务     |
| tensquare_friend          | 交友微服务     |
| tensquare_gathering       | 活动微服务     |
| tensquare_qa              | 问答微服务     |
| tensquare_recruit         | 招聘微服务     |
| tensquare_user            | 用户微服务     |
| tensquare_spit            | 吐槽微服务     |
| tensquare_search          | 搜索微服务     |
| tensquare_web             | 前台微服务网关 |
| tensquare_manager         | 后台微服务网关 |
| tensquare_eureka          | 注册中心       |
| tensquare_config          | 配置中心       |
| tensquare_sms             | 短信微服务     |
| tensquare_article_crawler | 文章爬虫微服务 |
| tensquare_user_crawler    | 用户爬虫微服务 |
| tensquare_ai              | 人工智能微服务 |



## 表结构分析

采用分库分表的设计，每个业务模块为1个独立的数据库：

- tensquare_article 文章
- tensquare_base 基础
- tensquare_friend 交友
- tensquare_gathering 活动
- tensquare_qa 问答
- tensquare_recruit 招聘
- tensquare_user 用户
- tensquare_spit 吐槽



## API文档

前后端约定的返回码列表：

| 返回码 | 状态描述       |
| ------ | -------------- |
| 20000  | 成功           |
| 20001  | 失败           |
| 20002  | 用户名密码错误 |
| 20003  | 权限不足       |
| 20004  | 远程调用失败   |
| 20005  | 重复操作       |



## 开发环境

- JDK1.8
- 数据库mysql 5.7
- 开发工具 idea 2017.1.2
- maven版本3.3.9
- docker 最新版本
- centos7
- VMware Workstation Pro 12