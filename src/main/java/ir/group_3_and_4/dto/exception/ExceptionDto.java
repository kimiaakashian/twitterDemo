package ir.group_3_and_4.dto.exception;

import java.time.LocalDateTime;

public record ExceptionDto (String message,
                            LocalDateTime localDateTime){
}
