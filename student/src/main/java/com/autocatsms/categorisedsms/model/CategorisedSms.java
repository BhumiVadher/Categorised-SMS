package com.autocatsms.categorisedsms.model;

import jakarta.persistence.*;

@Entity
@Table(name = "categorised_sms")
public class CategorisedSms {
    @Id
    @SequenceGenerator(
            name = "categorised_sms_index",
            sequenceName = "categorised_sms_index",
            allocationSize = 1
    )
//    @GeneratedValue(
//            strategy = GenerationType.SEQUENCE,
//            generator = "categorised_sms_index"
//    )
    private Long id;
//    private String name;
//    private Long age;
//    private String dob;
//    private String email;
    private String sms;
    private String merchant_text;
    private Long keyword_id;
    
    public CategorisedSms(){}

//    public Student(Long id,String name,Long age,String dob,String email){
//        this.id=id;
//        this.name=name;
//        this.dob=dob;
//        this.email=email;
//    }
//    public Student(String name, Long age,String dob,String email){
//        this.name=name;
//        this.dob=dob;
//        this.email=email;
//        this.age=age;
//    }
    public CategorisedSms(Long id, String sms, String merchant_text, Long keyword_id){
        this.id=id;
        this.sms=sms;
        this.merchant_text=merchant_text;
        this.keyword_id=keyword_id;
    }

    public Long getId(){
        return id;
    }

    public void  setId(Long id){
        this.id=id;
    }
    public String getSms(){return  sms;}
    public void setSms(String sms){this.sms=sms;
    }
    public String getMerchant_text(){return merchant_text;}
    public void setMerchant_text(String merchant_text){this.merchant_text=merchant_text;}
    public  Long getKeyword_id(){return keyword_id;}
    public void setKeyword_id(Long keyword_id){this.keyword_id=keyword_id;}

//    public String getName(){
//        return name;
//    }
//
//    public void setName(String name){
//        this.name=name;
//    }
//
//    public String getDob(){
//        return dob;
//    }
//
//    public void setDob(String dob){
//        this.dob=dob;
//    }
//
//    public String getEmail(){
//        return email;
//    }
//
//    public void setEmail(String email){
//        this.email=email;
//    }
//
//    public Long getAge() { return age; }
//
//    public void setAge(Long age) { this.age=age; }

}