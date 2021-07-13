package com.spring.file.controller;

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

import com.spring.file.exception.UserServiceException;
import com.spring.file.model.Blog;
import com.spring.file.repository.BlogRepository;
import com.spring.file.service.BlogServiceImpl;


@RestController
@CrossOrigin("http://localhost:4200")
@RequestMapping("api/v1")
public class BlogController {
	
	@Autowired
	private BlogServiceImpl blogServiceImpl;
	
	@Autowired
	private BlogRepository blogRepository;
	
	
	private static String upload ="D:\\Project\\Angular\\Travel1_Manage\\src\\assets\\images";
	
	@GetMapping("blog")
	public List<Blog> GetAllBlog(){
		return blogRepository.findAll();
	}
	
	@PostMapping("blog")
	public ResponseEntity<?>AddBlog(@RequestBody Blog blog)throws Exception{
		String temp_emails= blog.getEmailCty();
		if(temp_emails != null &&!"". equals(temp_emails)) {
			Blog blogObj = blogServiceImpl.fetchBlogEntityByEmailCty(temp_emails);
			if(blogObj != null) {
				throw new Exception("user with" + temp_emails + "is already exit");
			}
		}
		return new ResponseEntity<>(this.blogServiceImpl.AddBlog(blog),HttpStatus.CREATED);
	}
	
	@PostMapping("blog/upload/{id}")
	public ResponseEntity<?>UploadFile(@RequestParam MultipartFile file1,@PathVariable Integer id){
		Blog blog = blogRepository.findById(id).get();
		String FileName1 = UserServiceException.UploadOneFile(file1, upload);
//		String FileName2 = UserServiceException.UploadOneFile(file2, upload);
//		String FileName3 = UserServiceException.UploadOneFile(file3, upload);
		blog.setImage1(FileName1);
//		blog.setImage2(FileName2);
//		blog.setImage3(FileName3);
		blogRepository.save(blog);
		return new ResponseEntity<>(blog,HttpStatus.ACCEPTED);
	}
	
	@GetMapping("blog/{id}")
	public ResponseEntity<?>GetBlog(@PathVariable Integer id){
		Blog blog = blogRepository.findById(id).orElseThrow();
		return  ResponseEntity.ok(blog);
	}
	
	@PutMapping("blog/{id}")
	public ResponseEntity<?>UpdateBlog(@PathVariable Integer id, @RequestBody Blog blog){
		Blog blogs = blogRepository.findById(id).orElseThrow();
		blogs.setAdsressCty(blog.getAdsressCty());
		blogs.setCompanyName(blog.getCompanyName());
		blogs.setEmailCty(blog.getEmailCty());
		blogs.setFareNumber(blog.getFareNumber());
		blogs.setImage1(blog.getImage1());
//		blogs.setImage2(blog.getImage2());
//		blogs.setImage3(blog.getImage3());
		blogs.setIntroduce1(blog.getIntroduce1());
		blogs.setIntroduce2(blog.getIntroduce2());
		blogs.setLetterFare(blog.getLetterFare());
		blogs.setLocation(blog.getLocation());
		blogs.setStatus(blog.getStatus());
		blogs.setPlaceName(blog.getPlaceName());
		return new ResponseEntity<>(this.blogServiceImpl.UpdateBlog(blogs),HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("blog/{id}")
	public Boolean DaleteBlog(@PathVariable Integer id) {
		blogServiceImpl.DeleteId(id);
		return true;
	}

}



































