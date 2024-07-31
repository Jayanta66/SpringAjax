package com.example.emp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;




@RestController
@RequestMapping("Student")
public class StudentController {

     @Autowired
        private com.example.student.service.StudentService service;

    private com.example.student.repository.StudentRepository studentRepository;

        @RequestMapping(value = "/save", method = RequestMethod.POST)
        public String saveStudent(@ModelAttribute("student") com.example.student.Entity.Student std) {
            service.save(std);
            return "{\"status\":\"success\"}";
        }

        @RequestMapping(value = "/list", method = RequestMethod.GET)
        public List<com.example.student.Entity.Student> listStudents() {
            List<com.example.student.Entity.Student> liststudent = service.listAll();
            return liststudent;
        }


    @RequestMapping(value = "/get/{id}")
    public com.example.student.Entity.Student getStudentPage(@PathVariable(name = "id") int id) {
        com.example.student.Entity.Student stdd = service.getid(id);
        return stdd;
    }


    @PostMapping(value = "/edit/{id}")
    public String updateStudent(@PathVariable("id") long id,  com.example.student.Entity.Student student)
    {
        student.setId(id);
        service.save(student);
        return "{\"status\":\"success\"}";

    }

        @RequestMapping("/delete/{id}")
        public String deletestudent(@PathVariable(name = "id") int id) {
            service.delete(id);
            return "{\"status\":\"success\"}";
        }

}