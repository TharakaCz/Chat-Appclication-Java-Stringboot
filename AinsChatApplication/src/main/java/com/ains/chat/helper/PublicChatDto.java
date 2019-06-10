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
public class PublicChatDto {

	private String publicChatId;
	private ChatDto chatDto;
	private Date date;
	private String time;
	
	public PublicChatDto() {
	
	}

	public String getPublicChatId() {
		return publicChatId;
	}

	public void setPublicChatId(String publicChatId) {
		this.publicChatId = publicChatId;
	}

	public ChatDto getChatDto() {
		return chatDto;
	}

	public void setChatDto(ChatDto chatDto) {
		this.chatDto = chatDto;
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
	
	
}
