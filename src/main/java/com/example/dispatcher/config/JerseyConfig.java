package com.example.dispatcher.config;

import javax.annotation.PostConstruct;
import javax.ws.rs.ApplicationPath;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.wadl.internal.WadlResource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import com.example.dispatcher.controllers.DronesController;


@Component
@ApplicationPath("/api")
public class JerseyConfig extends ResourceConfig  {
    @PostConstruct
    public void init() {
        configEndPoints();
    }

    private void configEndPoints(){
        register(DronesController.class);
    }

}
