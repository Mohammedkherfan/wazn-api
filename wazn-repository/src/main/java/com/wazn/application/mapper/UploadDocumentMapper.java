package com.wazn.application.mapper;

import com.wazn.application.entity.UploadDocumentEntity;
import com.wazn.application.model.UploadDocument;

public interface UploadDocumentMapper {

    UploadDocument toUploadDocument(UploadDocumentEntity uploadDocumentEntity);

    UploadDocumentEntity toUploadDocumentEntity(UploadDocument uploadDocument);
}
