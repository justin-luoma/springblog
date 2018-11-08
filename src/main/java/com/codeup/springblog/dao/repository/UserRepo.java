package com.codeup.springblog.dao.repository;

import com.codeup.springblog.dao.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepo extends CrudRepository<User, Long> {
    User findByUsername(String username);
}
