package com.autocatsms.categorisedsms.controller;
import com.autocatsms.categorisedsms.model.CategorisedSms;
import com.autocatsms.categorisedsms.services.SmsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
//@RequestMapping(path = "api/students")
@RequestMapping(path = "api/sms")
public class SmsController {
    private final SmsService smsService;




    @Autowired
    public SmsController(SmsService smsService){
        this.smsService = smsService;
    }


    //@GetMapping(path = "allStudents")
    @GetMapping(path = "allSms")
    public List<CategorisedSms> getAllSms(){

        return this.smsService.getSms();
    }


    //@PostMapping(path = "addStudent")
    @PostMapping(path = "addSms")
    public void addSms(@RequestBody CategorisedSms categorisedsms){
        this.smsService.addSms(categorisedsms);
    }


    //@DeleteMapping(path = "delete/{studentId}")
    @DeleteMapping(path = "delete/{smsId}")
    public void deleteSms(@PathVariable("smsId") Long id){
        smsService.deleteSms(id);
    }



//    @PutMapping(path = "updateStudent/{studentId}")
//    public void upDateStudent(@PathVariable("studentId") Long id,
//                              @RequestBody(required = false) Student student) {
//        student.setId(id);
//        studentService.updateStudent(student);
//    }
}
