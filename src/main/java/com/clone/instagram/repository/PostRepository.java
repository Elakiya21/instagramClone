package com.clone.instagram.repository;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clone.instagram.entity.Posts;

public interface PostRepository extends JpaRepository<Posts, Integer> {

	ArrayList<Posts> findAll();

	Posts findByPostId(String postId);
}
