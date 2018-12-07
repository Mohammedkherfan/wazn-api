package com.wazn.application.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "WAZN_UPLOAD_DOCUMENT")
public class UploadDocumentEntity {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "PASSPORT_IMG", nullable = true, length = 1000000000)
    private byte[] passportOrVisaImage;

    @Column(name = "SALARY_CER_IMG", nullable = true, length = 1000000000)
    private byte[] salaryCertificateImage;

    @Column(name = "TAX_IMG", nullable = true, length = 100000000)
    private byte[] taxDeclarationImage;

    public UploadDocumentEntity() {
    }

    public UploadDocumentEntity(String mobile, byte[] passportOrVisaImage, byte[] salaryCertificateImage, byte[] taxDeclarationImage) {
        this.mobile = mobile;
        this.passportOrVisaImage = passportOrVisaImage;
        this.salaryCertificateImage = salaryCertificateImage;
        this.taxDeclarationImage = taxDeclarationImage;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public byte[] getPassportOrVisaImage() {
        return passportOrVisaImage;
    }

    public void setPassportOrVisaImage(byte[] passportOrVisaImage) {
        this.passportOrVisaImage = passportOrVisaImage;
    }

    public byte[] getSalaryCertificateImage() {
        return salaryCertificateImage;
    }

    public void setSalaryCertificateImage(byte[] salaryCertificateImage) {
        this.salaryCertificateImage = salaryCertificateImage;
    }

    public byte[] getTaxDeclarationImage() {
        return taxDeclarationImage;
    }

    public void setTaxDeclarationImage(byte[] taxDeclarationImage) {
        this.taxDeclarationImage = taxDeclarationImage;
    }
}
