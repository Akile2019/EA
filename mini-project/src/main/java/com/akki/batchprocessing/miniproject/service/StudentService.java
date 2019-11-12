package com.akki.batchprocessing.miniproject.service;


import com.akki.batchprocessing.miniproject.domain.Student;

import java.util.List;

public interface StudentService {
    List<Student> getAll();
    void save(List<? extends Student> students);
}
