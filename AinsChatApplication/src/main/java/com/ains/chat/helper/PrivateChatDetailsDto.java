/**
 * Jun 13, 2019	
 * AinsChatApplication
 * com.ains.chat.helper
 */
package com.ains.chat.helper;

import java.util.Date;

/**
 * @author Tharaka Chandralal
 */
public class PrivateChatDetailsDto {

	private String privateChatDetailsId;
	private Date date;
	private String time;
	private PrivateChatDto privateChatDto;
	private ChatDto chatDto;
	private String userName;
	
	public PrivateChatDetailsDto() {
		
	}

	

	public String getPrivateChatDetailsId() {
		return privateChatDetailsId;
	}



	public void setPrivateChatDetailsId(String privateChatDetailsId) {
		this.privateChatDetailsId = privateChatDetailsId;
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

	public PrivateChatDto getPrivateChatDto() {
		return privateChatDto;
	}

	public void setPrivateChatDto(PrivateChatDto privateChatDto) {
		this.privateChatDto = privateChatDto;
	}

	public ChatDto getChatDto() {
		return chatDto;
	}

	public void setChatDto(ChatDto chatDto) {
		this.chatDto = chatDto;
	}



	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	
}
