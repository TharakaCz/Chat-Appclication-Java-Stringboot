/**
 * Jun 10, 2019	
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
@Table(name="PRIVATECHAT")
public class PrivateChat {
	
	private String privateChatId;
	private Date date;
	private String time;
	private String privateUserOne;
	private String privateUserTwo;
	private String status;
	private List<PrivateChatDetails>privateChatDetails;
	
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


	@Column(name="STATUS",length=10,nullable=false)
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="PCUONE",length=255,nullable=false)
	public String getPrivateUserOne() {
		return privateUserOne;
	}
	
	public void setPrivateUserOne(String privateUserOne) {
		this.privateUserOne = privateUserOne;
	}

	@Column(name="PCUTWO",length=255,nullable=false)
	public String getPrivateUserTwo() {
		return privateUserTwo;
	}

	public void setPrivateUserTwo(String privateUserTwo) {
		this.privateUserTwo = privateUserTwo;
	}

	@OneToMany(mappedBy="privateChat",targetEntity=PrivateChatDetails.class)
	public List<PrivateChatDetails> getPrivateChatDetails() {
		return privateChatDetails;
	}

	public void setPrivateChatDetails(List<PrivateChatDetails> privateChatDetails) {
		this.privateChatDetails = privateChatDetails;
	}

	
	
	
	
}
