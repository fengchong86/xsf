package com.xsf.client.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "service-app")
public interface AppClient {

    @GetMapping("/execute/{args}")
    public String execute(@PathVariable("args") String args);

}