package com.akki.batchprocessing.miniproject.batch;

import com.akki.batchprocessing.miniproject.domain.Student;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

@Component
public class Processor implements ItemProcessor<Student, Student> {

    private int currentYear = LocalDate.now().getYear();
    private int day =1;
    private int month =1;

    public Processor() {

    }

    @Override
    public Student process(Student student) throws Exception {

        int age = Integer.parseInt(student.getAge());
        int year = currentYear - age;

        StringBuilder dob = new StringBuilder();
        dob.append(year);
        dob.append("-");
        dob.append(month);
        dob.append("-");
        dob.append(day);

        student.setAge(dob.toString());

        return student;
    }
}
