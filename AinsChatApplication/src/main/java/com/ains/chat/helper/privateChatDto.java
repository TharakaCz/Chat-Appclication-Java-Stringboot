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
public class privateChatDto {

	private String privateChatId;
	private Date date;
	private String time;
	private ChatDto chatDto;
	private String status;
	
	
	public privateChatDto() {
	
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
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
}
