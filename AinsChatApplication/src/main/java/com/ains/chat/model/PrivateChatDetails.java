/**
 * Jun 13, 2019	
 * AinsChatApplication
 * com.ains.chat.model
 */
package com.ains.chat.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="PRIVATECHATDETAILS")
public class PrivateChatDetails {

	private String privateChatDetailsId;
	private Date date;
	private String time;
	private PrivateChat privateChat;
	private Chat chat;
	private String status;
	private String userName;
	
	public PrivateChatDetails() {
	
	}

	
	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getPrivateChatDetailsId() {
		return privateChatDetailsId;
	}

	public void setPrivateChatDetailsId(String privateChatDetailsId) {
		this.privateChatDetailsId = privateChatDetailsId;
	}



	@Column(name="DATE",length=100,nullable=false)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="TIME",length=50,nullable=false)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PRCID")
	public PrivateChat getPrivateChat() {
		return privateChat;
	}

	public void setPrivateChat(PrivateChat privateChat) {
		this.privateChat = privateChat;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CHID")
	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@Column(name="STATUS",length=10,nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}


	@Column(name="UNAME",length=255,nullable=false)
	public String getUserName() {
		return userName;
	}


	public void setUserName(String userName) {
		this.userName = userName;
	}

	
	
	
}
