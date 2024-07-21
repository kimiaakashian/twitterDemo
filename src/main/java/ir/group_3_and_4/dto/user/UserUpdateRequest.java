package ir.group_3_and_4.dto.user;

import jakarta.persistence.Column;

public record UserUpdateRequest(Long id,
                                String name,
                                String username,
                                String password) {
}
