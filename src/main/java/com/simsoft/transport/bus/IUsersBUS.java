package com.simsoft.transport.bus;

import com.simsoft.transport.dto.UsersDTO;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public interface IUsersBUS {
    UsersDTO getAllUsers() throws Exception;

    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;

    UsersDTO save(UsersDTO user);

    UsersDTO getById(Long id);

    UsersDTO getByUsername(String username);
}
