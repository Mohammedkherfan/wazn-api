package com.wazn.application.controller;

import com.wazn.application.entity.AccountEntity;
import com.wazn.application.entity.DocumentEntity;
import com.wazn.application.entity.MeetingEntity;
import com.wazn.application.repository.AccountCrudRepository;
import com.wazn.application.repository.DocumentCrudRepository;
import com.wazn.application.repository.MeetingScheduleCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AccountsControllerGrid {

    @Autowired
    private AccountCrudRepository accountCrudRepository;

    @Autowired
    private DocumentCrudRepository documentCrudRepository;

    @Autowired
    private MeetingScheduleCrudRepository meetingScheduleCrudRepository;

    @RequestMapping("/dashboard")
    public ModelAndView getDashboard() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @RequestMapping("/getAccountData")
    public ModelAndView getAccountData() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<AccountEntity> allAccount = accountCrudRepository.findAll();
        modelAndView.addObject("allAccount",allAccount);
        modelAndView.setViewName("account");
        return modelAndView;
    }

    @RequestMapping("/getDocumentData")
    public ModelAndView getDocumentData() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<DocumentEntity> allDocument = documentCrudRepository.findAll();
        modelAndView.addObject("allDocument",allDocument);
        modelAndView.setViewName("document");
        return modelAndView;
    }

    @RequestMapping("/getMeetingData")
    public ModelAndView getMeetingData() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<MeetingEntity> allMeeting = meetingScheduleCrudRepository.findAll();
        modelAndView.addObject("allMeeting",allMeeting);
        modelAndView.setViewName("meeting");
        return modelAndView;
    }
}
