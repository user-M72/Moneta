package Moneta.cashflow.service;

import Moneta.cashflow.dto.user.UserReqDto;
import Moneta.cashflow.dto.user.UserResDto;
import Moneta.cashflow.entity.Role;

import java.util.List;
import java.util.Set;
import java.util.UUID;

public interface UserService {

    List<UserResDto> get();

    UserResDto getById(UUID id);

    UserResDto create(UserReqDto dto);

    UserResDto update(UUID id, UserReqDto dto);

    void delete(UUID id);
}
