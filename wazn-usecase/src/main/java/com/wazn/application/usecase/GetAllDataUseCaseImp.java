package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.AllData;
import com.wazn.application.repository.AccountRepository;
import com.wazn.application.response.GetAllDataResponse;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class GetAllDataUseCaseImp implements GetAllDataUseCase {

    private AccountRepository repository;

    public GetAllDataUseCaseImp(AccountRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<GetAllDataResponse> getAllData() {
        try {
            List<GetAllDataResponse> list = new ArrayList<>();
            repository.getAllData().forEach(e -> {
                list.add(new GetAllDataResponse(
                        e.getMobile(),
                        e.getEmail(),
                        e.getFullName(),
                        e.getVerificationCode(),
                        getAccountType(e.getType()),
                        e.getDocumentType(),
                        e.getDocumentNumber(),
                        e.getIssuingCountry(),
                        e.getPersonalNumber(),
                        e.getRegNumber(),
                        isNull(e.getValidThrough()) ? null : e.getValidThrough().toString(),
                        e.getOwnComment(),
                        e.getHelpDeskComment(),
                        isNull(e.getBirthDate()) ? null : e.getBirthDate().toString(),
                        e.getGender(),
                        e.getNationality(),
                        e.getDocumentIdImageFace(),
                        e.getDocumentIdImageBack(),
                        e.getPersonalImage(),
                        isNull(e.getStartDate()) ? null : e.getStartDate().toString(),
                        e.getNote(),
                        isNull(e.getEnteredOn()) ? null : e.getEnteredOn().toString(),
                        e.getLocation(),
                        e.getEnteredBy(),
                        isNull(e.getAssessmentDocumentBearer()) ? null : e.getAssessmentDocumentBearer().toString(),
                        isNull(e.getFaceMatch()) ? null : e.getFaceMatch().toString(),
                        isNull(e.getCheckMRZ()) ? null : e.getCheckMRZ().toString(),
                        isNull(e.getAutomationAuthentications()) ? null : e.getAutomationAuthentications().toString(),
                        e.getPassportOrVisaImage(),
                        e.getSalaryCertificateImage(),
                        e.getTaxDeclarationImage(),
                        getAccountStatus(e.getStatus())));
            });
            return list;
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public GetAllDataResponse getAllData(String mobile) {
        try {
            AllData allData = repository.getAllData(mobile);
            return new GetAllDataResponse(
                    allData.getMobile(),
                    allData.getEmail(),
                    allData.getFullName(),
                    allData.getVerificationCode(),
                    getAccountType(allData.getType()),
                    allData.getDocumentType(),
                    allData.getDocumentNumber(),
                    allData.getIssuingCountry(),
                    allData.getPersonalNumber(),
                    allData.getRegNumber(),
                    isNull(allData.getValidThrough()) ? null : allData.getValidThrough().toString(),
                    allData.getOwnComment(),
                    allData.getHelpDeskComment(),
                    isNull(allData.getBirthDate()) ? null : allData.getBirthDate().toString(),
                    allData.getGender(),
                    allData.getNationality(),
                    allData.getDocumentIdImageFace(),
                    allData.getDocumentIdImageBack(),
                    allData.getPersonalImage(),
                    isNull(allData.getStartDate()) ? null : allData.getStartDate().toString(),
                    allData.getNote(),
                    isNull(allData.getEnteredOn()) ? null : allData.getEnteredOn().toString(),
                    allData.getLocation(),
                    allData.getEnteredBy(),
                    isNull(allData.getAssessmentDocumentBearer()) ? null : allData.getAssessmentDocumentBearer().toString(),
                    isNull(allData.getFaceMatch()) ? null : allData.getFaceMatch().toString(),
                    isNull(allData.getCheckMRZ()) ? null : allData.getCheckMRZ().toString(),
                    isNull(allData.getAutomationAuthentications()) ? null : allData.getAutomationAuthentications().toString(),
                    allData.getPassportOrVisaImage(),
                    allData.getSalaryCertificateImage(),
                    allData.getTaxDeclarationImage(),
                    getAccountType(allData.getStatus()));
        }catch (Exception ex) {
            throw new AccountException(ex.getMessage());
        }
    }

    @Override
    public void updateStatus(String mobile, String status) {
        repository.updateStatus(mobile, Integer.parseInt(status));
    }

    @Override
    public void saveComment(String mobile, String comment) {
        repository.saveComment(mobile, comment);
    }

    private String getAccountType(Integer type) {
        if (isNull(type))
            return null;
        else
            return type == 1 ? "Bank Account" : "Credit Account";

    }

    private String getAccountStatus(Integer status) {
        if (isNull(status))
            return null;
        else {
            if (status == 0)
                return "Under Rivew";
            if (status == 1)
                return "Approved";
            if (status == 2)
                return "Pending Call";
            if (status == 3)
                return "Reject";
            return "";

        }
    }
}
