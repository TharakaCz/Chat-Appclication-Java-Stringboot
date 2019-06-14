/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.helper
 */
package com.ains.chat.helper;

import java.util.Date;
import java.util.List;



/**
 * @author Tharaka Chandralal
 */
public class PrivateChatDto {

	private String privateChatId;
	private Date date;
	private String time;
	private String privateUserOne;
	private String privateUserTwo;
	private String status;
	private List<PrivateChatDetailsDto>privateChatDetailsDtos;
	
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

	

	public String getPrivateUserOne() {
		return privateUserOne;
	}

	public void setPrivateUserOne(String privateUserOne) {
		this.privateUserOne = privateUserOne;
	}

	public String getPrivateUserTwo() {
		return privateUserTwo;
	}

	public void setPrivateUserTwo(String privateUserTwo) {
		this.privateUserTwo = privateUserTwo;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<PrivateChatDetailsDto> getPrivateChatDetailsDtos() {
		return privateChatDetailsDtos;
	}

	public void setPrivateChatDetailsDtos(List<PrivateChatDetailsDto> privateChatDetailsDtos) {
		this.privateChatDetailsDtos = privateChatDetailsDtos;
	}

	
	
	
	
}
