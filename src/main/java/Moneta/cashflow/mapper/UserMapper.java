package Moneta.cashflow.mapper;

import Moneta.cashflow.dto.user.UserReqDto;
import Moneta.cashflow.dto.user.UserResDto;
import Moneta.cashflow.entity.Role;
import Moneta.cashflow.entity.User;
import org.jspecify.annotations.Nullable;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

import java.util.Set;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserResDto toDto(User user);

    User toEntity(UserReqDto dto, Set<Role> roleSet, @Nullable String password);

    void updateFromDto(UserReqDto dto, @MappingTarget User user);
}
