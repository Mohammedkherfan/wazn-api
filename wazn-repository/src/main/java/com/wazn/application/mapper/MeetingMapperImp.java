package com.wazn.application.mapper;

import com.wazn.application.entity.MeetingEntity;
import com.wazn.application.model.Meeting;

public class MeetingMapperImp implements MeetingMapper {

    @Override
    public Meeting toMeeting(MeetingEntity meetingEntity) {
        return new Meeting.Builder()
                .mobile(meetingEntity.getMobile())
                .note(meetingEntity.getNote())
                .startDate(meetingEntity.getStartDate())
                .status(meetingEntity.getStatus())
                .getBuild();
    }

    @Override
    public MeetingEntity toMeetingEntity(Meeting meeting) {
        MeetingEntity meetingEntity = new MeetingEntity();
        meetingEntity.setMobile(meeting.getMobile());
        meetingEntity.setStartDate(meeting.getStartDate());
        meetingEntity.setNote(meeting.getNote());
        meetingEntity.setStatus(meeting.getStatus());
        return meetingEntity;
    }
}
