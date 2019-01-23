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
import java.time.format.DateTimeFormatter;

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
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        return new Document.Builder()
                .mobile(mobile)
                .documentType(request.getDocumentType())
                .documentNumber(request.getDocumentNumber())
                .issuingCountry(request.getIssuingCountry())
                .personalNumber(request.getPersonalNumber())
                .regNumber(request.getRegNumber())
                .validThrough(request.getValidThrough().isEmpty() ? LocalDate.now() : LocalDate.parse(request.getValidThrough()))
                .ownComment(request.getOwnComment())
                .helpDeskComment(request.getHelpDeskComment())
                .birthDate(request.getBirthDate().isEmpty() ? LocalDate.now() : LocalDate.parse(request.getBirthDate().split("T")[0]))
                .gender(request.getGender())
                .nationality(request.getNationality())
                .image(new Image.Builder().documentIdImageFace(request.getDocumentIdImageFace()).documentIdImageBack(request.getDocumentIdImageBack()).personalImage(request.getPersonalImage()).selfImage(request.getSelfImage()).build())
                .report(new Report.Builder().enteredBy(request.getEnteredBy()).location(request.getIssuingCountry()).enteredOn(LocalDateTime.now()).build())
                .result(new Result.Builder().assessmentDocumentBearer(request.getAssessmentDocumentBearer()).automationAuthentications(request.getAutomationAuthentications()).checkMRZ(request.getCheckMRZ()).faceMatch(request.getFaceMatch()).build())
                .build();
    }

}
