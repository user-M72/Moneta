package Moneta.cashflow.service;

import Moneta.cashflow.dto.user.UserReqDto;
import Moneta.cashflow.dto.user.UserResDto;
import org.springframework.data.domain.Page;

import java.util.UUID;

public interface UserService {

    Page<UserResDto> get();

    UserResDto getById(UUID id);

    UserResDto create(UserReqDto dto);

    UserResDto update(UUID id, UserReqDto dto);

    void delete(UUID id);
}
