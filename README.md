# SpringBootWebTemplate
Template of SpringBootWeb
基于springboot 2.X和gradle 5.6构建<br/>
整合了logback框架并启用了aop组件和jpa，目标数据库为mysql和redis<br/>
应该会不定期跟进新版本。  

* 升级到boot2.0.3 并更新了配置文件格式，更符合推荐标准
* 2018-10-04 更新到SpringBoot@2.0.5, redisson@3.8.1. 修正了datasource配置以及更符合推荐标注的配置方式
* 2019-09-26 时隔一年，把依赖库更新到最新版本，也升级了build文件的写法，添加了gradle wrapper（5.6.2）的配置文件，并添加了独立的定时任务线程池

# 基本说明
针对实际环境，redisson和dataSource使用自定义配置文件的方式来保存连接属性，通过添加启动参数release来切换2份配置文件，具体参见resources目录下的debug.properties和release.properties  
