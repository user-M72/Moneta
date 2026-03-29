package Moneta.cashflow.dto.user;

import Moneta.cashflow.dto.role.RoleResDto;

import java.util.Set;
import java.util.UUID;

public record UserResDto(

        UUID id,
        String fistName,
        String lastName,
        String username,
        String email,
        String password,
        Set<RoleResDto> roles
) {
}
