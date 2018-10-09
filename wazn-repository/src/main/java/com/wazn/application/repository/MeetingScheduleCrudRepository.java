package com.wazn.application.repository;

import com.wazn.application.entity.MeetingEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetingScheduleCrudRepository extends CrudRepository<MeetingEntity, String> {
}
