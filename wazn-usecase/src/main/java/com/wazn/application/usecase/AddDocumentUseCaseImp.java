package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.Document;
import com.wazn.application.model.Image;
import com.wazn.application.model.Report;
import com.wazn.application.model.Result;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.request.AddDocumentRequest;
import com.wazn.application.response.AddDocumentResponse;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class AddDocumentUseCaseImp implements AddDocumentUseCase {

    private AccountRepository accountRepository;

    public AddDocumentUseCaseImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public AddDocumentResponse addDocument(String mobile, AddDocumentRequest request) {
        try {
            Document document = getDocument(mobile, request);
            return new AddDocumentResponse(accountRepository.addDocument(document));
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    private Document getDocument(String mobile, AddDocumentRequest request) {
        return new Document.Builder()
                .mobile(mobile)
                .documentType(request.getDocumentType())
                .documentNumber(request.getDocumentNumber())
                .issuingCountry(request.getIssuingCountry())
                .personalNumber(request.getPersonalNumber())
                .regNumber(request.getRegNumber())
                .validThrough(LocalDate.parse(request.getValidThrough()))
                .ownComment(request.getOwnComment())
                .helpDeskComment(request.getHelpDeskComment())
                .birthDate(LocalDate.parse(request.getBirthDate()))
                .gender(request.getGender())
                .nationality(request.getNationality())
                .image(new Image.Builder().documentIdImageFace(request.getDocumentIdImageFace()).documentIdImageBack(request.getDocumentIdImageBack()).personalImage(request.getPersonalImage()).build())
                .report(new Report.Builder().enteredBy(request.getEnteredBy()).location(request.getLocation()).enteredOn(LocalDateTime.parse(request.getEnteredOn())).build())
                .result(new Result.Builder().assessmentDocumentBearer(request.getAssessmentDocumentBearer()).automationAuthentications(request.getAutomationAuthentications()).checkMRZ(request.getCheckMRZ()).faceMatch(request.getFaceMatch()).build())
                .build();
    }
}
