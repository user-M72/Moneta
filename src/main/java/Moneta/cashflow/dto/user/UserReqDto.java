package Moneta.cashflow.dto.user;

import Moneta.cashflow.dto.role.RoleResDto;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public record UserReqDto(

        String fistName,
        String lastName,
        String username,
        String email,
        String password,
        List<UUID> roleId
) {
}
