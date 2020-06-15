package by.shurik.preproject.task34.Client.security;

import by.shurik.preproject.task34.Client.model.Role;
import by.shurik.preproject.task34.Client.model.User;
import by.shurik.preproject.task34.Client.restTemplates.RestTemplateLogin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private RestTemplateLogin restTemplateLogin;

    @Autowired
    public void setRestTemplateLogin(RestTemplateLogin restTemplateLogin) {
        this.restTemplateLogin = restTemplateLogin;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = (User) restTemplateLogin.getUserByEmail(username);
        if (user == null) {
            throw new UsernameNotFoundException("User with email " + username + " not found");
        }

        Set<Role> userRoles = new HashSet<>();
        for (Role role : user.getRoles()) {
            userRoles.add(role);
        }
        user.setRoles(userRoles);
        return user;

    }
}

