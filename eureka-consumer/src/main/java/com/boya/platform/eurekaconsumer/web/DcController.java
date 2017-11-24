package com.boya.platform.eurekaconsumer.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/24 9:12
 */
@RestController
public class DcController {

//    @Autowired
//    RestTemplate restTemplate;

    @Autowired
    DcClient dcClient;

    @GetMapping("/consumer")
    public String dc() {
//        ServiceInstance serviceInstance = loadBalancerClient.choose("forumapp");
//        String url = "http://" + serviceInstance.getHost() + ":" + serviceInstance.getPort() + "/dc";

//        return restTemplate.getForObject("http://forumapp/dc", String.class);

        return dcClient.consumer();
    }
}
