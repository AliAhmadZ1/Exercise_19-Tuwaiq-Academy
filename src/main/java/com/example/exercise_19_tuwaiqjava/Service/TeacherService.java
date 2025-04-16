package com.example.exercise_19_tuwaiqjava.Service;

import com.example.exercise_19_tuwaiqjava.ApiResponse.ApiException;
import com.example.exercise_19_tuwaiqjava.Model.Teacher;
import com.example.exercise_19_tuwaiqjava.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;


    public List<Teacher> getAllTeachers(){
        if (teacherRepository.findAll().isEmpty())
            throw new ApiException("there are no teachers");
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher){
        Teacher teacherEmailExist = teacherRepository.findTeacherByEmail(teacher.getEmail());
        if (teacherEmailExist!=null)
            throw new ApiException("email is already exist");
        teacherRepository.save(teacher);
    }

    public void updateTeacher(Integer id, Teacher teacher){
        Teacher teacherEmailExist = teacherRepository.findTeacherByEmail(teacher.getEmail());
        Teacher oldTeacher = teacherRepository.findTeacherById(id);
        if (oldTeacher==null)
            throw new ApiException("teacher not found");
        if (teacherEmailExist!=null&&teacherEmailExist.getId()!= oldTeacher.getId())
            throw new ApiException("email is already used");
        oldTeacher.setAge(teacher.getAge());
        oldTeacher.setName(teacher.getName());
        oldTeacher.setSalary(teacher.getSalary());
        oldTeacher.setEmail(teacher.getEmail());
        teacherRepository.save(oldTeacher);
    }

    public void deleteTeacher(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null)
            throw new ApiException("teacher not found");
        teacherRepository.delete(teacher);
    }

    public Teacher teacherDetails(Integer id){
        Teacher teacher = teacherRepository.findTeacherById(id);
        if (teacher==null)
            throw new ApiException("teacher not found");
        return teacher;
    }

}
