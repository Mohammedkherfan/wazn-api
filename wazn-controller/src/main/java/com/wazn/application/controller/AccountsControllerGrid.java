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

    @RequestMapping("/getAccountData")
    public ModelAndView getData() {
        ModelAndView modelAndView = new ModelAndView();
        Iterable<AccountEntity> allAccount = accountCrudRepository.findAll();
        Iterable<DocumentEntity> allDocument = documentCrudRepository.findAll();
        Iterable<MeetingEntity> allMeeting = meetingScheduleCrudRepository.findAll();
        modelAndView.addObject("allAccount",allAccount);
        modelAndView.addObject("allDocument",allDocument);
        modelAndView.addObject("allMeeting",allMeeting);
        modelAndView.setViewName("account");
        return modelAndView;
    }
}
