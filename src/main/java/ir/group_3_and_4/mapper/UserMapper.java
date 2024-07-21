package ir.group_3_and_4.mapper;

import ir.group_3_and_4.dto.user.UserSaveRequest;
import ir.group_3_and_4.dto.user.UserSaveResponse;
import ir.group_3_and_4.dto.user.UserUpdateRequest;
import ir.group_3_and_4.dto.user.UserUpdateResponse;
import ir.group_3_and_4.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper

public interface UserMapper {
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);
    User userSaveRequestToUser(UserSaveRequest request);

    UserSaveResponse userToUserSaveResponse(User user);

    User userUpdateRequestToUser(UserUpdateRequest request);
    UserUpdateResponse userToUserUpdateResponse(User user);


}
