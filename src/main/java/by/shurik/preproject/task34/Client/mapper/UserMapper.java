package by.shurik.preproject.task34.Client.mapper;


import by.shurik.preproject.task34.Client.dto.UserDto;
import by.shurik.preproject.task34.Client.model.User;

public interface UserMapper {
    User getUserFromDto(UserDto userDto);

    UserDto getUserDtoFromUser(User user);
}
