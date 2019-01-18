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
            if (meeting.getStatus() == 0) {
                System.out.println(LocalDateTime.now());
                if (LocalDateTime.now().isAfter(meeting.getStartDate())) {
                    Meeting updateMeeting = new Meeting.Builder().mobile(meeting.getMobile()).note(meeting.getNote()).startDate(meeting.getStartDate()).status(1).getBuild();
                    accountRepository.updateMeeting(updateMeeting);
                    return Boolean.TRUE;
                }else
                    return Boolean.FALSE;
            } else
                return Boolean.FALSE;

        }catch (Exception ex) {
            throw new MeetingScheduleException(ex.getMessage());
        }
    }
}
