package com.autocatsms.categorisedsms.services;

import com.autocatsms.categorisedsms.model.CategorisedSms;
import com.autocatsms.categorisedsms.model.SmsRepository;
import com.autocatsms.keyword.model.KeywordTable;
import com.autocatsms.keyword.service.KeywordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.*;
//import java.util.Objects;

import static org.springframework.http.HttpStatus.NOT_FOUND;
@Service
public class SmsService {
    private final SmsRepository smsRepository;
    private final KeywordService keywordService;
    @Autowired
    public SmsService(SmsRepository smsRepository, KeywordService keywordService) {
        this.smsRepository = smsRepository;
        this.keywordService = keywordService;
    }
    public List<CategorisedSms> getSms() {
        return this.smsRepository.findAll();
    }
    public void addSms(CategorisedSms categorisedsms) {
        CategorisedSms sms = smsRepository.findSmsById(categorisedsms.getId());
        if (Objects.nonNull(sms)) {
            throw new IllegalStateException("already exist");
        }

        // get all the keywords
        List<KeywordTable> keywords = keywordService.getKeywords();


        // match keyword with merchant text

        List<KeywordTable> matchedKeywords = new ArrayList<>();

        for(int i=0;i<keywords.size();i++){
            String merchantText = categorisedsms.getMerchant_text();
            KeywordTable keywordtable = keywords.get(i);

            if(merchantText.replaceAll("\\s","").toLowerCase().contains(keywordtable.getKeyword().toLowerCase())){
                 categorisedsms.setKeyword_id(keywordtable.getId());
                 matchedKeywords.add(keywords.get(i));
            }
        }
        String str;
        int largeststring = 0;
        int index=0;
        for(int i=0;i<matchedKeywords.size();i++){

            if(matchedKeywords.get(i).getKeyword().length()>largeststring){

                largeststring=matchedKeywords.get(i).getKeyword().length();

                index = i;

            }

        }
        categorisedsms.setKeyword_id(matchedKeywords.get(index).getId());




        // save keyword id of matched keyword with sms
        smsRepository.save(categorisedsms);
    }
    
    public void deleteSms(Long id) {
        boolean find = smsRepository.existsById(id);
        if (!find) {
            //throw new IllegalArgumentException("student not found");
            throw new ResponseStatusException(NOT_FOUND, "Unable to find resource");
        }
        smsRepository.deleteById(id);
    }
}