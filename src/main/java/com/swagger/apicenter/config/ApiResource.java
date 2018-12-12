package com.swagger.apicenter.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import springfox.documentation.swagger.web.SwaggerResource;
import springfox.documentation.swagger.web.SwaggerResourcesProvider;

import java.util.LinkedList;
import java.util.List;

/**
 * @author cuizhiquan
 * @Description
 * @date 2018/12/12 14:28
 * @Copyright (c) 2017, DaChen All Rights Reserved.
 */
@Component
@Primary
public class ApiResource implements SwaggerResourcesProvider {

    @Autowired
    private DiscoveryClient discoveryClient;

    @Override
    public List<SwaggerResource> get() {
        List<SwaggerResource> resources = new LinkedList<>();
        resources.add(this.swaggerResource("default","/v2/api-docs","2.0"));
        for (String service : discoveryClient.getServices()){
            resources.add(this.swaggerResource(service,"/" + service + "/v2/api-docs","2.0"));
        }
        return resources;
    }

    private SwaggerResource swaggerResource(String name,String location,String version){
        SwaggerResource resource = new SwaggerResource();
        resource.setName(name);
        resource.setLocation(location);
        resource.setSwaggerVersion(version);
        return resource;
    }
}
