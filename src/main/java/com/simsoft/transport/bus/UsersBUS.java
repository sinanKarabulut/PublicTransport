package com.simsoft.transport.bus;

import com.simsoft.transport.dao.UsersDAO;
import com.simsoft.transport.dto.RegistrationRequest;
import com.simsoft.transport.dto.UsersDTO;
import com.simsoft.transport.model.Users;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service(value = "usersBUS")
public class UsersBUS implements IUsersBUS{
    @Autowired
    private UsersDAO usersDAO;

    @Autowired
    private ModelMapper modelMapper;


    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UsersBUS(BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }
    //private final ModelMapper modelMapper;

    @Override
    public UsersDTO getAllUsers() throws Exception {
        List<Users> usersList = usersDAO.getAllUsers();
        return  null;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersDAO.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("USER")));
    }


    @Transactional
    public Boolean register(RegistrationRequest registrationRequest) {
        try {
            Users user = new Users();
            user.setEmail(registrationRequest.getEmail());
            user.setNameSurname(registrationRequest.getNameSurname());
            user.setPassword(bCryptPasswordEncoder.encode(registrationRequest.getPassword()));
            user.setUsername(registrationRequest.getUsername());
            usersDAO.getCurrentSession().save(user);
            return Boolean.TRUE;
        } catch (Exception e) {

            return Boolean.FALSE;
        }
    }

    @Override
    public UsersDTO save(UsersDTO user) {
        Users u = modelMapper.map(user, Users.class);
        usersDAO.getCurrentSession().save(u);
        user.setId(u.getId());
        return user;
    }

    @Override
    public UsersDTO getById(Long id) {
        Users users = usersDAO.getById(id);
        return modelMapper.map(users, UsersDTO.class);
    }

    @Override
    public UsersDTO getByUsername(String username) {
        Users users = usersDAO.findByUsername(username);
        return modelMapper.map(users, UsersDTO.class);
    }

}
