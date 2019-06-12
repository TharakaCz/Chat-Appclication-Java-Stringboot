/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.helper
 */
package com.ains.chat.helper;

import java.util.Date;


/**
 * @author Tharaka Chandralal
 */
public class PrivateChatDto {

	private String privateChatId;
	private Date date;
	private String time;
	private ChatDto chatDto;
	private String senderName;
	private String resiverName;
	private String userOne;
	private String userTwo;
	
	public PrivateChatDto() {
	
	}
	
	public String getPrivateChatId() {
		return privateChatId;
	}
	public void setPrivateChatId(String privateChatId) {
		this.privateChatId = privateChatId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public ChatDto getChatDto() {
		return chatDto;
	}
	public void setChatDto(ChatDto chatDto) {
		this.chatDto = chatDto;
	}


	public String getSenderName() {
		return senderName;
	}

	public void setSenderName(String senderName) {
		this.senderName = senderName;
	}

	public String getResiverName() {
		return resiverName;
	}

	public void setResiverName(String resiverName) {
		this.resiverName = resiverName;
	}

	public String getUserOne() {
		return userOne;
	}

	public void setUserOne(String userOne) {
		this.userOne = userOne;
	}

	public String getUserTwo() {
		return userTwo;
	}

	public void setUserTwo(String userTwo) {
		this.userTwo = userTwo;
	}
	
	
	
}
