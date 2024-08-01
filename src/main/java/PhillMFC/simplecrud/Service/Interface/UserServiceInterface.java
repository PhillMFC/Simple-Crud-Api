package PhillMFC.simplecrud.Service.Interface;

import java.util.List;

import PhillMFC.simplecrud.Dto.UserDto;

public interface UserServiceInterface {
    
    UserDto createUser(UserDto userDto);

    UserDto getUserById(Long userId);

    List<UserDto> getAllUsers();

    UserDto deleteUser(Long userId);

    UserDto updateUser( Long userId, UserDto updatedUser);

}
