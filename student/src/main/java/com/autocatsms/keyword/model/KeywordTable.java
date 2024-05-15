package com.autocatsms.keyword.model;

import jakarta.persistence.*;

@Entity
@Table(name = "keyword_table")
public class KeywordTable {
    @Id
    @SequenceGenerator(
            name = "keyword_index",
            sequenceName = "keyword_index",
            allocationSize = 1
    )
    private  Long id;

    @Column(name="merchant_id")
    private Long merchantId;

    @Column(name="category_id")
    private Long categoryId;
    private String keyword;
    public KeywordTable(Long id, Long merchantId, Long categoryId, String keyword){
        this.id=id;
        this.merchantId=merchantId;
        this.categoryId=categoryId;
        this.keyword=keyword;
    }

    public KeywordTable(){

    }

    public Long getId(){return id;}
    public void setId(Long id){this.id=id;}
    public Long getMerchantId(){return merchantId;}
    public void setMerchantId(Long merchantId){this.merchantId=merchantId;}
    public Long getCategoryId(){return categoryId;}
    public void setCategoryId(Long categoryId){this.categoryId=categoryId;}
    public String getKeyword(){return keyword;}
    public void setKeyword(String keyword){this.keyword=keyword;}


}
