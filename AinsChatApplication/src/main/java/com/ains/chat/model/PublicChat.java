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
@Table(name="PUBLICCHAT")
public class PublicChat {

	private String publicChatId;
	private Chat chat;
	private String status;
	private Date date;
	private String time;
	
	public PublicChat() {
	
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getPublicChatId() {
		return publicChatId;
	}

	public void setPublicChatId(String publicChatId) {
		this.publicChatId = publicChatId;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CHATID")
	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@Column(name="STATUS",nullable=false,length=10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="DATE",nullable=false,length=100)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="TIME",nullable=false,length=50)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}
	
	
	
}
