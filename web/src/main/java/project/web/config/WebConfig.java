package project.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * @author Gavin
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"project.web.controller"})
public class WebConfig {
}
