package com.circleci.demojavaspring.model;

import java.util.*;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Quote {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String quote;

    private List<byte[]> leak_buffers;

    public Quote() {
        for(int i=0; i<10000; i++){
            leak_buffers.add(new byte[1024 * 1024 * 1024]);
        }
    }
    
    public Integer getId() {
        return id;
    }

    public List<byte[]> getLeak_buffers() {
        return leak_buffers;
    }

    public void setLeak_buffers(List<byte[]> leak_buffers) {
        this.leak_buffers = leak_buffers;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

}