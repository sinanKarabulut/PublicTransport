package com.simsoft.transport.dao;

import com.simsoft.transport.dto.UsersDTO;
import com.simsoft.transport.model.Users;
import org.hibernate.query.Query;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository(value = "usersDAO")
public class UsersDAO extends BaseDAO {

    public List<Users> getAllUsers(){
        String sql="from Users us where us.status=true";

        Query query = getCurrentSession().createQuery(sql);

        return query.list();
    }

    public Users findByUsername(String userName){
        String sql="from Users us where us.status=true and us.username=:userName";

        Query query = getCurrentSession().createQuery(sql);

        query.setString("userName",userName);
        return (Users)query.uniqueResult();
    }

    public Users getById(long Id){
        String sql="from Users us where us.status=true and us.id=:id";

        Query query = getCurrentSession().createQuery(sql);

        query.setLong("id",Id);

        return (Users)query.uniqueResult();
    }

}
