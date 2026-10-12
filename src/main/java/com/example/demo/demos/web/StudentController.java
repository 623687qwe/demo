package com.example.demo.demos.web;

import com.example.demo.Service.StudentService;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {
    @Autowired
    private StudentService studentService;

    @GetMapping
    public List<Student> findAll() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student findById(@PathVariable Integer id){
        return studentService.findById(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Integer id){
        studentService.deleteStudent(id);
        return "删除成功";
    }

    @PostMapping("/batch")
    public String batchInsert(@RequestBody List<Student>list){
        studentService.batchAddStudents(list);
        return "批量插入成功";
    }

    @PostMapping("/add")
    public String add(@RequestBody Student student){
        studentService.addStudent(student);
        return  "添加成功";
    }
    @PutMapping("/update")
    public String update(@RequestBody Student student){
        studentService.updateStudent(student);
        return "修改成功";
    }
}


