package com.simsoft.transport.controller;

import com.simsoft.transport.bus.UsersBUS;
import com.simsoft.transport.dao.UsersDAO;
import com.simsoft.transport.dto.*;
import com.simsoft.transport.model.Users;
import com.simsoft.transport.securitJwt.JwtTokenUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/token")
@Api(value = "/api/token", description = "Token APIs Document")
public class AccountController {
    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtTokenUtil jwtTokenUtil;
    @Autowired
    private UsersBUS usersBUS;
    @Autowired
    private UsersDAO usersDAO;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ApiOperation(value = "/login", response = TokenResponse.class)
    public ResponseEntity<TokenResponse> login(@RequestBody LoginRequest request) throws AuthenticationException {
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        final Users user = usersDAO.findByUsername(request.getUsername());
        final String token = jwtTokenUtil.generateToken(user);
        return ResponseEntity.ok(new TokenResponse(user.getUsername(), token));

    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    @ApiOperation(value = "register", response = Boolean.class)
    public ResponseEntity<Boolean> register(@RequestBody RegistrationRequest registrationRequest) throws AuthenticationException {
        Boolean response = usersBUS.register(registrationRequest);
        return ResponseEntity.ok(response);
    }
}
