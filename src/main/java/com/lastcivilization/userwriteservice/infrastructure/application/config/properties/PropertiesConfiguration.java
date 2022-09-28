package com.lastcivilization.userwriteservice.infrastructure.application.config.properties;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:keycloak.yml", factory = YamlPropertySourceFactory.class)
class PropertiesConfiguration { }
