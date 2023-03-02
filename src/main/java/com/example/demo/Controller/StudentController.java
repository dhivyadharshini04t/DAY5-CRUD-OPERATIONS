package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.Service.StudentService;
import com.example.demo.Model.StudentModel;
@RestController

public class StudentController {
	@Autowired
	StudentService stuSer;
	@PostMapping("/add")
	public StudentModel addInfo( @RequestBody StudentModel st) {
		return stuSer.saveDetails(st);
	}
	@GetMapping("/show")
	public List<StudentModel> fetchDetails()
	{
		return stuSer.getDetails();
	}
	@PutMapping("/Update")
	public StudentModel updateInfo(@RequestBody StudentModel st1)
	{
		return stuSer.updateDetails(st1);
	}
	@DeleteMapping("/delete/{sid}")
	public String deleteInfo(@PathVariable("sid") int sid){
	stuSer.deleteDetails(sid);
	return "Deleted details";
	}
	//sorting
	@GetMapping("/product/{field}")
	public List<StudentModel> getWithSort(@PathVariable String field) {
	return stuSer.getSorted(field);
			}

	// pagination
	@GetMapping("/u/{offset}/{pageSize}")
	public List<StudentModel> productsWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
	return stuSer.getWithPagination(offset, pageSize);
			}
	
	
}