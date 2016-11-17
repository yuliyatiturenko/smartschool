package com.smartschool.rest.servise;


import com.smartschool.rest.model.Student;
import com.smartschool.rest.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getStudents() {
        return studentRepository.getStudents();
    }

    public List<Student> getStudentsByClassId(int id) {
        return studentRepository.getStudentsByClassId(id);
    }
    public Map<String, List<Student>> getStudentMap(int id) {

        List<Student> students = getStudentsByClassId(id);
        String tableName = "students";
        Map<String, List<Student>> studentsMap = new HashMap<String, List<Student>>();
        studentsMap.put(tableName,students);
        return studentsMap;
    }

}
