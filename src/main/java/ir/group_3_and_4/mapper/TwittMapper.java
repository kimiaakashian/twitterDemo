package ir.group_3_and_4.mapper;

import ir.group_3_and_4.dto.twitt.TwittSaveRequest;
import ir.group_3_and_4.dto.twitt.TwittSaveResponse;
import ir.group_3_and_4.dto.twitt.TwittUpdateRequest;
import ir.group_3_and_4.dto.twitt.TwittUpdateResponse;
import ir.group_3_and_4.dto.user.UserUpdateRequest;
import ir.group_3_and_4.dto.user.UserUpdateResponse;
import ir.group_3_and_4.model.Twitt;
import ir.group_3_and_4.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface TwittMapper {
    TwittMapper INSTANCE = Mappers.getMapper(TwittMapper.class);
    Twitt twittSaveRequestToTwitt(TwittSaveRequest request);

    TwittSaveResponse twittToTwittSaveResponse(Twitt twitt);

    Twitt twittUpdateRequestToTwitt(TwittUpdateRequest request);
    TwittUpdateResponse twittToTwittUpdateResponse(Twitt twitt);
}
