package com.spring.file.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring.file.exception.ResourceNotFoundException;
import com.spring.file.model.Talk;
import com.spring.file.repository.TalkRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class TalkController {
	
	@Autowired
	private TalkRepository talkRepository;
	
	@GetMapping("/talk")
	public List<Talk> getAllOder(){
		return talkRepository.findAll();
	}
	
	@PostMapping("/talk")
	public Talk createOder(@RequestBody Talk talk) {
		return talkRepository.save(talk);
	}
	
	@DeleteMapping("/talk/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOder(@PathVariable Integer id){
		Talk talk = talkRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		talkRepository.delete(talk);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}

}
