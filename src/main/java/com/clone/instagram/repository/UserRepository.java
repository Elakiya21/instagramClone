package com.clone.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.clone.instagram.entity.Users;

public interface UserRepository extends JpaRepository<Users,Integer>{
	Users findByUserId(String id);

	


}
