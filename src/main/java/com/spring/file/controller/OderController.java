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
import com.spring.file.model.Oder;
import com.spring.file.repository.OderRepository;

@RestController
@CrossOrigin
@RequestMapping("/api/v1/")
public class OderController {

	@Autowired
	private OderRepository oderRepository;
	
	@GetMapping("/oder")
	public List<Oder> getAllOder(){
		return oderRepository.findAll();
	}
	
	@PostMapping("/oder")
	public Oder createOder(@RequestBody Oder oder) {
		return oderRepository.save(oder);
	}
	
	@DeleteMapping("/oder/{id}")
	public ResponseEntity<Map<String, Boolean>> deleteOder(@PathVariable Integer id){
		Oder oder = oderRepository.findById(id)
					.orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));
		oderRepository.delete(oder);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		return ResponseEntity.ok(response);
		
		
	}
}
