package com.example.demo.Service;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.data.domain.Page;
import com.example.demo.Model.StudentModel;
import com.example.demo.Repository.StudentRepository;
@Service

public class StudentService 
	{
		@Autowired(required=true)
		StudentRepository stRepo;
		
		public StudentModel saveDetails(StudentModel e)
		{
			return stRepo.save(e);
		}
		public List<StudentModel> getDetails()
		{
			return stRepo.findAll();
		}
		public StudentModel updateDetails(StudentModel e1)
		{
			return stRepo.saveAndFlush(e1);
		}
		public void deleteDetails(int id)
		{
			stRepo.deleteById(id);
		}
		public List<StudentModel> getSorted(String field)
		{
			return stRepo.findAll(Sort.by(Sort.Direction.ASC,field));
		}
		public List<StudentModel> getWithPagination(@PathVariable int offset, @PathVariable int pageSize) {
			Page<StudentModel> page =stRepo.findAll(PageRequest.of(offset, pageSize));
			return page.getContent();
		}   
		
	}