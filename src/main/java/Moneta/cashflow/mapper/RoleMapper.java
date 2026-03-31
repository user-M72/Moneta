package Moneta.cashflow.mapper;


import Moneta.cashflow.dto.role.RoleReqDto;
import Moneta.cashflow.dto.role.RoleResDto;
import Moneta.cashflow.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface RoleMapper {

    RoleResDto toDto(Role role);

    Role toEntity(RoleReqDto dto);

    void updatedFromDto(RoleReqDto dto, @MappingTarget Role role);
}
