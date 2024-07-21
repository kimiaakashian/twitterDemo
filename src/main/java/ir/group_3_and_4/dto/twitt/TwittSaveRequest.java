package ir.group_3_and_4.dto.twitt;

import jakarta.validation.constraints.Size;

public record TwittSaveRequest(
        @Size(max = 300)
        String twitt) {
}
