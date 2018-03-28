package project.web.config.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;

/**
 * @author Gavin
 */
@Configuration
public class PropertyPlaceholderConfig {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        File directory = new File(Thread.currentThread().getContextClassLoader()
                .getResource("").getPath());
        if (directory.isDirectory()) {
            File[] propFiles = directory.listFiles();
            if (propFiles.length != 0) {
                ClassPathResource[] resourceList = new ClassPathResource[propFiles.length];
                for (int i = 0; i< propFiles.length; i++) {
                    String fileName = propFiles[i].getName();
                    if (fileName.endsWith("properties")) {
                        resourceList[i] = new ClassPathResource(fileName);
                    }
                }
                configurer.setLocations(resourceList);
            }
        }
        configurer.setIgnoreResourceNotFound(true);
        return configurer;
    }
}
