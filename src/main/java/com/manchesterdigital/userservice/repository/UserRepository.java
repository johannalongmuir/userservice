package com.manchesterdigital.userservice.repository;

import com.manchesterdigital.userservice.entity.UserDTO;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<UserDTO, Long> {

//    UserDTO findByUsername(String username);

}
