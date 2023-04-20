package com.helloworld.ex4HelloWorld.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.helloworld.ex4HelloWorld.models.User;

public interface UserRepo extends JpaRepository<User, Long>{
	
}
