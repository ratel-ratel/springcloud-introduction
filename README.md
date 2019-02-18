# springcloud-introduction
此项目作为学习 springcloud的记录 
# 一 @EnableEurekaServer 标记此服务为注册中心
        提供注册服务
   
    
# @FeignClient
  name：指定FeignClient的名称，如果项目使用了Ribbon，name属性会作为微服务的名称，用于服务发现
  url: url一般用于调试，可以手动指定@FeignClient调用的地址
  decode404:当发生http 404错误时，如果该字段位true，会调用decoder进行解码，否则抛出FeignException
  configuration: Feign配置类，可以自定义Feign的Encoder、Decoder、LogLevel、Contract
  fallback: 定义容错的处理类，当调用远程接口失败或超时时，会调用对应接口的容错逻辑，fallback指定的类必须实现@FeignClient标记的接口
  fallbackFactory: 工厂类，用于生成fallback类示例，通过这个属性我们可以实现每个接口通用的容错逻辑，减少重复的代码
  path: 定义当前FeignClient的统一前缀    
# @RefreshScope 动态刷新配置

# gateWay spring 网关,
# @EnableZuulProxy 服务注册为api 网关
#[EnableZuulProxy 详解](https://blog.csdn.net/hxpjava1/article/details/78334354)
# @EnableDiscoveryClient 将微服务注册到服务发现组件
    @EnableDiscoveryClient和@EnableEurekaClient共同点就是：都是能够让注册中心能够发现，扫描到改服务。
    不同点：@EnableEurekaClient只适用于Eureka作为注册中心，@EnableDiscoveryClient 可以是其他注册中心

