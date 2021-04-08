package com.simsoft.transport.bus;

import com.simsoft.transport.dao.UsersDAO;
import com.simsoft.transport.model.Users;
import com.simsoft.transport.securitJwt.UserPrincipal;
import org.hibernate.criterion.MatchMode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Arrays;
import java.util.List;

@Service(value = "userDetailService")
@Transactional(isolation = Isolation.DEFAULT,readOnly = false, propagation = Propagation.REQUIRED)
public class UserDetailsServiceImpl implements UserDetailsService {


    @Autowired
    private UsersDAO usersDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersDAO.findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException("Invalid username or password.");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), Arrays.asList(new SimpleGrantedAuthority("USERS")));
    }

    public UserDetails loadUserByIds(Long id) {
        Users user = null;
        List<Users> userList = usersDAO.getByIds(id);
        if(userList.size()>0){
            user = userList.get(0);
        }else{
            throw new UsernameNotFoundException("User not found with id : " + id);
        }
        return UserPrincipal.create(user);
    }
}
