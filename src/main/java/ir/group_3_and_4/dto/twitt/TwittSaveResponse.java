package ir.group_3_and_4.dto.twitt;

import ir.group_3_and_4.dto.user.UserSaveResponse;

import java.time.LocalDateTime;

public record TwittSaveResponse (Long id,
                                 String twitt,
                                 LocalDateTime twittDateTime,
                                 UserSaveResponse user){
}
