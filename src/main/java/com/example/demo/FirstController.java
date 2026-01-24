package com.example.demo;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
public class FirstController {

    private final StudentRepository studentRepository;

    public FirstController(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @GetMapping("/hello")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String holloController() {
        return "Hello from the other side";
    }
    
    @GetMapping("/")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public String welcome() {
        return "Welcome newbie";
    }

    @GetMapping("/hello/{userName}")
    public String getPath(
            @PathVariable("userName") String param,
            @RequestParam("title") String title
    ) {
        return "Hello " + title + param;
    }
    
    @PostMapping("/create-student")
    @ResponseStatus(HttpStatus.CREATED)
    public Student create(
    @RequestBody Student student
    ) {
        return studentRepository.save(student);
    }

    @GetMapping("/student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public Student getStudentById(
            @PathVariable("studentId") Integer id
    ) {
        return studentRepository.findById(id).orElse(null);
    }
    
    @GetMapping("/students")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> getStudents(
    ) {
        return studentRepository.findAll();
    }

    @GetMapping("/student/search/{studentName}")
    @ResponseStatus(HttpStatus.OK)
    public List<Student> searchStudent(
            @PathVariable ("studentName") String param
    ) {
        return studentRepository.findAllByFirstNameLike(param);
    }
    
    @DeleteMapping("/student/{studentId}")
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(
        @PathVariable ("studentId") Integer id
    ) {
        studentRepository.deleteById(id);
    }
    
}
