package Moneta.cashflow.service;

import Moneta.cashflow.dto.role.RoleReqDto;
import Moneta.cashflow.dto.role.RoleResDto;
import Moneta.cashflow.entity.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface RoleService {

    List<RoleResDto> get();

    RoleResDto getById(UUID id);

    RoleResDto create(RoleReqDto dto);

    RoleResDto update(UUID id, RoleReqDto dto);

    void delete(UUID id);

    Set<Role> getByIdList(List<UUID> id);
}
