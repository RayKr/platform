package com.boya.platform.forum.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/23 17:12
 */
@RestController
public class ComputeController {

    @Autowired
    DiscoveryClient discoveryClient;

    @RequestMapping(value = "/add" ,method = RequestMethod.GET)
    public Integer add(@RequestParam Integer a, @RequestParam Integer b) {
        Integer r = a + b;
        System.out.println("/add, result:" + r);
        return r;
    }

    @GetMapping("/dc")
    public String dc() throws InterruptedException {
        Thread.sleep(5000L);
        String services = "Services: " + discoveryClient.getServices();
        System.out.println(services);
        return services;
    }

}
