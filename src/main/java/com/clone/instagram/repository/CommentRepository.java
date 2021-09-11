package com.clone.instagram.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clone.instagram.entity.Comments;

@Repository
public interface CommentRepository extends JpaRepository<Comments, Integer> {
ArrayList<Comments> findAllByPostId(String id);
}
