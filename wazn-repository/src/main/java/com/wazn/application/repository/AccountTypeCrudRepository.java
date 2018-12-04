package com.wazn.application.repository;

import com.wazn.application.entity.AccountTypeEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountTypeCrudRepository extends CrudRepository<AccountTypeEntity, String> {
}
