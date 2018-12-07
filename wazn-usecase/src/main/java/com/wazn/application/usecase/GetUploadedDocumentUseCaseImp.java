package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.UploadDocument;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.response.GetUploadedDocumentResponse;

public class GetUploadedDocumentUseCaseImp implements GetUploadedDocumentUseCase {

    private AccountRepository repository;

    public GetUploadedDocumentUseCaseImp(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public GetUploadedDocumentResponse getUploadedDocument(String mobile) {
        try {
            UploadDocument uploadDocument = repository.getUploadedDocument(mobile);
            return new GetUploadedDocumentResponse(uploadDocument.getMobile(), uploadDocument.getPassportOrVisaImage(), uploadDocument.getSalaryCertificateImage(), uploadDocument.getTaxDeclarationImage());
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
