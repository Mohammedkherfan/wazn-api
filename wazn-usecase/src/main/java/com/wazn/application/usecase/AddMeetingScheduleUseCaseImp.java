package com.wazn.application.usecase;

import com.wazn.application.exception.MeetingScheduleException;
import com.wazn.application.model.Meeting;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.AddMeetingScheduleRequest;
import com.wazn.application.response.AddMeetingScheduleResponse;

import java.time.LocalDateTime;

public class AddMeetingScheduleUseCaseImp implements AddMeetingScheduleUseCase {

    private AccountRepository accountRepository;

    public AddMeetingScheduleUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AddMeetingScheduleResponse addMeeting(String mobile, AddMeetingScheduleRequest request) {
        try {
            Meeting meeting = new Meeting.Builder()
                    .mobile(mobile)
                    .startDate(LocalDateTime.parse(request.getStartDate()))
                    .endDate(LocalDateTime.parse(request.getEndDate()))
                    .note(request.getNote())
                    .build();
            return new AddMeetingScheduleResponse(accountRepository.addMeeting(meeting));
        }catch (Exception ex) {
            throw new MeetingScheduleException(ex.getMessage());
        }
    }
}
