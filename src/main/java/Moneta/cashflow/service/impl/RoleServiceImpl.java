package Moneta.cashflow.service.impl;

import Moneta.cashflow.dto.role.RoleReqDto;
import Moneta.cashflow.dto.role.RoleResDto;
import Moneta.cashflow.mapper.RoleMapper;
import Moneta.cashflow.repository.RoleRepository;
import Moneta.cashflow.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public List<RoleResDto> get() {
        return List.of();
    }

    @Override
    public RoleResDto getById(UUID id) {
        return null;
    }

    @Override
    public RoleResDto create(RoleReqDto dto) {
        return null;
    }

    @Override
    public RoleResDto update(UUID id, RoleReqDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
