package com.akki.batchprocessing.miniproject.batch;

import com.akki.batchprocessing.miniproject.domain.Student;
import com.akki.batchprocessing.miniproject.service.StudentService;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DBWriter implements ItemWriter<Student> {

    @Autowired
    private StudentService studentService;

    @Override
    public void write(List<? extends Student> students) throws Exception {

        System.out.println("Data Saved for Users: " + students);
        studentService.save(students);
    }
}
