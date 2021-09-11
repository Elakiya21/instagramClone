package com.clone.instagram.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clone.instagram.entity.Status;
import com.clone.instagram.repository.StatusRepository;

@Service
public class StatusService {

	@Autowired
	StatusRepository statusRepository;
	@Autowired
	UserService userService;

	public Status submitDataIntoDB(Status status) {
		return statusRepository.save(status);

	}

	public List<Status> retriveStatus() {
		ArrayList<Status> statusList = (ArrayList<Status>) statusRepository.findAll();
		for (int i = 0; i < statusList.size(); i++) {
			Status statusItem = statusList.get(i);
			statusItem.setUserName(userService.displayMetaDataOfUser(statusItem.getUserId()).getName());
		}
		return statusList;
	}
}
