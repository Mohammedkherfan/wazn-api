package com.wazn.application.usecase;

import com.wazn.application.exception.MeetingScheduleException;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.response.ListMeetingResponse;

import java.util.ArrayList;
import java.util.List;

public class ListMeetingUseCaseImp implements ListMeetingUseCase {

    private AccountRepository accountRepository;

    public ListMeetingUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public List<ListMeetingResponse> listMeeting() {
        try {
            List<ListMeetingResponse> list = new ArrayList<>();
            accountRepository.listMeeting().forEach(e -> {
                list.add(new ListMeetingResponse(e.getMobile(), e.getStartDate(), e.getEndDate(), e.getNote()));
            });
            return list;
        }catch (Exception ex) {
            throw new MeetingScheduleException(ex.getMessage());
        }
    }
}
