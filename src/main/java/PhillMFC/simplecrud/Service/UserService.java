package PhillMFC.simplecrud.Service;

import org.springframework.stereotype.Service;

import PhillMFC.simplecrud.Dto.UserDto;
import PhillMFC.simplecrud.Entity.User;
import PhillMFC.simplecrud.Mapper.UserMapper;
import PhillMFC.simplecrud.Repository.UserRepository;
import PhillMFC.simplecrud.Service.Interface.UserServiceInterface;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements UserServiceInterface{
    
    private UserRepository userRepository;

    @Override
    public UserDto createUser (UserDto userDto){

        User user = UserMapper.mapUser(userDto);
        User savedUser = userRepository.save(user);
        return UserMapper.mapUserDto(savedUser);
    }
}
