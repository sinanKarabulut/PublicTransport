package com.simsoft.transport.controller;

import com.simsoft.transport.bus.IUsersBUS;
import com.simsoft.transport.bus.UsersBUS;
import com.simsoft.transport.dto.UsersDTO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Api(value = "/api/users", description = "User APIs")
@CrossOrigin
public class UsersController {

    @Autowired
    private IUsersBUS usersBUS;

    @GetMapping("/getUsersList")
    @ApiOperation(value = "Get By Pagination Operation", response = UsersDTO.class)
    public ResponseEntity<UsersDTO> getUsersList() throws Exception {
        UsersDTO data = usersBUS.getAllUsers();
        return ResponseEntity.ok(data);
    }

    @GetMapping("/{id}")
    @ApiOperation(value = "Get By Id Operation", response = UsersDTO.class)
    public ResponseEntity<UsersDTO> getById(@PathVariable(value = "id", required = true) Long id) {
        UsersDTO user = usersBUS.getById(id);
        return ResponseEntity.ok(user);
    }
}
