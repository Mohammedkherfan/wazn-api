package com.wazn.application.usecase;

import com.wazn.application.request.AddDocumentRequest;
import com.wazn.application.response.AddDocumentResponse;

public interface AddDocumentUseCase {

    AddDocumentResponse addDocument(String mobile, AddDocumentRequest request);

}
