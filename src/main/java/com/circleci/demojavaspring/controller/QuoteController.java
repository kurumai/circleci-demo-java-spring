package com.circleci.demojavaspring.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.circleci.demojavaspring.model.Quote;
import com.circleci.demojavaspring.repository.QuoteRepository;

@Controller
@RequestMapping
public class QuoteController {

    private List<byte[]> leak_buffers = new ArrayList<byte[]>();

    @Autowired
    private QuoteRepository quoteRepository;

    @PostMapping("/quote/add")
    public ModelAndView addNewQuote(@RequestParam String quote) {
        Quote q = new Quote();
        q.setQuote(quote);
        quoteRepository.save(q);
        return new ModelAndView("redirect:/");
    }

    @GetMapping("/")
    public ModelAndView list() {
        List<Quote> quotes = quoteRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("quotes", quotes);

        //leak_buffers.add(new byte[1024 * 1024* 10]);

        return modelAndView;
    }
}