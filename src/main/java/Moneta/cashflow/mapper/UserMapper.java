package Moneta.cashflow.mapper;

import Moneta.cashflow.dto.user.UserReqDto;
import Moneta.cashflow.dto.user.UserResDto;
import Moneta.cashflow.entity.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserMapper {

    UserResDto toDto(User user);

    UserResDto toEntity(UserReqDto dto);
}
