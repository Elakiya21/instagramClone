package com.clone.instagram.controller;

import java.util.ArrayList;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.instagram.entity.Comments;
import com.clone.instagram.service.CommentService;

@CrossOrigin
@RestController
@RequestMapping("/comments")
public class CommentController {

	@Autowired
	CommentService commentService;
	@PostMapping("")
	public Comments saveComments(@RequestBody Comments comment) {
		return commentService.submitCommentToDb(comment);
	}
	@GetMapping("/{postId}")
	public ArrayList<Comments> getCommentsForPost(@PathVariable("postId") String postId){
		return commentService.getAllCommentsSromDb(postId);
	}
	
}
