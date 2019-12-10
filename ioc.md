Bean的生命周期：

Bean的定义：
    Spring通过我们的配置，如@ComponentScan定义的扫描路径去找到带有@Component的类，
这个过程就是一个资源定位的过程。
    一旦找到了资源，那么它就开始解析，并且将定义的信息保存起来。此时还没有初始化Bean，也就没有
Bean的实例，它有的仅仅是Bean的定义。
    然后就会把Bean的定义发布到Spring Ioc的容器中。还没有Bean的实例生成。
    
Bean的初始化：
    
    
Bean的生存期：
Bean的销毁：