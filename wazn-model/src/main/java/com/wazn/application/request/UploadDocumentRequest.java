package com.wazn.application.request;

public class UploadDocumentRequest {

    private byte[] passportOrVisaImage;
    private byte[] salaryCertificateImage;
    private byte[] taxDeclarationImage;

    public UploadDocumentRequest() {
    }

    public UploadDocumentRequest(byte[] passportOrVisaImage, byte[] salaryCertificateImage, byte[] taxDeclarationImage) {
        this.passportOrVisaImage = passportOrVisaImage;
        this.salaryCertificateImage = salaryCertificateImage;
        this.taxDeclarationImage = taxDeclarationImage;
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
