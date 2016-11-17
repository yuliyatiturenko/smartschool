package com.smartschool.rest.controller;


import com.smartschool.rest.model.Student;
import com.smartschool.rest.servise.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("school")
public class StudentController {


    @Autowired
    StudentService studentService;


    @RequestMapping("/students")
    public Map<String, List<Student>> getStudentsByClassId(@RequestParam(value = "class", defaultValue = "1") int classId) {

        Map<String, List<Student>> studentsMap = studentService.getStudentMap(classId);


        return studentsMap;
    }

}

