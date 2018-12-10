package com.wazn.application.repository;

import com.wazn.application.entity.DocumentEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentCrudRepository extends CrudRepository<DocumentEntity, String> {

    @Modifying
    @Query(value = "update WAZN_ACCOUNT_DOC as obj set obj.helpDeskComment = :comment where obj.mobile = :mobile", nativeQuery = true)
    void saveComment(@Param("mobile") String mobile, @Param("comment") String comment);
}
