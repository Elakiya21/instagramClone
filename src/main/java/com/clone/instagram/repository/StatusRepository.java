package com.clone.instagram.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.instagram.entity.Status;

@Repository
public interface StatusRepository extends JpaRepository<Status, Integer> {

}
