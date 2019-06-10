/**
 * Jun 7, 2019	
 * AinsChatApplication
 * com.ains.chat.model
 */
package com.ains.chat.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Tharaka Chandralal
 */
@Entity
@Table(name="CHAT")
public class Chat {

	private String chatId;
	private String massage;
	private String chatType;
	private String status;
	private String userName;
	private Date date;
	private String time;
	private List<GroupChatDeatails>groupChatDeatails;
	private List<PublicChat>publicChats;
	private List<PrivateChat>privateChats;
	
	public Chat() {
		
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getChatId() {
		return chatId;
	}

	public void setChatId(String chatId) {
		this.chatId = chatId;
	}

	@Column(name="MASSAG",nullable=true,length=255)
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

	@Column(name="USERN",nullable=false,length=255)
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Column(name="CHATTY",nullable=false,length=255)
	public String getChatType() {
		return chatType;
	}

	public void setChatType(String chatType) {
		this.chatType = chatType;
	}

	@Column(name="DATE",nullable=false,length=100)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	@Column(name="TIME",nullable=false,length=100)
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@OneToMany(mappedBy="chat",targetEntity=GroupChatDeatails.class)
	public List<GroupChatDeatails> getGroupChatDeatails() {
		return groupChatDeatails;
	}

	public void setGroupChatDeatails(List<GroupChatDeatails> groupChatDeatails) {
		this.groupChatDeatails = groupChatDeatails;
	}

	@OneToMany(mappedBy="chat",targetEntity=PublicChat.class)
	public List<PublicChat> getPublicChats() {
		return publicChats;
	}

	public void setPublicChats(List<PublicChat> publicChats) {
		this.publicChats = publicChats;
	}

	@OneToMany(mappedBy="chat",targetEntity=PrivateChat.class)
	public List<PrivateChat> getPrivateChats() {
		return privateChats;
	}

	public void setPrivateChats(List<PrivateChat> privateChats) {
		this.privateChats = privateChats;
	}

	
	
}
