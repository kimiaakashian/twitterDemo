package ir.group_3_and_4.dto.twitt;

import jakarta.validation.constraints.Size;

public record TwittUpdateRequest (Long id,
                                  @Size(max = 280)
                                  String twitt){
}
