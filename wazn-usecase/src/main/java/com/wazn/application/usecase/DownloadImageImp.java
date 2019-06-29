package com.wazn.application.usecase;

import com.wazn.application.exception.AccountException;
import com.wazn.application.model.Account;
import com.wazn.application.model.AllData;
import com.wazn.application.repository.AccountRepository;

import java.sql.Blob;

public class DownloadImageImp implements DownloadImage{

    private AccountRepository accountRepository;

    public DownloadImageImp(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public byte[] download(String mobile, String type) {
        AllData allData = accountRepository.getAllData(mobile);
        if (type.equals("1"))
            return allData.getDocumentIdImageFace();
        if (type.equals("2"))
            return allData.getDocumentIdImageBack();
        if (type.equals("3"))
            return allData.getPersonalImage();
        if (type.equals("4"))
            return allData.getPassportOrVisaImage();
        if (type.equals("5"))
            return allData.getTaxDeclarationImage();
        if (type.equals("6"))
            return allData.getSalaryCertificateImage();
        if (type.equals("7"))
            return allData.getSelfImage();
        throw new AccountException("Invalid type");
    }
}
