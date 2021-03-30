package com.example.webservice3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class webservice3
{
    @Autowired
    private LoadBalancerClient loadBalancer;
    @GetMapping("/load")
    public void method()
    {
        ServiceInstance serviceInstance = loadBalancer.choose("microservice1");
        System.out.println(serviceInstance.getUri());
    }
}
