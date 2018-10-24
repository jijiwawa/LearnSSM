#当遇到Cannot Resolve Symbol ......
点击菜单中的 “File” -> “Invalidate Caches / Restart”，然后点击对话框中的 “Invalidate and Restart”，清空 cache 并且重启。

#连接mysql驱动的时候
##注意jar包版本与mysql版本对其，且url有所变动
<!-- 数据库驱动 -->
<property name="driverClassName" value="com.mysql.cj.jdbc.Driver"/>
<!-- 连接数据库的url -->
<property name="url" value="jdbc:mysql://localhost:3306/spring?useUnicode=true&amp;characterEncoding=UTF-8&amp;useSSL=false"/>

#出现
##The server time zone value 'ÖÐ¹ú±ê×¼Ê±¼ä' is unrecognized or represents more than one
#时候参照下面url解决
https://blog.csdn.net/weixin_39033443/article/details/81711306

#如何使用maven导入依赖包？即如何获取depences子标签内容？



#构建文件模板--比如自定义mybatis-config.xml模板
https://blog.csdn.net/weixin_40689822/article/details/82187639

#