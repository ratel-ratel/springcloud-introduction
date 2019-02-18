# springcloud-introduction
此项目作为学习 springcloud的记录 
# 一 @EnableDiscoveryClient与@EnableEurekaClient区别
    spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），
    @EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
    其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
    
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
