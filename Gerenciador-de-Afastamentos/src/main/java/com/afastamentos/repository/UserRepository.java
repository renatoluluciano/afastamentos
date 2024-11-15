package com.afastamentos.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.afastamentos.model.UserModel;


public interface UserRepository extends JpaRepository<UserModel, Long>{

}
