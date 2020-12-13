package co.sudoers.virtualnotes.util.mappers;

import co.sudoers.virtualnotes.dto.CreateUserDto;
import co.sudoers.virtualnotes.dto.GetUserDto;
import co.sudoers.virtualnotes.dto.UpdateUserDto;
import co.sudoers.virtualnotes.entity.User;
import org.mapstruct.Mapper;

@Mapper
public interface UserMapper {

    User createUserDtoToUser(CreateUserDto createUserDto);
    GetUserDto userToGetUserDto(User user);
    User getUserDtoToUser(GetUserDto getUserDto);
}
