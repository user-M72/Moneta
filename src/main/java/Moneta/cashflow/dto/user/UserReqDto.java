package Moneta.cashflow.dto.user;

import Moneta.cashflow.dto.role.RoleResDto;

import java.util.Set;

public record UserReqDto(

        String fistName,
        String lastName,
        String username,
        String email,
        String password,
        Set<RoleResDto> roles
) {
}
