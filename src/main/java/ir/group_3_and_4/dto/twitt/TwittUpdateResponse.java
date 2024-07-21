package ir.group_3_and_4.dto.twitt;

import ir.group_3_and_4.dto.user.UserSaveResponse;

public record TwittUpdateResponse(Long id ,
                                  String twitt,
                                  UserSaveResponse user){
}
