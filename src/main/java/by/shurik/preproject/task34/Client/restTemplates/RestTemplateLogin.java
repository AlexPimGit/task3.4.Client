package by.shurik.preproject.task34.Client.restTemplates;

import by.shurik.preproject.task34.Client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public RestTemplateLogin(RestTemplate restTemplate, HttpHeaders httpHeaders) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
    }

    public UserDetails getUserByEmail(String email) {
//        HttpHeaders headers = new HttpHeaders();
//        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
//        String auth = "123" + ":" + "123";
//        byte[] encodedAuth = Base64.encodeBase64(
//                auth.getBytes(StandardCharsets.US_ASCII));
//        String authHeader = "Basic " + new String(encodedAuth);
//        headers.add(HttpHeaders.AUTHORIZATION, authHeader);
        HttpEntity<User> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8081/rest/login/{email}", HttpMethod.GET, entity, User.class, email).getBody();
    }
}
