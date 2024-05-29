package com.adminpanel.adminpanel.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.adminpanel.adminpanel.entity.UserEntity;



@Repository
public interface UserRepository extends JpaRepository<UserEntity,Long>{
    // custom method for Query
    // List<UserEntity> findByUserName(String userName);
}
