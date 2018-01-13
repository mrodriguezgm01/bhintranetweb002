package pe.bhintranet.rc.client.util;

import java.nio.charset.Charset;
import java.util.Collections;

import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

//import com.idea.graphql.security.HttpRequestFileInterceptor;
//import com.idea.graphql.security.HttpRequestInterceptor;



public class RestTemplateFactory {

    public static RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
       // restTemplate.setInterceptors(Collections.singletonList(new HttpRequestInterceptor()));
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        return restTemplate;
    }


    public static RestTemplate restStringTemplate() {
        RestTemplate restTemplate = new RestTemplate();
       // restTemplate.setInterceptors(Collections.singletonList(new HttpRequestInterceptor()));
        restTemplate.getMessageConverters()
                .add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());

        return restTemplate;
    }

    public static RestTemplate restFilesTemplate(){
        RestTemplate restTemplate= new RestTemplate();
        //restTemplate.setInterceptors(Collections.singletonList(new HttpRequestFileInterceptor()));
        restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
        restTemplate.setErrorHandler(new RestTemplateResponseErrorHandler());
        return restTemplate;
    }
}