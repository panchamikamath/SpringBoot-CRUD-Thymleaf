package kamath.panchami.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kamath.panchami.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudents;
	
	@PostConstruct
	public void loadData() {
		theStudents = new ArrayList<>();
		theStudents.add(new Student("Panchami","Kamath"));
		theStudents.add(new Student("Gowthami","Kamath"));
		theStudents.add(new Student("Pavan","Kamath"));
	}

	@GetMapping("/students")
	public List<Student> getStudents(){
		return theStudents;
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudentById(@PathVariable int studentId) {
		
		if(studentId>=theStudents.size() || studentId<0)
			throw new StudentNotFoundException("Student Not Found with ID : " + studentId);
		return theStudents.get(studentId);
	}
	
}
