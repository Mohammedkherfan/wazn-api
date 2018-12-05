package com.wazn.application.usecase;

import com.wazn.application.request.UploadDocumentRequest;
import com.wazn.application.response.UploadDocumentResponse;

public interface UploadDocumentUseCase {

    UploadDocumentResponse uploadDocument(String mobile, UploadDocumentRequest request);
}
