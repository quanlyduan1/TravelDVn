package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.CommentVnRequest;
import com.example.demo.service.CommentVnService;

@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class CommentVnController {
	@Autowired
	private CommentVnService commentService;
//	@Autowired
//	private CommentDao commentDao;
//	
	@GetMapping("commentvn")
	public ResponseEntity<?> GetComment(){
		return new ResponseEntity<>(commentService.GetComment(),HttpStatus.ACCEPTED);
	}
	@GetMapping("commentvn-bymotel")
	public ResponseEntity<?> GetCommentByMotel(@RequestParam Integer motel_id){
		return new ResponseEntity<>(commentService.GetCommentByMotel(motel_id),HttpStatus.ACCEPTED);
	}
	
	@PostMapping("commentvn")
	public ResponseEntity<?> CreateComment(@RequestBody CommentVnRequest commentRequest ){
		return new ResponseEntity<>(commentService.CreateComment(commentRequest),HttpStatus.CREATED);
	}

}
