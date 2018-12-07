package com.wazn.application.test.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.wazn.application.controller.AccountController;
import com.wazn.application.gateway.AccountGateway;
import com.wazn.application.repository.AccountCrudRepository;
import com.wazn.application.request.AddAccountRequest;
import com.wazn.application.request.AddDocumentRequest;
import com.wazn.application.request.AddMeetingScheduleRequest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;
import java.time.LocalDateTime;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AccountController.class)
public class TestAccountController {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountCrudRepository repository;

    @MockBean
    private AccountGateway accountGateway;

    public static String asJsonString(Object object) throws JsonProcessingException {
        return new String(new ObjectMapper().writeValueAsString(object));
    }

    @Test
    public void whenAddAccount_ThenReturnAccountThatAdded() throws Exception {

        mockMvc.perform(post("/wazn/accounts/addAccount").content(asJsonString(new AddAccountRequest("mohammed.kherfan@gmail.com", "+962798988910", "Mohammed Kherfan", "P@ssw0rd", "P@ssw0rd"))).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void whenGetAccount_ThenReturnAccountThatGet() throws Exception {
        mockMvc.perform(get("/wazn/accounts/+962798988910/find").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void whenVerifyAccount_ThenReturnAccountThatVerified() throws Exception {
        mockMvc.perform(get("/wazn/accounts/+962798988910/00000/verify").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void whenAddDocument_ThenReturnAccountThatAdded() throws Exception {
        mockMvc.perform(post("/wazn/accounts/+962798988910/addDocument").content(asJsonString(new AddDocumentRequest("V-doc", "073955554", "UAE", "1561656", "53153", LocalDate.now().toString(), "own", "help desk commint", LocalDate.now().minusYears(22).toString(), "Male", "Jordanian", new byte[]{1}, new byte[]{1}, new byte[]{2}, LocalDateTime.now().toString(), "Office", "Mohammed", Boolean.TRUE, Boolean.TRUE, Boolean.TRUE, Boolean.TRUE))).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void whenLogin_ThenReturnAccountThatLoggedIn() throws Exception {
        mockMvc.perform(post("/wazn/accounts/+962798988910/P@ssw0rd/login").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void whenGenerateReport_ThenReturnAccountThatGenerated() throws Exception {
        mockMvc.perform(post("/wazn/accounts/+962798988910/print").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void whenAddMeeting_ThenReturnMeetingThatAdded() throws Exception {
        mockMvc.perform(post("/wazn/accounts/+962798988910/addMeeting").content(asJsonString(new AddMeetingScheduleRequest(LocalDateTime.now().plusDays(1).toString(), "note"))).contentType(MediaType.APPLICATION_JSON)).andExpect(status().isCreated());
    }

    @Test
    public void whenListMeeting_ThenReturnListMeetingThatGet() throws Exception {
        mockMvc.perform(get("/wazn/accounts/listMeeting").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }
}
