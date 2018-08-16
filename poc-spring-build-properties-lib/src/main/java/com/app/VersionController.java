package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersionController {

  @Autowired
  private ApplicationContext applicationContext;

  @GetMapping("/version")
  public String version() {
    String appName = "application-name-default";
    String version = "1.0.0-default";

    if (applicationContext.containsBean("buildProperties")) {
      BuildProperties buildProperties = applicationContext.getBean(BuildProperties.class);
      version = buildProperties.getVersion();
    }

    if (!"application".equalsIgnoreCase(applicationContext.getId())) {
      appName = applicationContext.getId();
    }

    return String.format("%s - %s", appName, version);
  }
}
