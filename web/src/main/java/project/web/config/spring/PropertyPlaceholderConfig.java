package project.web.config.spring;

import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import java.io.File;
import java.net.URI;

/**
 * @author Gavin
 */
@Configuration
public class PropertyPlaceholderConfig {

    @Bean
    public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer() {
        PropertyPlaceholderConfigurer configurer = new PropertyPlaceholderConfigurer();
        String path = Thread.currentThread().getContextClassLoader().getResource("properties").getPath();
        try {
            URI uri = new URI(path);
            File directory = new File(uri.getPath());
            if (directory.isDirectory()) {
                File[] propFiles = directory.listFiles();
                if (propFiles.length != 0) {
                    ClassPathResource[] resourceList = new ClassPathResource[propFiles.length];
                    for (int i = 0; i< propFiles.length; i++) {
                        String fileName = propFiles[i].getName();
                        if (fileName.endsWith("properties")) {
                            resourceList[i] = new ClassPathResource("properties/" + fileName);
                        }
                    }
                    configurer.setLocations(resourceList);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        configurer.setIgnoreResourceNotFound(true);
        return configurer;
    }
}
