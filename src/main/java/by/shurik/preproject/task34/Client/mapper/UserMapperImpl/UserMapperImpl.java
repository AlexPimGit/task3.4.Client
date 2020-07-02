package by.shurik.preproject.task34.Client.mapper.UserMapperImpl;

import by.shurik.preproject.task34.Client.dto.UserDto;
import by.shurik.preproject.task34.Client.mapper.UserMapper;
import by.shurik.preproject.task34.Client.model.Role;
import by.shurik.preproject.task34.Client.model.User;
import by.shurik.preproject.task34.Client.restTemplates.RestTemplateLogin;
import by.shurik.preproject.task34.Client.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Component
public class UserMapperImpl implements UserMapper {
    private RoleService roleService;
    private RestTemplateLogin restTemplateLogin;

    @Autowired
    public UserMapperImpl(RoleService roleService, RestTemplateLogin restTemplateLogin) {
        this.roleService = roleService;
        this.restTemplateLogin = restTemplateLogin;

    }

    @Override
    public User getUserFromDto(UserDto userDto) {
        User user = new User(userDto);
        Set<Role> newSetRoles = createRoleSet(userDto.getRoles());
        user.setRoles(newSetRoles);
        return user;
    }

    @Override
    public UserDto getUserDtoFromUser(User user) {
        Long userId = ((User) (restTemplateLogin.getUserByEmail(user.getEmail()))).getId();
        UserDto userDto = new UserDto(user);
        userDto.setId(userId);
        return userDto;
    }

    private Role adminRole = new Role(1L, "ADMIN");
    private Role userRole = new Role(2L, "USER");

    private Set<Role> createRoleSet(String[] allRoles) {
        Set<Role> roles = new HashSet<>();
        if (Arrays.asList(allRoles).contains("ADMIN")) {
            roles.add(adminRole);
        }
        if (Arrays.asList(allRoles).contains("USER")) {
            roles.add(userRole);
        }
        return roles;
    }
}
