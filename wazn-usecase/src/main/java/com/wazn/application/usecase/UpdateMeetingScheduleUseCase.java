package com.wazn.application.usecase;

import com.wazn.application.request.UpdateMeetingScheduleRequest;
import com.wazn.application.response.UpdateMeetingScheduleResponse;

public interface UpdateMeetingScheduleUseCase {

    UpdateMeetingScheduleResponse updateMeeting(String mobile, UpdateMeetingScheduleRequest request);
}
