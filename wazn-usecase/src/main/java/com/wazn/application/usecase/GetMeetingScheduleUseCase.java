package com.wazn.application.usecase;

import com.wazn.application.response.GetMeetingScheduleResponse;

public interface GetMeetingScheduleUseCase {

    GetMeetingScheduleResponse getMeeting(String mobile);
}
