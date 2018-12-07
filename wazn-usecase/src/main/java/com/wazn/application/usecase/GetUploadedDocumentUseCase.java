package com.wazn.application.usecase;

import com.wazn.application.response.GetUploadedDocumentResponse;

public interface GetUploadedDocumentUseCase {

    GetUploadedDocumentResponse getUploadedDocument(String mobile);
}
