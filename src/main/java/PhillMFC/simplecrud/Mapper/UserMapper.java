package PhillMFC.simplecrud.Mapper;

import PhillMFC.simplecrud.Dto.UserDto;
import PhillMFC.simplecrud.Entity.User;

public class UserMapper {
    
    public static UserDto mapUserDto(User user){
        return new UserDto(
            user.getId(),
            user.getName(),
            user.getSurname(),
            user.getCpf(),
            user.getAddress()
        );
    }

    public static User mapUser(UserDto userDto){
        return new User(
            userDto.getId(),
            userDto.getName(),
            userDto.getSurname(),
            userDto.getCpf(),
            userDto.getAddress()
        );
    }
}
