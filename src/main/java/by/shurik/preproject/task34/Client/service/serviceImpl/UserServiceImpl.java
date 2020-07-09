package by.shurik.preproject.task34.Client.service.serviceImpl;

import by.shurik.preproject.task34.Client.model.User;
import by.shurik.preproject.task34.Client.service.UserService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;


@Service
public class UserServiceImpl implements UserService {
    private RestTemplate restTemplate;
    private HttpHeaders httpHeaders;
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Value("${myServer.url}")
    private String restUrl;


    public UserServiceImpl(RestTemplate restTemplate,
                           HttpHeaders httpHeaders,
                           BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.restTemplate = restTemplate;
        this.httpHeaders = httpHeaders;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }


    @Override
    public User addUser(User newUser) {
        HttpEntity<User> entity = new HttpEntity<>(newUser, httpHeaders);
        newUser.setUserPassword(bCryptPasswordEncoder.encode(newUser.getUserPassword()));
        return restTemplate.exchange(restUrl+"/addUser", HttpMethod.POST, entity, User.class).getBody();

    }

    @Override
    public User updateUser(User user) {
        user.setUserPassword(bCryptPasswordEncoder.encode(user.getUserPassword()));
        HttpEntity<User> entity = new HttpEntity<>(user, httpHeaders);
        return restTemplate.exchange(restUrl+"/update", HttpMethod.PUT, entity, User.class).getBody();
    }

    @Override
    public String deleteUser(Long id) {
        HttpEntity<User> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(restUrl+"/deleteUser/" + id, HttpMethod.DELETE, entity, String.class).getBody();
    }

    @Override
    public String listUser() {
        HttpEntity<String> entity = new HttpEntity<>(httpHeaders);
        return restTemplate.exchange(restUrl+"/allUsers", HttpMethod.GET, entity, String.class).getBody();
    }

}
