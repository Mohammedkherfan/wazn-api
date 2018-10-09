package com.wazn.application.usecase;

import com.wazn.application.response.ListMeetingResponse;

import java.util.List;

public interface ListMeetingUseCase {

    List<ListMeetingResponse> listMeeting();
}
