# 简介
《十次方》是程序员的专属社交平台，包括头条、问答、活动、交友、吐槽、招聘六大频道。

《十次方社交系统》项目采用**前后端分离**的系统架构，后端采用目前主流的微服务系统架构`SpringBoot`+`SpringCloud`+`SpringData`进行开发，前端技术采用`Vue.js`。系统整体分为三大部分：微服务、网站前台、网站管理后台。此外，该项目还融合了Docker容器化部署、第三方登陆、SpringBoot、SpringCloud、SpringData 、人工智能、爬虫、RabbitMQ等技术。



# 系统设计

## 技术架构

1. 后端架构：`SpringBoot`+`SpringCloud`+`SpringData`+`SpringMVC`(Spring全家桶)

2. 前端架构：`Node.js`+`Vue.js`+`ElementUI`+`NUXT`

3. 技术架构图：

   ![十次方技术架构图](https://tiancixiong.coding.net/p/BlogIMG/d/BlogIMG/git/raw/master/blog/20201027_tensquare/image-20201027124345669.png)

4. 功能架构图：

   ![十次方功能架构图](https://tiancixiong.coding.net/p/BlogIMG/d/BlogIMG/git/raw/master/blog/20201027_tensquare/image-20201027125212961.png)



## 模块划分

项目整个工程共分为18个子模块(其中17个是微服务)：

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

项目采用分库分表的设计，每个业务模块为1个独立的数据库：

- tensquare_article 文章
  - tb_article文章表
  - tb_channel 频道表
  - tb_column 专栏表
- tensquare_base 基础
  - tb_city 城市表
  - tb_label 标签表
  - tb_ul 用户关注标签表
- tensquare_friend 交友
  - tb_friend 好友表
  - tb_nofriend 黑名单
- tensquare_gathering 活动
  - tb_gathering 活动表
  - tb_usergath 用户参加活动表
- tensquare_qa 问答
  - tb_pl 问答标签中间表
  - tb_problem 问题表
  - tb_reply 回答表
- tensquare_recruit 招聘
  - tb_enterprise 企业表
  - tb_recruit 职位表
- tensquare_user 用户
  - tb_admin 管理员表
  - tb_follow 用户关注表
  - tb_user 用户表
- tensquare_spit 吐槽
  - tb_spit 吐槽表



## API文档

前后端约定的返回状态码列表：

| 状态码 | 状态描述       |
| ------ | -------------- |
| 20000  | 成功           |
| 20001  | 失败           |
| 20002  | 用户名密码错误 |
| 20003  | 权限不足       |
| 20004  | 远程调用失败   |
| 20005  | 重复操作       |



## 开发环境

- JDK 1.8
- MySQL 5.7
- IntelliJ IDEA 2017.1.2
- Apache Maven 3.3.9
- Docker 18.03.1-ce
- CentOS 7.3.1611
- VMware Workstation15 Pro_v15.5.2



# License

[Apache 2.0 license](https://www.apache.org/licenses/LICENSE-2.0.html).
