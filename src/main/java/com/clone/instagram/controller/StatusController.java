package com.clone.instagram.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clone.instagram.entity.Status;
import com.clone.instagram.service.StatusService;

@CrossOrigin
@RestController
@RequestMapping("/status")
public class StatusController {

	@Autowired
	StatusService statusService;
	@PostMapping("")
	public Status submitStatus(@RequestBody Status status) {
		return statusService.submitDataIntoDB(status);
	}
	@GetMapping("")
	public List<Status> getAllStatus()
	{
		return statusService.retriveStatus();
		
	}
}
