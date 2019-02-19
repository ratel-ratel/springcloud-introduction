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

# EnableConfigServer 配置中心
   [配置中心](https://www.cnblogs.com/davidwang456/p/5979563.html?utm_source=itdadao&utm_medium=referral)     
# [eureka 配置服务续约设置](https://blog.csdn.net/azadalee/article/details/72123193)
        参数用于定义服务续约任务的调用间隔时间 默认为30 秒
        eureka.instance.lease-renewal-interval-in-seconds=30
        参数用于定义服务失效的时间,默认为90 秒
        eureka.instance.lease-expiration-duration-in-seconds=90  

   
LoadBalancerClient (负载均衡客户端)和RestTemplate，并在/consumer接口的实现中，先通过loadBalancerClient的choose函数来负载均衡的选出一个eureka-client的服务实例，这个服务实例的基本信息存储在ServiceInstance中，然后通过这些对象中的信息拼接出访问/dc接口的详细地址，最后再利用RestTemplate对象实现对服务提供者接口的调用(http://blog.didispace.com/spring-cloud-starter-dalston-2-1/)
