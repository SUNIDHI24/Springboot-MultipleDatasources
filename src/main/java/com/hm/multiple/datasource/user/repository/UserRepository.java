package com.hm.multiple.datasource.user.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hm.multiple.datasource.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
