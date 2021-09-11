package com.clone.instagram.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.instagram.entity.Comments;
import com.clone.instagram.entity.Posts;
import com.clone.instagram.repository.CommentRepository;

@Service
public class CommentService {

	@Autowired
	CommentRepository commentRepository;
	@Autowired
	UserService userService;

	public Comments submitCommentToDb(Comments comment) {
		return commentRepository.save(comment);
	}

	public ArrayList<Comments> getAllCommentsSromDb(String postId) {
 
		ArrayList<Comments> commentsList = commentRepository.findAllByPostId(postId);
		for (int i = 0; i < commentsList.size(); i++) {
			Comments commentsItem = commentsList.get(i);
			commentsItem.setUserName(userService.displayMetaDataOfUser(commentsItem.getUserId()).getName());
		}
		return commentsList;
	}
}
