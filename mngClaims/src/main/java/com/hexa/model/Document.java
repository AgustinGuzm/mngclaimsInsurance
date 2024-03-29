package com.hexa.model;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "documents")
public class Document {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY) //auto generate the value for id
	private Integer documentId;
	
	@ManyToOne (fetch = FetchType.EAGER, cascade = CascadeType.ALL) //relationship many claims to one customer
	@JoinColumn(name = "claimId")
	private claim claimsnum;
	
	@Column(length =512,nullable= false)
	private String documentName;
	
	private long documentSize;
	
	@Column(name= "upload_time")
	private Date uploadTime;
	
	private byte[] content;

	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Document(Integer documentId, claim claimsnum, String documentName, long documentSize, Date uploadTime,
			byte[] content) {
		super();
		this.documentId = documentId;
		this.claimsnum = claimsnum;
		this.documentName = documentName;
		this.documentSize = documentSize;
		this.uploadTime = uploadTime;
		this.content = content;
	}

	
	
	
	
	public Document(Integer documentId, claim claimsr, String documentName, long documentSize, Date uploadTime) {
		super();
		this.documentId = documentId;
		this.claimsnum = claimsr;
		this.documentName = documentName;
		this.documentSize = documentSize;
		this.uploadTime = uploadTime;
	}

	public Integer getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}

	public claim getClaimsnum() {
		return claimsnum;
	}

	public void setClaimsnum(claim claimsnum) {
		this.claimsnum = claimsnum;
	}

	public String getDocumentName() {
		return documentName;
	}

	public void setDocumentName(String documentName) {
		this.documentName = documentName;
	}

	public long getDocumentSize() {
		return documentSize;
	}

	public void setDocumentSize(long documentSize) {
		this.documentSize = documentSize;
	}

	public Date getUploadTime() {
		return uploadTime;
	}

	public void setUploadTime(Date uploadTime) {
		this.uploadTime = uploadTime;
	}

	public byte[] getContent() {
		return content;
	}

	public void setContent(byte[] content) {
		this.content = content;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((claimsnum == null) ? 0 : claimsnum.hashCode());
		result = prime * result + Arrays.hashCode(content);
		result = prime * result + ((documentId == null) ? 0 : documentId.hashCode());
		result = prime * result + ((documentName == null) ? 0 : documentName.hashCode());
		result = prime * result + (int) (documentSize ^ (documentSize >>> 32));
		result = prime * result + ((uploadTime == null) ? 0 : uploadTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Document other = (Document) obj;
		if (claimsnum == null) {
			if (other.claimsnum != null)
				return false;
		} else if (!claimsnum.equals(other.claimsnum))
			return false;
		if (!Arrays.equals(content, other.content))
			return false;
		if (documentId == null) {
			if (other.documentId != null)
				return false;
		} else if (!documentId.equals(other.documentId))
			return false;
		if (documentName == null) {
			if (other.documentName != null)
				return false;
		} else if (!documentName.equals(other.documentName))
			return false;
		if (documentSize != other.documentSize)
			return false;
		if (uploadTime == null) {
			if (other.uploadTime != null)
				return false;
		} else if (!uploadTime.equals(other.uploadTime))
			return false;
		return true;
	}

}
