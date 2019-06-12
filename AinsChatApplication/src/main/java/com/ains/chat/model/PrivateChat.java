/**
 * Jun 10, 2019	
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
@Table(name="PRIVATECHAT")
public class PrivateChat {
	
	private String privateChatId;
	private Date date;
	private String time;
	private String senderName;
	private String resiverName;
	private Chat chat;
	private String userOne;
	private String userTwo;
	private String status;
	
	public PrivateChat() {
		
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getPrivateChatId() {
		return privateChatId;
	}

	public void setPrivateChatId(String privateChatId) {
		this.privateChatId = privateChatId;
	}

	@Column(name="DATE",length=100,nullable=true)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="TIME",length=50,nullable=true)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CHATID")
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

	@Column(name="SNAME",length=255,nullable=false)
	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	@Column(name="RNMAE",length=255,nullable=false)
	public String getResiverName() {
		return resiverName;
	}

	public void setResiverName(String resiverName) {
		this.resiverName = resiverName;
	}

	@Column(name="UONE",length=255,nullable=false)
	public String getUserOne() {
		return userOne;
	}

	public void setUserOne(String userOne) {
		this.userOne = userOne;
	}

	@Column(name="UTWO",length=255,nullable=false)
	public String getUserTwo() {
		return userTwo;
	}

	public void setUserTwo(String userTwo) {
		this.userTwo = userTwo;
	}
	
	
	
}
