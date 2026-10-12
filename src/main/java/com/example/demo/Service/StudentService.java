package com.example.demo.Service;

import com.example.demo.Util.StudentException;
import com.example.demo.entity.Student;
import com.example.demo.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;
//查询所有学生信息
    public List<Student>findAll(){
        return studentMapper.findAll();
    }

  //添加学生
  public void addStudent(Student student){
if(student==null){
    throw new StudentException("学生对象不能为空");
}
if(student.getName()==null || student.getAge()==null || student.getId()==null){
    throw  new StudentException("学生信息不全，不能添加");
}
if(student.getAge()<0 || student.getAge()>22){
    throw new StudentException("学生年龄应该在0-22岁之间");
}
Student existStudent=studentMapper.findById(student.getId());
if(existStudent!=null){
    throw new StudentException("该学生id已存在");
}
studentMapper.add(student);
  }

  //删除学生
    public void deleteStudent(Integer id){
        Student student=studentMapper.findById(id);
        if(student==null){
            throw new StudentException("该学生不存在");
        }
        studentMapper.delete(id);
    }

    // 修改学生信息
    public void updateStudent(Student student) { // 传入包含新数据的对象
        Student existStudent = studentMapper.findById(student.getId());
        if (existStudent == null) {
            throw new StudentException("该学生不存在，无法修改");
        }
        if(student==null){
            throw new StudentException("学生对象不能为空");
        }
        if(student.getName()==null || student.getAge()==null || student.getId()==null){
            throw  new StudentException("学生信息不全，不能修改");
        }
        if(student.getAge()<0 || student.getAge()>22){
            throw new StudentException("学生年龄应该在0-22岁之间");
        }

        studentMapper.update(student); //
    }

    //查询所有学生信息
    public List<Student> findAllStudent(){
        return studentMapper.findAll();
    }

    //根据id查询学生信息
    public Student findById(Integer id){
       return studentMapper.findById(id);
    }

    //批量插入
    @Transactional
    public void batchAddStudents(List<Student>students){
        for(Student stu:students){
            studentMapper.add(stu);
        }
    }
}
