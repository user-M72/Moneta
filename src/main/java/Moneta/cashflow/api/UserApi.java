package Moneta.cashflow.api;

import Moneta.cashflow.dto.user.UserReqDto;
import Moneta.cashflow.dto.user.UserResDto;
import Moneta.cashflow.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/users/v1")
@AllArgsConstructor
public class UserApi {

    private final UserService service;

    @GetMapping
    public ResponseEntity<List<UserResDto>> get(){
        List<UserResDto> userResDto = service.get();
        return ResponseEntity.ok().body(userResDto);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<UserResDto> getById(@PathVariable("userId")UUID id){
        UserResDto byId = service.getById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping
    public ResponseEntity<UserResDto> create(@RequestBody UserReqDto dto){
        UserResDto create = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{userId}")
    public ResponseEntity<UserResDto> update(@PathVariable("userId") UUID id,
                                             @RequestBody UserReqDto dto){
        UserResDto update = service.update(id, dto);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<Void> delete(@PathVariable("userId") UUID id){
        service.delete(id);
        return ResponseEntity.ok().build();
    }
}
