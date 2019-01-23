package com.wazn.application.entity;

import javax.persistence.*;

@Entity
@Table(name = "WAZN_ACCOUNT_IMG")
public class AccountImageEntity {

    @Id
    @Column(name = "MOBILE", nullable = false, unique = true)
    private String mobile;

    @Column(name = "DOCUMENT_IMG_FACE", nullable = true, length = 9999999)
    private byte[] documentIdImageFace;

    @Column(name = "DOCUMENT_IMG_BACK", nullable = true, length = 9999999)
    private byte[] documentIdImageBack;

    @Column(name = "PERSONAL_IMG", nullable = true, length = 9999999)
    private byte[] personalImage;

    @Column(name = "SELF_IMG", nullable = true, length = 9999999)
    private byte[] selfImage;

    @OneToOne
    @JoinColumn(name = "MOBILE")
    private DocumentEntity documentEntity;

    public AccountImageEntity() {
    }

    public AccountImageEntity(String mobile, byte[] documentIdImageFace, byte[] documentIdImageBack, byte[] personalImage, byte[] selfImage) {
        this.mobile = mobile;
        this.documentIdImageFace = documentIdImageFace;
        this.documentIdImageBack = documentIdImageBack;
        this.personalImage = personalImage;
        this.selfImage = selfImage;
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

    public byte[] getSelfImage() {
        return selfImage;
    }

    public void setSelfImage(byte[] selfImage) {
        this.selfImage = selfImage;
    }
}
