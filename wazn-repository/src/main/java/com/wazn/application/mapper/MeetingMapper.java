package com.wazn.application.mapper;

import com.wazn.application.entity.MeetingEntity;
import com.wazn.application.model.Meeting;

public interface MeetingMapper {

    Meeting toMeeting(MeetingEntity meetingEntity);

    MeetingEntity toMeetingEntity(Meeting meeting);
}
