package com.wazn.application.model;

public class UploadDocument {

    private String mobile;
    private byte[] passportOrVisaImage;
    private byte[] salaryCertificateImage;
    private byte[] taxDeclarationImage;

    public UploadDocument() {
    }

    public UploadDocument(String mobile, byte[] passportOrVisaImage, byte[] salaryCertificateImage, byte[] taxDeclarationImage) {
        this.mobile = mobile;
        this.passportOrVisaImage = passportOrVisaImage;
        this.salaryCertificateImage = salaryCertificateImage;
        this.taxDeclarationImage = taxDeclarationImage;
    }

    public String getMobile() {
        return mobile;
    }

    public byte[] getPassportOrVisaImage() {
        return passportOrVisaImage;
    }

    public byte[] getSalaryCertificateImage() {
        return salaryCertificateImage;
    }

    public byte[] getTaxDeclarationImage() {
        return taxDeclarationImage;
    }

    public static class Builder {

        private String mobile;
        private byte[] passportOrVisaImage;
        private byte[] salaryCertificateImage;
        private byte[] taxDeclarationImage;

        public Builder mobile(String mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder passportOrVisaImage(byte[] passportOrVisaImage) {
            this.passportOrVisaImage = passportOrVisaImage;
            return this;
        }

        public Builder salaryCertificateImage(byte[] salaryCertificateImage) {
            this.salaryCertificateImage = salaryCertificateImage;
            return this;
        }

        public Builder taxDeclarationImage(byte[] taxDeclarationImage) {
            this.taxDeclarationImage = taxDeclarationImage;
            return this;
        }

        public UploadDocument build() {
            return new UploadDocument(mobile, passportOrVisaImage, salaryCertificateImage, taxDeclarationImage);
        }
    }
}
