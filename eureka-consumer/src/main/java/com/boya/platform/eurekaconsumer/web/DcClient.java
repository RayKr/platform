package com.boya.platform.eurekaconsumer.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Tsunglei Ching [ray@boyamarine.com]
 * @date 2017/11/24 9:55
 */
@FeignClient(name = "forumapp", fallback = DcClient.DcClientFallback.class)
public interface DcClient {

    @GetMapping("/dc")
    String consumer();

    @Component
    class DcClientFallback implements DcClient {

        @Override
        public String consumer() {
            return "fallback string";
        }
    }

}
