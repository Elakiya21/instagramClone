package com.clone.instagram.service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.instagram.entity.Posts;
import com.clone.instagram.repository.PostRepository;

class SortbyId implements Comparator<Posts>
{
    public int compare(Posts a, Posts b)
    {
        return b.getId() - a.getId();
    }
}
@Service
public class PostService {

	@Autowired
	PostRepository postRepository;
	@Autowired
	UserService userService;

	public Posts submitPostToDataBase(Posts post) {

		return postRepository.save(post);
	}
	public ArrayList<Posts> retrivePostfromDataBase(){
		ArrayList<Posts> postsList =  postRepository.findAll();
		for (int i = 0; i < postsList.size(); i++) {
			Posts postsItem = postsList.get(i);
			System.out.println(postsItem);
			postsItem.setUserName(userService.displayMetaDataOfUser(postsItem.getUserId()).getName());
		}
		 Collections.sort(postsList, new SortbyId());
		return postsList;
	}
	public Posts updatelikes(String postId, int likeCount) {
		
		Posts p=postRepository.findByPostId(postId);
		p.setLikeCount(likeCount);
		return postRepository.save(p);
	}
}
