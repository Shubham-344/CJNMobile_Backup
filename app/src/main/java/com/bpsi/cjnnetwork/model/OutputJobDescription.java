package com.bpsi.cjnnetwork.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OutputJobDescription {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("Job_title")
    @Expose
    private String jobTitle;
    @SerializedName("Job_desc")
    @Expose
    private String jobDesc;
    @SerializedName("Job_cmp_id")
    @Expose
    private String jobCmpId;
    @SerializedName("Job_employe_id")
    @Expose
    private String jobEmployeId;
    @SerializedName("Job_desc_pdf_link")
    @Expose
    private String jobDescPdfLink;
    @SerializedName("Job_desc_pdf_name")
    @Expose
    private String jobDescPdfName;
    @SerializedName("Job_desc_img_name")
    @Expose
    private String jobDescImgName;
    @SerializedName("Job_desc_img_link")
    @Expose
    private String jobDescImgLink;
    @SerializedName("qrcode_filename")
    @Expose
    private String qrcodeFilename;
    @SerializedName("Job_date_stamp")
    @Expose
    private String jobDateStamp;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("job_desc_qr_code")
    @Expose
    private Object jobDescQrCode;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobCmpId() {
        return jobCmpId;
    }

    public void setJobCmpId(String jobCmpId) {
        this.jobCmpId = jobCmpId;
    }

    public String getJobEmployeId() {
        return jobEmployeId;
    }

    public void setJobEmployeId(String jobEmployeId) {
        this.jobEmployeId = jobEmployeId;
    }

    public String getJobDescPdfLink() {
        return jobDescPdfLink;
    }

    public void setJobDescPdfLink(String jobDescPdfLink) {
        this.jobDescPdfLink = jobDescPdfLink;
    }

    public String getJobDescPdfName() {
        return jobDescPdfName;
    }

    public void setJobDescPdfName(String jobDescPdfName) {
        this.jobDescPdfName = jobDescPdfName;
    }

    public String getJobDescImgName() {
        return jobDescImgName;
    }

    public void setJobDescImgName(String jobDescImgName) {
        this.jobDescImgName = jobDescImgName;
    }

    public String getJobDescImgLink() {
        return jobDescImgLink;
    }

    public void setJobDescImgLink(String jobDescImgLink) {
        this.jobDescImgLink = jobDescImgLink;
    }

    public String getQrcodeFilename() {
        return qrcodeFilename;
    }

    public void setQrcodeFilename(String qrcodeFilename) {
        this.qrcodeFilename = qrcodeFilename;
    }

    public String getJobDateStamp() {
        return jobDateStamp;
    }

    public void setJobDateStamp(String jobDateStamp) {
        this.jobDateStamp = jobDateStamp;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public Object getJobDescQrCode() {
        return jobDescQrCode;
    }

    public void setJobDescQrCode(Object jobDescQrCode) {
        this.jobDescQrCode = jobDescQrCode;
    }


}
