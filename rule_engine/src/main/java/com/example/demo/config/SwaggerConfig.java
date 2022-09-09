package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.servers.Server;

@Configuration
public class SwaggerConfig {

	@Bean
	public OpenAPI springShopOpenAPI(@Value("${info.app.version}") String appVersion,
			@Value("${spring.application.name}") String appName, @Value("${swagger.api.description}") String appDesc,
			@Value("${server.servlet.context-path}") String contextPath) {
		return new OpenAPI().addServersItem(new Server().url(contextPath))
				.info(new Info().title(appName).description(appDesc).version(appVersion))
				.components(new Components().addSecuritySchemes("basicScheme",
						new SecurityScheme().type(SecurityScheme.Type.HTTP).scheme("basic")));
	}

}
