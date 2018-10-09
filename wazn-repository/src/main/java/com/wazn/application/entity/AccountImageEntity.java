package com.wazn.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "JAZEEL_ACCOUNT_IMG")
public class AccountImageEntity {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "DOCUMENT_IMG_FACE", nullable = false, length = 1000000)
    private byte[] documentIdImageFace;

    @Column(name = "DOCUMENT_IMG_BACK", nullable = false, length = 1000000)
    private byte[] documentIdImageBack;

    @Column(name = "PERSONAL_IMG", nullable = false, length = 1000000)
    private byte[] personalImage;

    @OneToOne
    @JoinColumn(name = "MOBILE")
    private DocumentEntity documentEntity;

    public AccountImageEntity() {
    }

    public AccountImageEntity(String mobile, byte[] documentIdImageFace, byte[] documentIdImageBack, byte[] personalImage) {
        this.mobile = mobile;
        this.documentIdImageFace = documentIdImageFace;
        this.documentIdImageBack = documentIdImageBack;
        this.personalImage = personalImage;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public byte[] getDocumentIdImageFace() {
        return documentIdImageFace;
    }

    public void setDocumentIdImageFace(byte[] documentIdImageFace) {
        this.documentIdImageFace = documentIdImageFace;
    }

    public byte[] getDocumentIdImageBack() {
        return documentIdImageBack;
    }

    public void setDocumentIdImageBack(byte[] documentIdImageBack) {
        this.documentIdImageBack = documentIdImageBack;
    }

    public byte[] getPersonalImage() {
        return personalImage;
    }

    public void setPersonalImage(byte[] personalImage) {
        this.personalImage = personalImage;
    }

    public DocumentEntity getDocumentEntity() {
        return documentEntity;
    }

    public void setDocumentEntity(DocumentEntity documentEntity) {
        this.documentEntity = documentEntity;
    }
}
