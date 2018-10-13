package com.wazn.application.usecase;

import com.wazn.application.exception.MeetingScheduleException;
import com.wazn.application.model.Meeting;
import com.wazn.application.repository.AccountRepository;

import java.time.LocalDateTime;

public class CheckMeetingTimeUseCaseImp implements CheckMeetingTimeUseCase {

    private AccountRepository accountRepository;

    public CheckMeetingTimeUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Boolean checkMeetingTime(String mobile) {
        try {
            Meeting meeting = accountRepository.getMeeting(mobile);
            if (LocalDateTime.now().isAfter(meeting.getStartDate()) && LocalDateTime.now().isBefore(meeting.getEndDate()))
                return Boolean.TRUE;
            else
                return Boolean.FALSE;
        }catch (Exception ex) {
            throw new MeetingScheduleException(ex.getMessage());
        }
    }
}
