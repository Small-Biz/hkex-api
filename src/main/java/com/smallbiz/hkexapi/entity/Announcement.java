package com.smallbiz.hkexapi.entity;

import java.sql.Timestamp;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Announcement {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
    private int id;

    private String instrumentCode;

    private String type;
    /*
       (ANN)
     Financial Statements
     Announcements and Notices
	Proxy Forms
	Circulars
	Debt and Structured Products
	Share Buyback Reports
	Monthly Returns
	Next Day Disclosure Returns
	Constitutional Documents
	Financial Statements/ESG Information
	Documents on Display
	Application Proofs and Post Hearing Information Packs or PHIPs
	Listing Documents
     */

    private String fullType;

    private String name;

    private String url;
    
    private String fileName;
    
    private String fileType;

    private int uploadDate;

    private int uploadTime;
    
    private String fileSize;
    
    private String announcementStatus;

    private Timestamp createTimestamp;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getInstrumentCode() {
		return instrumentCode;
	}

	public void setInstrumentCode(String instrumentCode) {
		this.instrumentCode = instrumentCode;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getFullType() {
		return fullType;
	}

	public void setFullType(String fullType) {
		this.fullType = fullType;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public int getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(int uploadDate) {
		this.uploadDate = uploadDate;
	}

	public int getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(int uploadTime) {
		this.uploadTime = uploadTime;
	}

	public String getFileSize() {
		return fileSize;
	}

	public void setFileSize(String fileSize) {
		this.fileSize = fileSize;
	}

	public String getAnnouncementStatus() {
		return announcementStatus;
	}

	public void setAnnouncementStatus(String announcementStatus) {
		this.announcementStatus = announcementStatus;
	}

	public Timestamp getCreateTimestamp() {
		return createTimestamp;
	}

	public void setCreateTimestamp(Timestamp createTimestamp) {
		this.createTimestamp = createTimestamp;
	}
	
	public String getUniqueKey() {
		return this.instrumentCode+"_"+this.uploadDate+"_"+this.uploadTime+"_"+this.fileName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Announcement [id=");
		builder.append(id);
		builder.append(", instrumentCode=");
		builder.append(instrumentCode);
		builder.append(", type=");
		builder.append(type);
		builder.append(", fullType=");
		builder.append(fullType);
		builder.append(", name=");
		builder.append(name);
		builder.append(", url=");
		builder.append(url);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", fileType=");
		builder.append(fileType);
		builder.append(", uploadDate=");
		builder.append(uploadDate);
		builder.append(", uploadTime=");
		builder.append(uploadTime);
		builder.append(", fileSize=");
		builder.append(fileSize);
		builder.append(", announcementStatus=");
		builder.append(announcementStatus);
		builder.append(", createTimestamp=");
		builder.append(createTimestamp);
		builder.append("]");
		return builder.toString();
	}

    


}
