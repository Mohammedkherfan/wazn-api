package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.UploadDocument;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.UploadDocumentRequest;
import com.wazn.application.response.UploadDocumentResponse;

import static java.util.Objects.isNull;

public class UploadDocumentUseCaseImp implements UploadDocumentUseCase {

    private AccountRepository repository;

    public UploadDocumentUseCaseImp(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public UploadDocumentResponse uploadDocument(String mobile, UploadDocumentRequest request) {
        try {
            UploadDocument uploadDocument;
            UploadDocument document = repository.getUploadedDocument(mobile);
            if (isNull(document)) {
                uploadDocument = new UploadDocument.Builder()
                        .passportOrVisaImage(request.getPassportOrVisaImage())
                        .taxDeclarationImage(request.getTaxDeclarationImage())
                        .salaryCertificateImage(request.getSalaryCertificateImage())
                        .build();
            }else {
                uploadDocument = new UploadDocument.Builder()
                        .mobile(mobile)
                        .passportOrVisaImage(isNull(request.getPassportOrVisaImage()) ? document.getPassportOrVisaImage() : request.getPassportOrVisaImage())
                        .salaryCertificateImage(isNull(request.getSalaryCertificateImage()) ? document.getSalaryCertificateImage() : request.getSalaryCertificateImage())
                        .taxDeclarationImage(isNull(request.getTaxDeclarationImage()) ? document.getTaxDeclarationImage() : request.getTaxDeclarationImage())
                        .build();
            }
            return new UploadDocumentResponse(repository.uploadDocument(uploadDocument));
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }
}
