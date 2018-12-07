package com.wazn.application.response;

public class GetUploadedDocumentResponse {

    private String mobile;
    private byte[] passportOrVisaImage;
    private byte[] salaryCertificateImage;
    private byte[] taxDeclarationImage;

    public GetUploadedDocumentResponse() {
    }

    public GetUploadedDocumentResponse(String mobile, byte[] passportOrVisaImage, byte[] salaryCertificateImage, byte[] taxDeclarationImage) {
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
