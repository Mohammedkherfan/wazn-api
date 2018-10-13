package com.wazn.application.usecase;

import com.wazn.application.exception.MeetingScheduleException;
import com.wazn.application.model.Meeting;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.response.GetMeetingScheduleResponse;

public class GetMeetingScheduleUseCaseImp implements GetMeetingScheduleUseCase {

    private AccountRepository accountRepository;

    public GetMeetingScheduleUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public GetMeetingScheduleResponse getMeeting(String mobile) {
        try {
            Meeting meeting = accountRepository.getMeeting(mobile);
            return new GetMeetingScheduleResponse(meeting.getMobile(), meeting.getStartDate(), meeting.getEndDate(), meeting.getNote());
        }catch (Exception ex) {
            throw new MeetingScheduleException(ex.getMessage());
        }
    }
}
