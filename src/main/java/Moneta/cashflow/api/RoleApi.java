package Moneta.cashflow.api;

import Moneta.cashflow.dto.role.RoleReqDto;
import Moneta.cashflow.dto.role.RoleResDto;
import Moneta.cashflow.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/role/v1")
@AllArgsConstructor
public class RoleApi {

    private final RoleService service;

    @GetMapping
    public ResponseEntity<List<RoleResDto>> get() {
        List<RoleResDto> dto = service.get();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping("/{roleId}")
    public ResponseEntity<RoleResDto> getById(@PathVariable("roleId") UUID id) {
        RoleResDto byId = service.getById(id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping
    public ResponseEntity<RoleResDto> create(@RequestBody RoleReqDto dto) {
        RoleResDto create = service.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(create);
    }

    @PutMapping("/{roleId}")
    public ResponseEntity<RoleResDto> update(@PathVariable("roleId") UUID id,
                                             @RequestBody RoleReqDto dto) {
        RoleResDto update = service.update(id, dto);
        return ResponseEntity.ok().body(update);
    }

    @DeleteMapping("/{roleId}")
    public ResponseEntity<Void> delete(@PathVariable("roleId") UUID id) {
        service.delete(id);
        return ResponseEntity.ok().build();
    }

}
