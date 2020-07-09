package by.shurik.preproject.task34.Client.restTemplates;

import by.shurik.preproject.task34.Client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class RestTemplateLogin {
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    @Value("${myServer.url}")
    private String restUrl;

    @Autowired
    public RestTemplateLogin(RestTemplate restTemplate, HttpHeaders httpHeaders) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    public UserDetails getUserByEmail(String email) {
        HttpEntity<User> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(restUrl+"/{email}", HttpMethod.GET, entity, User.class, email).getBody();
    }

}
