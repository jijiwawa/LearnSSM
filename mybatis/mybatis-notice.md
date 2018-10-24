#mybatis-config文件中标签顺序
##<configuration>的子元素必须按照下面顺序由上至下的顺序进行配置，否则MyBatis在解析XML配置文件的时候会报错
<properties>
<settings>
<typeAliases>
<typeHandlers>
<objectFactory>
<plugins>
<environments>
<databaseIdProvider>
<mappers>

#