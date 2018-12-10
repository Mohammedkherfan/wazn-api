package com.wazn.application.repository;

import com.wazn.application.entity.AccountEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountCrudRepository extends CrudRepository<AccountEntity, String> {

    @Modifying
    @Query(value = "update WAZN_ACCOUNT as obj set obj.status = :status where obj.mobile = :mobile", nativeQuery = true )
    void updateStatus(@Param("mobile") String mobile, @Param("status") Integer status);
}
