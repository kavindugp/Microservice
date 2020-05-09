package com.example.krish.Service;

import com.example.krish.Model.Student;
import com.example.krish.Repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.PublicKey;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentrepository;


    public Student save(Student student) {

      return studentrepository.save(student);

    }

    public Student fetchStudentById(int id) {
        Optional<Student> student= studentrepository.findById(id);

        if(student.isPresent()){
            return student.get();
        }
        return null;
    }

    @Override
    public List<Student> findAllUsers() {
        List <Student> allStudnt=studentrepository.findAll();
        return allStudnt;
    }

    @Override
    public String updateUser(Student UpdateduserDao) {

        String msg=null;
        if (UpdateduserDao.getId() != 7){
            studentrepository.save(UpdateduserDao);
            msg="updated";
        }
        return msg;
    }

    @Override
    public void delete(int id) {
        studentrepository.deleteById(id);
    }
}
