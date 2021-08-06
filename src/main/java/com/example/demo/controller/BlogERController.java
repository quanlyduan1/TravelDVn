package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.dao.BlogVNDao;
import com.example.demo.entity.BlogVNE;
import com.example.demo.exception.UserServiceException;
import com.example.demo.service.BlogVNService;


@RestController
@RequestMapping("api/v1")
@CrossOrigin("http://localhost:4200")
public class BlogERController {

	@Autowired
	private BlogVNDao blogVNDao;
	
	@Autowired
	private BlogVNService blogVNService;
	
	//D:\\Project\\TheTravel\\src\\assets\\images\\
	private static String upload ="D:\\Project\\Travel1_Manage\\src\\assets\\images\\";
	
	@GetMapping("blogvn")
	public List<BlogVNE>GetAllBlogVn(){
		return blogVNDao.findAll();
	}
	@PostMapping("blogvn")
	public ResponseEntity<?>AddBlogVNE (@RequestBody BlogVNE blogvne){
		return new ResponseEntity<>(this.blogVNService.AddBlog(blogvne),HttpStatus.ACCEPTED);
	}
	@GetMapping("blogvn/{id}")
	public ResponseEntity<?>GetBlogVnById(@PathVariable Integer id){
		BlogVNE blogvne = blogVNDao.findById(id).orElseThrow();
		return ResponseEntity.ok(blogvne);
	}
	
	@PutMapping("blogvn/{id}")
	public ResponseEntity<?>UpdateBlogVNE(@PathVariable Integer id, @RequestBody BlogVNE blogvne){
		BlogVNE blogs = blogVNDao.findById(id).orElseThrow();
		blogs.setAddress(blogvne.getAddress());
		blogs.setContent(blogvne.getContent());
		blogs.setDateSubmit(blogvne.getDateSubmit());
		blogs.setImage(blogvne.getImage());
		blogs.setNameTravel(blogvne.getNameTravel());
		blogs.setNation(blogvne.getNation());
		blogs.setPrice(blogvne.getPrice());
		return new ResponseEntity<>(this.blogVNService.UpdateBlog(blogs),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("blogvn/{id}")
	public Boolean DeleteBlogVn(@PathVariable Integer id) {
		blogVNService.DeleteId(id);
		return true;
	}
	
	@PostMapping("blogvn/upload/{id}")
	public ResponseEntity<?>UploadFile(@RequestParam MultipartFile file, @PathVariable Integer id){
		BlogVNE blogvne = blogVNDao.findById(id).get();
		String FileName = UserServiceException.UploadOneFile(file, upload);
		blogvne.setImage(FileName);
		blogVNDao.save(blogvne);
		return new ResponseEntity<>(blogvne,HttpStatus.ACCEPTED);
		
	}
}
