#id
是一个Bean的唯一标识
#name
可以为Bean指定多个名称，每个名称之间用逗号隔开
#####Spring容器对Bean的配置、管理都通过该属性来完成（id、name）
#class
指定Bean的具体实现类，它必须是一个完整的类名
#scope
用来设定Bean实例的作用域，singleton（单例）、prototype（原型）、request、session、globalSession、application和websocket
默认值singleton
#constructor-arg
使用此元素传入构造参数进行实例化。
#property
用于调用Bean实例中的setter方法完成属性赋值，从而完成依赖注入。
#ref
#value
#list、map、set
用于封装*类型的依赖注入
#entry
<map>的子元素，用于设置键值对

#注
如果在Bean中未指定id和name，则Spring会将class值当作id使用

#Bean的实例化
###构造器实例化
ClassPathXmlApplicationContext()
.getBean()
###静态工厂方式实例化
该方式要求开发者创建一个静态工厂的方法来创建Bean的实例
public class MyBean2Factory {
    // 使用自己的工厂创建bean2实例
    public static Bean2 creatBean(){
        return new Bean2();
    }
}
<bean id="bean2" class="com.itheima.instance.staic_factory.MyBean2Factory" factory-method="creatBean"/>
###实例工厂方式实例化
不再使用静态方法创建Bean实例，而是采用直接创建Bean实例的方式。
factory-bean指向配置的实例工厂
factory-method确定使用工厂的哪个方法
public class MyBean3Factory {
    public MyBean3Factory() {
        System.out.println("bean3 的工厂实例化中");
    }
    // 创建Bean3实例的方法
    public Bean3 createBean(){
        return new Bean3();
    }
}
<!-- 配置工厂 -->
<bean id="myBean3Factory" class="com.itheima.instance.factory.MyBean3Factory"/>
<!-- 使用factory-bean 属性指向配置的实例工厂,
     使用factory-method 属性确定使用工厂中的哪个方法 -->
<bean id="bean3" factory-bean="myBean3Factory" factory-method="createBean"/>
 
#Bean的作用域 <bean id="" class="" scope=""/>
##singleton 单例（默认）
定义的bean在Spring容器中只有一个实例，无论多少个Bean引用它，始终将指向同一个对象
####只要id与Bean的id属性相匹配，就会返回同一个Bean实例
对应无会话状态的Bean（如Dao组件、Service组件）来说，是最理想的选择
##prototype 原型
每次通过该原型获取定义的bean时，容器都将创建一个新的Bean实例
####对需要保持会话状态的Bean使用
使用该作用域，Spring容器会为每个对该Bean的请求都创建一个新的实例
##request
对同一个HTTP请求中，容器都会返回该Bean的同一个实例
对不同的HTTP请求则会产生一个新的Bean，而且该Bean仅在当前HTTP Request内有效
##session
同request
##globalSession
在一个全局HttpSession中，容器会返回该Bean的同一个实例。仅在使用portlet上下文时有效
##application
为每个ServletContext对象创建一个实例。仅在Web相关的ApplicationContext中生效
##websocket
为每一个websocket对象创建一个实例。仅在Web相关的ApplicationContext中生效

#bean的生命周期
####singleton
Spring容器可以管理singleton作用域的生命周期，Spring能够精确的知道该Bean何时被创建，何时初始化完成以及何时被销毁。
####prototype
Spring只负责创建，当容器创建Bean实例化后，Bean的实例就交给客户端代码来管理，Spring容器将不再跟踪其生命周期

#Bean的装配方式
Bean的装配可以理解为依赖关系注入
###基于XML的装配
#####设值注入（Setter Injection）     <property name="username" value="张三"></property> 
在Spring实例化对象的过程中，Spring首先会调用Bean的默认构造方法来实例化Bean对象，然后通过反射的方式调用setter方法来注入属性值
###Bean类必须提供一个默认的无参的构造方法
###Bean类必须为需要注入的属性提供对应的setter方法
#####构造注入（Constructor Injection）<constructor-arg index="0" value="tom"/>
在配置文件中，需要使用<bean>元素的子元素<constructor-arg>来定义构造方法的参数，可以使用其value属性来设置该参数的值
######例子
<!-- 1.使用构造注入方式装配User实例 -->
<bean id="user1" class="com.itheima.assemable.User">
    <constructor-arg index="0" value="tom"/>
    <constructor-arg index="1" value="123456"/>
    <constructor-arg index="2">
        <list>
            <value>"constructorvalue1"</value>
            <value>"constructorvalue2"</value>
        </list>
    </constructor-arg>
</bean>
<!-- 2.使用设值注入方式装配User实例 -->
<bean id="user2" class="com.itheima.assemable.User">
    <property name="username" value="张三"></property>     
    <property name="password" value="654321"></property>
    <!-- 注入list -->
    <property name="list">
        <list>
            <value>"setlistcalue1"</value>
            <value>"setlistcalue2"</value>
        </list>
    </property>
</bean>

###基于Annotation的装配
使用XML配置文件可以实现Bean的装配工作，但如果应用中有很多Bean时，会导致XML配置文件过于臃肿
####@Component
使用此注解描述Spring中的Bean
####@Repository
用于将数据访问层（DAO层）的类标识为Spring中Bean，功能与@Repository相同
####@Service
通常作用在业务层（Service层），用于将业务层的类标识为Spring中的Bean，功能与@Repository相同
####@Controller
通常作用于控制层（Spring MVC 的Contriller），用于将控制层的类标识为Spring中的Bean，功能与@Repository相同
####@Autowired
用于对Bean的属性变量、属性的setter方法及构造方法进行标注，配合对应的注解处理器完成Bean的自动配置工作。
####@Resource
其作用与@Autowired一样。功能较复杂，用到再看。
name属性解析为Bean实例名称
type属性解析为Bean实例类型
####@Qualifier
与@Authorwired注解配合使用，会将默认的按Bean类型装配修改为按Bean的实例名称装配，Bean的实例名称有@Qualifier注解的参数指定

