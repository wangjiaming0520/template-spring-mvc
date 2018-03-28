package project.web.config.http;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.servlet.HandlerAdapter;
import org.springframework.web.servlet.mvc.annotation.AnnotationMethodHandlerAdapter;

/**
 * @author Gavin
 */
@Configuration
public class MessageConverterConfig {

    /**
     * 指定 HttpMessageConverter requestBody 和 responseBody 生效
     */
    @Bean
    public HttpMessageConverter mappingJacksonHttpMessageConverter() {
        return new MappingJackson2HttpMessageConverter();
    }

    /**
     * 指定spring HandlerAdapter;
     */
    @Bean
    public HandlerAdapter annotationMethodHandlerAdapter() {
        HttpMessageConverter[] httpMessageConverters = {mappingJacksonHttpMessageConverter()};
        AnnotationMethodHandlerAdapter annotationMethodHandlerAdapter = new AnnotationMethodHandlerAdapter();
        annotationMethodHandlerAdapter.setMessageConverters(httpMessageConverters);
        return annotationMethodHandlerAdapter;
    }

}
