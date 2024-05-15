package com.autocatsms.keyword.service;
import com.autocatsms.keyword.model.KeywordRepository;
import com.autocatsms.keyword.model.KeywordTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class KeywordService {
    private final KeywordRepository keywordRepository;
    @Autowired
    public KeywordService(KeywordRepository keywordRepository){this.keywordRepository=keywordRepository;}
    public List<KeywordTable> getKeywords(){return this.keywordRepository.findAll();}
}