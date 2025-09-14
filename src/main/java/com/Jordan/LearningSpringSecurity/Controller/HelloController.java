package com.Jordan.LearningSpringSecurity.Controller;

import com.Jordan.LearningSpringSecurity.Model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
//@RequestMapping("")
public class HelloController {

    final private List<Student> studentData = new ArrayList<>(List.of(
            new Student("Shabbu",51,'A'),
            new Student("Dabbu",42,'B'),
            new Student("Gabbu",30,'A')
    ));

    @GetMapping
    public StringBuilder getWelcome(HttpServletRequest httpServletRequest){
        StringBuilder stringBuilder = new StringBuilder("Hello! Welcome to Jordan's Website!!! \n \n").append(httpServletRequest.getSession().getId());
        return stringBuilder;
    }

    @GetMapping("/students")
    public List<Student> getStudentData(){
        return studentData;
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest httpServletRequest){
        return (CsrfToken) httpServletRequest.getAttribute("_csrf");
    }

    @PostMapping("/students")
    public Student createStudent(@RequestBody Student student){
        studentData.add(student);
        return student;
    }
}






