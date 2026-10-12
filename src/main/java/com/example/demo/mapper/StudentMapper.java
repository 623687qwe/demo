package com.example.demo.mapper;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface StudentMapper {
    //查询所有学生信息
    @Select("select * from student")
    List<Student>findAll();

    //添加学生
    @Insert("insert into student(id,name,age)values(#{id},#{name},#{age})")
    int add(Student student);

    //通过id查找学生
    @Select("select * from student where id=#{id}")
    Student  findById(Integer id);

    //通过id删除学生
    @Delete("delete from student where id=#{id}")
    int delete(Integer id);

    //修改学生信息
    @Update("update student set name=#{name},age=#{age} where id=#{id}")
    int update(Student student);


}
