/**
 * Jun 6, 2019	
 * AinsChatApplication
 * com.ains.chat.model
 */
package com.ains.chat.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="GLOBLECHAT")
public class GlobleChat {

	private String globleChatID;
	private String userName;
	private String userCode;
	private String massage;
	private String status;
	
	public GlobleChat() {
		
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getGlobleChatID() {
		return globleChatID;
	}

	public void setGlobleChatID(String globleChatID) {
		this.globleChatID = globleChatID;
	}

	@Column(name="UNAME",nullable=false,length=100)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="UCODE",nullable=false,length=100)
	public String getUserCode() {
		return userCode;
	}

	public void setUserCode(String userCode) {
		this.userCode = userCode;
	}

	@Column(name="GMASG",nullable=true,length=255)
	public String getMassage() {
		return massage;
	}

	public void setMassage(String massage) {
		this.massage = massage;
	}

	@Column(name="STATUS",nullable=false,length=10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	
}
