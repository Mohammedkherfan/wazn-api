package com.wazn.application.repository;

import com.wazn.application.entity.DocumentEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentCrudRepository extends CrudRepository<DocumentEntity, String> {
}
