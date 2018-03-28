package project.web.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Gavin
 */
@Configuration
@ComponentScan(basePackages = {"project"},
        excludeFilters = {@ComponentScan.Filter(type = FilterType.ANNOTATION,
                value = {Controller.class, RestController.class})})
public class RootConfig {
}
