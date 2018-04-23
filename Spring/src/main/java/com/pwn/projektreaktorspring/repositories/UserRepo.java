package com.pwn.projektreaktorspring.repositories;

import com.pwn.projektreaktorspring.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
    User getByMail(String mail);
}
