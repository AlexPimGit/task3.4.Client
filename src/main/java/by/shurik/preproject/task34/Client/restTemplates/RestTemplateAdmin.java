package by.shurik.preproject.task34.Client.restTemplates;

import by.shurik.preproject.task34.Client.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RestTemplateAdmin {
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;

    @Autowired
    public void setRestTemplateAdmin(RestTemplate restTemplateAdmin, HttpHeaders httpHeadersAdmin) {
        this.restTemplate = restTemplateAdmin;
        this.httpHeaders = httpHeadersAdmin;
    }

    public String getUsers() {
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange("http://localhost:8081/admin/allUsers", HttpMethod.GET, entity, String.class).getBody();
    }
}
