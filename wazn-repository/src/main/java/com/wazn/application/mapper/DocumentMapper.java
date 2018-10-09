package com.wazn.application.mapper;

import com.wazn.application.entity.DocumentEntity;
import com.wazn.application.model.Document;

public interface DocumentMapper {

    Document toDocument(DocumentEntity documentEntity);

    DocumentEntity toDocumentEntity(Document document);
}
