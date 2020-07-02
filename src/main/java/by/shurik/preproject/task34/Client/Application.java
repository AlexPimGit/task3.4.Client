package by.shurik.preproject.task34.Client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@SpringBootApplication
public class Application {

    @Bean
    public HttpHeaders headers() {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        String auth = "123" + ":" + "123";
//        byte[] encodedAuth = Base64.encodeBase64(
//                auth.getBytes(StandardCharsets.US_ASCII));
//        String authHeader = "Basic " + new String(encodedAuth);
//        headers.add(HttpHeaders.AUTHORIZATION, authHeader);
        return headers;
    }

    @Bean
    public RestTemplate restTemplate(RestTemplateBuilder builder) {
        return builder.basicAuthentication("123", "123").build();
    }

    /*
    restTemplate.getInterceptors().add(
  new BasicAuthorizationInterceptor("username", "password"));
     */

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
