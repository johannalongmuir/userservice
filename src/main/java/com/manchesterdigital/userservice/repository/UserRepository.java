package com.manchesterdigital.userservice.repository;

import com.manchesterdigital.userservice.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

//    extends CrudRepository<User, Long>
//    User findUsername(String username);
//
//    Iterable<User> findAll();
}
