/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.model
 */
package com.ains.chat.model;

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
@Table(name="GROUPDETAILS")
public class GroupChatDeatails {

	private String groupDetailsId;
	private String usersNames;
	private String status;
	private Chat chat;
	private GroupChat groupChat;
	
	public GroupChatDeatails() {
		
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getGroupDetailsId() {
		return groupDetailsId;
	}

	public void setGroupDetailsId(String groupDetailsId) {
		this.groupDetailsId = groupDetailsId;
	}

	@Column(name="UNAMES",nullable=false,length=255)
	public String getUsersNames() {
		return usersNames;
	}

	public void setUsersNames(String usersNames) {
		this.usersNames = usersNames;
	}

	@Column(name="STATUS",nullable=false,length=10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="CHATID")
	public Chat getChat() {
		return chat;
	}

	public void setChat(Chat chat) {
		this.chat = chat;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="GRID")
	public GroupChat getGroupChat() {
		return groupChat;
	}

	public void setGroupChat(GroupChat groupChat) {
		this.groupChat = groupChat;
	}
	
	
}
