package com.akki.batchprocessing.miniproject.controller;

import com.akki.batchprocessing.miniproject.domain.Student;
import com.akki.batchprocessing.miniproject.service.StudentService;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.batch.core.*;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.batch.core.repository.JobExecutionAlreadyRunningException;
import org.springframework.batch.core.repository.JobInstanceAlreadyCompleteException;
import org.springframework.batch.core.repository.JobRestartException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/process")
public class BatchController {

    @Autowired
    StudentService studentService;

    @RequestMapping(value = {"/"})
    public String homePage() {
        return "index";
    }


    @Autowired
    JobLauncher jobLauncher;

    @Autowired
    Job job;

    @PostMapping("/result")
    public String load(Model model) throws JobParametersInvalidException, JobExecutionAlreadyRunningException, JobRestartException, JobInstanceAlreadyCompleteException {

        Map<String, JobParameter> maps = new HashMap<>();
        maps.put("time", new JobParameter(System.currentTimeMillis()));
        JobParameters parameters = new JobParameters(maps);
        JobExecution jobExecution = jobLauncher.run(job, parameters);

        System.out.println("JobExecution: " + jobExecution.getStatus());

        System.out.println("Batch is Running...");
//        while (jobExecution.isRunning()) {
//            System.out.println("...");
//        }

        List<Student> students = studentService.getAll();
        model.addAttribute("students", students);

        return "result";
    }
}
