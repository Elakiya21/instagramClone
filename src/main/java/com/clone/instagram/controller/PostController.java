package com.clone.instagram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.instagram.entity.Posts;
import com.clone.instagram.service.PostService;

@CrossOrigin
@RestController
@RequestMapping("/posts")
public class PostController {

	@Autowired
	PostService postService;
	@PostMapping("")
	public Posts sumbitPost(@RequestBody Posts posts) {
		return postService.submitPostToDataBase(posts);
		
	}
	@GetMapping("")
	public List<Posts> getAllPosts()
	{
		return postService.retrivePostfromDataBase();
		
	}
	@PutMapping("")
	public Posts updatePost(@RequestBody Posts posts) {
		
		return postService.updatelikes(posts.getPostId(),posts.getLikeCount());
		
	}
}
