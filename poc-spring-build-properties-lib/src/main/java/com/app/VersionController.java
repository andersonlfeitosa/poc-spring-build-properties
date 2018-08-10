package com.app;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.info.BuildProperties;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class VersionController {

  @Value("${spring.application.name}")
  private String springAppName;

  @Autowired
  private BuildProperties buildProperties;

  @GetMapping("/version")
  public String version() {

    if (buildProperties != null) {
      String.format("%s %s", springAppName, buildProperties.getVersion());
    }

    return String.format("%s %s", springAppName, "default");
  }
}
