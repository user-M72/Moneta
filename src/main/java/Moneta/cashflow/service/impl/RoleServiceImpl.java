package Moneta.cashflow.service.impl;

import Moneta.cashflow.dto.role.RoleReqDto;
import Moneta.cashflow.dto.role.RoleResDto;
import Moneta.cashflow.entity.Role;
import Moneta.cashflow.mapper.RoleMapper;
import Moneta.cashflow.repository.RoleRepository;
import Moneta.cashflow.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository repository;
    private final RoleMapper mapper;

    @Override
    public List<RoleResDto> get() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public RoleResDto getById(UUID id) {
        Role role = repository.findById(id).orElseThrow(()-> new RuntimeException("Role not found by id: " + id));
        return mapper.toDto(role);
    }

    @Override
    public RoleResDto create(RoleReqDto dto) {
        Role role = mapper.toEntity(dto);
        Role save = repository.save(role);
        return mapper.toDto(save);
    }

    @Override
    public RoleResDto update(UUID id, RoleReqDto dto) {
        Role role = repository.findById(id).orElseThrow(()-> new RuntimeException("Role not found by id: " + id));
        mapper.updatedFromDto(dto, role);
        Role save = repository.save(role);
        return mapper.toDto(save);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("Role not found by id: " + id);
        }
        repository.deleteById(id);
    }

    @Override
    public Set<Role> getByIdList(List<UUID> id) {
        return new HashSet<>(repository.findAllById(id));
    }
}
