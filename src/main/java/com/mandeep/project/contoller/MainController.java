package com.mandeep.project.contoller;

import java.util.List;
	
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mandeep.project.dao.StudentDao;
import com.mandeep.project.model.Student;

@RestController
@CrossOrigin(origins="http://localhost:4200") 
@RequestMapping("/api")
public class MainController {

	@Autowired
	private StudentDao studentDao;

	@PostMapping("/save")
	public Student create(@RequestBody Student student) {
		return studentDao.save(student);
	}

	@GetMapping("/students")
	public List<Student> findAll() {
		return studentDao.findAll();
	}

	@DeleteMapping("/delete/{student_id}")
	public List<Student> delete(@PathVariable("student_id") int student_id) {
		studentDao.deleteById(student_id);
		return studentDao.findAll();
	}

	@PutMapping("/update/{student_id}")
	public Student update(@PathVariable("student_id") int student_id, @RequestBody Student userObject) {
		Student user = studentDao.findById(student_id).orElse(new Student());
		user.setStudent_name(userObject.getStudent_name());
		user.setStudent_email(userObject.getStudent_email());
		user.setStudent_branch(userObject.getStudent_branch());
		return studentDao.save(user);
	}

	@GetMapping("/find/{student_id}")
	public Student findByUserId(@PathVariable("student_id") int student_id) {
		return studentDao.findById(student_id).orElse(new Student());
	}
}
