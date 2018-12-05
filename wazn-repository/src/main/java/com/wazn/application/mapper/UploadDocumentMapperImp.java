package com.wazn.application.mapper;

import com.wazn.application.entity.UploadDocumentEntity;
import com.wazn.application.model.UploadDocument;

public class UploadDocumentMapperImp implements UploadDocumentMapper {

    @Override
    public UploadDocument toUploadDocument(UploadDocumentEntity uploadDocumentEntity) {
        return new UploadDocument.Builder()
                .mobile(uploadDocumentEntity.getMobile())
                .passportOrVisaImage(uploadDocumentEntity.getPassportOrVisaImage())
                .salaryCertificateImage(uploadDocumentEntity.getSalaryCertificateImage())
                .taxDeclarationImage(uploadDocumentEntity.getTaxDeclarationImage())
                .build();
    }

    @Override
    public UploadDocumentEntity toUploadDocumentEntity(UploadDocument uploadDocument) {
        UploadDocumentEntity uploadDocumentEntity = new UploadDocumentEntity();
        uploadDocumentEntity.setMobile(uploadDocument.getMobile());
        uploadDocumentEntity.setPassportOrVisaImage(uploadDocument.getPassportOrVisaImage());
        uploadDocumentEntity.setSalaryCertificateImage(uploadDocument.getSalaryCertificateImage());
        uploadDocumentEntity.setTaxDeclarationImage(uploadDocument.getTaxDeclarationImage());
        return uploadDocumentEntity;
    }
}
