package com.wazn.application.mapper;

import com.wazn.application.entity.AccountImageEntity;
import com.wazn.application.entity.DocumentEntity;
import com.wazn.application.entity.ReportEntity;
import com.wazn.application.entity.ResultEntity;
import com.wazn.application.model.Document;
import com.wazn.application.model.Image;
import com.wazn.application.model.Report;
import com.wazn.application.model.Result;

public class DocumentMapperImp implements DocumentMapper {

    @Override
    public Document toDocument(DocumentEntity documentEntity) {
        return new Document.Builder()
                .mobile(documentEntity.getMobile())
                .documentType(documentEntity.getDocumentType())
                .documentNumber(documentEntity.getDocumentNumber())
                .issuingCountry(documentEntity.getIssuingCountry())
                .personalNumber(documentEntity.getPersonalNumber())
                .regNumber(documentEntity.getRegNumber())
                .validThrough(documentEntity.getValidThrough())
                .ownComment(documentEntity.getOwnComment())
                .helpDeskComment(documentEntity.getHelpDeskComment())
                .birthDate(documentEntity.getBirthDate())
                .gender(documentEntity.getGender())
                .nationality(documentEntity.getNationality())
                .image(new Image.Builder()
                        .documentIdImageFace(documentEntity.getAccountImageEntity().getDocumentIdImageFace())
                        .documentIdImageBack(documentEntity.getAccountImageEntity().getDocumentIdImageBack())
                        .personalImage(documentEntity.getAccountImageEntity().getPersonalImage())
                        .selfImage(documentEntity.getAccountImageEntity().getSelfImage())
                        .build())
                .report(new Report.Builder()
                        .enteredBy(documentEntity.getReportEntity().getEnteredBy())
                        .location(documentEntity.getReportEntity().getLocation())
                        .enteredOn(documentEntity.getReportEntity().getEnteredOn())
                        .build())
                .result(new Result.Builder()
                        .assessmentDocumentBearer(documentEntity.getResultEntity().getAssessmentDocumentBearer() == 1 ? Boolean.TRUE : Boolean.FALSE)
                        .automationAuthentications(documentEntity.getResultEntity().getAutomationAuthentications() == 1 ? Boolean.TRUE : Boolean.FALSE)
                        .checkMRZ(documentEntity.getResultEntity().getCheckMRZ() == 1 ? Boolean.TRUE : Boolean.FALSE)
                        .faceMatch(documentEntity.getResultEntity().getFaceMatch() == 1 ? Boolean.TRUE : Boolean.FALSE)
                        .build())
                .build();
    }

    @Override
    public DocumentEntity toDocumentEntity(Document document) {
        DocumentEntity documentEntity = new DocumentEntity();
        documentEntity.setMobile(document.getMobile());
        documentEntity.setDocumentType(document.getDocumentType());
        documentEntity.setDocumentNumber(document.getDocumentNumber());
        documentEntity.setIssuingCountry(document.getIssuingCountry());
        documentEntity.setValidThrough(document.getValidThrough());
        documentEntity.setOwnComment(document.getOwnComment());
        documentEntity.setPersonalNumber(document.getPersonalNumber());
        documentEntity.setRegNumber(document.getRegNumber());
        documentEntity.setHelpDeskComment(document.getHelpDeskComment());
        documentEntity.setBirthDate(document.getBirthDate());
        documentEntity.setGender(document.getGender());
        documentEntity.setNationality(document.getNationality());
        documentEntity.setAccountImageEntity(new AccountImageEntity(document.getMobile(), document.getImage().getDocumentIdImageFace(), document.getImage().getDocumentIdImageBack(), document.getImage().getPersonalImage(), document.getImage().getSelfImage()));
        documentEntity.setReportEntity(new ReportEntity(document.getMobile(), document.getReport().getEnteredOn(), document.getReport().getLocation(), document.getReport().getEnteredBy()));
        documentEntity.setResultEntity(new ResultEntity(document.getMobile(), document.getResult().getAssessmentDocumentBearer() ? 1 : 0, document.getResult().getFaceMatch() ? 1 : 0, document.getResult().getCheckMRZ() ? 1 : 0, document.getResult().getAutomationAuthentications() ? 1 : 0));
        return documentEntity;
    }
}
