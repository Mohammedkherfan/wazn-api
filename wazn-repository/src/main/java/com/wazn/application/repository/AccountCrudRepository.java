package com.wazn.application.repository;

import com.wazn.application.entity.AccountEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCrudRepository extends CrudRepository<AccountEntity, String> {
}
