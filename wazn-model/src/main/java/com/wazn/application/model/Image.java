package com.wazn.application.model;

import com.wazn.application.validation.Validator;

public class Image {

    private byte[] documentIdImageFace;
    private byte[] documentIdImageBack;
    private byte[] personalImage;

    public Image(byte[] documentIdImageFace, byte[] documentIdImageBack, byte[] personalImage) {
        new Validator(documentIdImageFace, documentIdImageBack, personalImage);
        this.documentIdImageFace = documentIdImageFace;
        this.documentIdImageBack = documentIdImageBack;
        this.personalImage = personalImage;
    }

    public byte[] getDocumentIdImageFace() {
        return documentIdImageFace;
    }

    public byte[] getDocumentIdImageBack() {
        return documentIdImageBack;
    }

    public byte[] getPersonalImage() {
        return personalImage;
    }

    public static class Builder {

        private byte[] documentIdImageFace;
        private byte[] documentIdImageBack;
        private byte[] personalImage;

        public Builder documentIdImageFace(byte[] documentIdImageFace) {
            this.documentIdImageFace = documentIdImageFace;
            return this;
        }

        public Builder documentIdImageBack(byte[] documentIdImageBack) {
            this.documentIdImageBack = documentIdImageBack;
            return this;
        }

        public Builder personalImage(byte[] personalImage) {
            this.personalImage = personalImage;
            return this;
        }

        public Image build() {
            return new Image(documentIdImageFace, documentIdImageBack, personalImage);
        }
    }
}
