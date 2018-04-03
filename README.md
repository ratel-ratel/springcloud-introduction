# springcloud-introduction
此项目作为学习 springcloud的记录 
一 @EnableDiscoveryClient与@EnableEurekaClient区别
    spring cloud中discovery service有许多种实现（eureka、consul、zookeeper等等），
    @EnableDiscoveryClient基于spring-cloud-commons, @EnableEurekaClient基于spring-cloud-netflix。
    其实用更简单的话来说，就是如果选用的注册中心是eureka，那么就推荐@EnableEurekaClient，如果是其他的注册中心，那么推荐使用@EnableDiscoveryClient
