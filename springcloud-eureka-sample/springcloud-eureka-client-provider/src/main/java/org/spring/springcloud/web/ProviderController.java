package org.spring.springcloud.web;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.serviceregistry.Registration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * Provider HelloWorld 案例
 * <p>
 * Created by bysocket on 06/22/17.
 */
@RestController
@Slf4j
public class ProviderController {
    @Autowired
    private RestTemplate restTemplate; // HTTP 访问操作类

    @Autowired
    private Registration registration;       // 服务注册

    @Autowired
    private DiscoveryClient discoveryClient; // 服务发现客户端

    @RequestMapping("/provider")
    public String provider() {
        ServiceInstance instance = serviceInstance();
        log.info("provider service, host = " + instance.getHost()
                + ", service_id = " + instance.getServiceId());
        return "Hello,Provider!";
    }
    @RequestMapping("/demo")
    public String demo() {
        ServiceInstance instance = serviceInstance();
        log.info("provider service, host = " + instance.getHost()
                + ", service_id = " + instance.getServiceId());
        return "cloud demo";
    }

    @RequestMapping("/requestCustomer")
    public String requestCustomer() {
        ServiceInstance instance = serviceInstance();
        log.info("provider service, host = " + instance.getHost()
                + ", service_id = " + instance.getServiceId());
        return "cloud demo";
    }

    @RequestMapping("/receiveProvider")
    public String customerDemo() {
        String providerMsg = restTemplate.getForEntity("http://CUSTOMER-SERVICE/receiveProvider",
                String.class).getBody();

        return "Hello,Customer! msg from provider : <br/><br/> " + providerMsg;
    }

    /**
     * 获取当前服务的服务实例
     *
     * @return ServiceInstance
     */
    public ServiceInstance serviceInstance() {
        List<ServiceInstance> list = discoveryClient.getInstances(registration.getServiceId());
        if (list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

}