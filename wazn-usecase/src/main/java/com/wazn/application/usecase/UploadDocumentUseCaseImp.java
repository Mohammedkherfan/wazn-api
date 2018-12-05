package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.UploadDocument;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.UploadDocumentRequest;
import com.wazn.application.response.UploadDocumentResponse;

public class UploadDocumentUseCaseImp implements UploadDocumentUseCase {

    private AccountRepository repository;

    public UploadDocumentUseCaseImp(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UploadDocumentResponse uploadDocument(String mobile, UploadDocumentRequest request) {
        try {
            UploadDocument uploadDocument = new UploadDocument.Builder()
                    .mobile(mobile)
                    .passportOrVisaImage(request.getPassportOrVisaImage())
                    .salaryCertificateImage(request.getSalaryCertificateImage())
                    .taxDeclarationImage(request.getTaxDeclarationImage())
                    .build();
            return new UploadDocumentResponse(repository.uploadDocument(uploadDocument));
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
