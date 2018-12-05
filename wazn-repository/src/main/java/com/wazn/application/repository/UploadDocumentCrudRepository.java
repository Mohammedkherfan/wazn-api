package com.wazn.application.repository;

import com.wazn.application.entity.UploadDocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UploadDocumentCrudRepository extends CrudRepository<UploadDocumentEntity, String> {
}
