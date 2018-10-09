package com.wazn.application.usecase;

import com.wazn.application.request.AddMeetingScheduleRequest;
import com.wazn.application.response.AddMeetingScheduleResponse;

public interface AddMeetingScheduleUseCase {

    AddMeetingScheduleResponse addMeeting(String mobile, AddMeetingScheduleRequest request);
}
