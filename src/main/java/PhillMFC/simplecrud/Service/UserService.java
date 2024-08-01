package PhillMFC.simplecrud.Service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import PhillMFC.simplecrud.Dto.UserDto;
import PhillMFC.simplecrud.Entity.User;
import PhillMFC.simplecrud.Exception.ResourceNotFoundException;
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

    @Override
    public UserDto getUserById(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(()-> new ResourceNotFoundException("Could not match a user with the following id" + userId));
        
        return UserMapper.mapUserDto(user);
    }

    @Override
    public UserDto deleteUser (Long userId){
        User user = userRepository.findById(userId)
            .orElseThrow(()-> new ResourceNotFoundException("Could not match a user with the following id" + userId));
        userRepository.deleteById(userId);
        return UserMapper.mapUserDto(user);
    }

    @Override
    public List<UserDto> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users.stream().map((user) -> UserMapper.mapUserDto(user)).collect(Collectors.toList());
    }

    @Override
    public UserDto updateUser(Long userId, UserDto updatedUser){
        User user = userRepository.findById(userId)
            .orElseThrow(()-> new ResourceNotFoundException("Could not match a user with the following id" + userId));
        
        user.setName(updatedUser.getName());
        user.setSurname(updatedUser.getSurname());
        user.setCpf(updatedUser.getCpf());
        user.setAddress(updatedUser.getAddress());

        User updatedUserEntity = userRepository.save(user);
        return UserMapper.mapUserDto(updatedUserEntity);
    }

}
