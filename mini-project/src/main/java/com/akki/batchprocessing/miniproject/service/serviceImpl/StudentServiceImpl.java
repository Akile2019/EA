package com.akki.batchprocessing.miniproject.service.serviceImpl;

import com.akki.batchprocessing.miniproject.domain.Student;
import com.akki.batchprocessing.miniproject.repository.StudentRepo;
import com.akki.batchprocessing.miniproject.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public List<Student> getAll() {
        return studentRepo.findAll();
    }

    @Override
    public void save(List<? extends Student> students) {
        studentRepo.saveAll(students);
    }
}
