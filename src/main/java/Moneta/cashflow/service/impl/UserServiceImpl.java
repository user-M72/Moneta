package Moneta.cashflow.service.impl;

import Moneta.cashflow.dto.user.UserReqDto;
import Moneta.cashflow.dto.user.UserResDto;
import Moneta.cashflow.entity.Role;
import Moneta.cashflow.entity.User;
import Moneta.cashflow.mapper.UserMapper;
import Moneta.cashflow.repository.UserRepository;
import Moneta.cashflow.service.RoleService;
import Moneta.cashflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleService roleService;
    private final UserMapper mapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    public List<UserResDto> get() {
        return repository.findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @Override
    public UserResDto getById(UUID id) {
        User user = repository.findById(id).orElseThrow(()-> new RuntimeException("User not found by id: " + id));
        return mapper.toDto(user);
    }

    @Override
    public UserResDto create(UserReqDto dto) {
        Set<Role> roleSet = roleService.getByIdList(dto.roleId());
        User user = mapper.toEntity(dto, roleSet, passwordEncoder.encode(dto.password()));
        User save = repository.save(user);
        return mapper.toDto(save);
    }

    @Override
    public UserResDto update(UUID id, UserReqDto dto) {
        User user = repository.findById(id).orElseThrow(()-> new RuntimeException("User not found by id: " + id));
        mapper.updateFromDto(dto, user);
        User save = repository.save(user);
        return mapper.toDto(save);
    }

    @Override
    public void delete(UUID id) {
        if (!repository.existsById(id)){
            throw new RuntimeException("User not found by id: " + id);
        }
        repository.deleteById(id);
    }
}
