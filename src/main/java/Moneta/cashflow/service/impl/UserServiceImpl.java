package Moneta.cashflow.service.impl;

import Moneta.cashflow.dto.user.UserReqDto;
import Moneta.cashflow.dto.user.UserResDto;
import Moneta.cashflow.mapper.UserMapper;
import Moneta.cashflow.repository.UserRepository;
import Moneta.cashflow.service.RoleService;
import Moneta.cashflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final RoleService roleService;
    private final UserMapper mapper;

    @Override
    public Page<UserResDto> get() {
        return null;
    }

    @Override
    public UserResDto getById(UUID id) {
        return null;
    }

    @Override
    public UserResDto create(UserReqDto dto) {
        return null;
    }

    @Override
    public UserResDto update(UUID id, UserReqDto dto) {
        return null;
    }

    @Override
    public void delete(UUID id) {

    }
}
