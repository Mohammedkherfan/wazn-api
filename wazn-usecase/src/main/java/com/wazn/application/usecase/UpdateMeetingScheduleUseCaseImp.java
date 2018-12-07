package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.Meeting;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.UpdateMeetingScheduleRequest;
import com.wazn.application.response.UpdateMeetingScheduleResponse;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateMeetingScheduleUseCaseImp implements UpdateMeetingScheduleUseCase {

    private AccountRepository accountRepository;

    public UpdateMeetingScheduleUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public UpdateMeetingScheduleResponse updateMeeting(String mobile, UpdateMeetingScheduleRequest request) {
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
            Meeting meeting = new Meeting.Builder()
                    .mobile(mobile)
                    .startDate(LocalDateTime.parse(request.getStartDate(), formatter))
                    .note(request.getNote())
                    .build();
            return new UpdateMeetingScheduleResponse(accountRepository.updateMeeting(meeting));
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
