/**
 * Jun 11, 2019	
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
@Table(name="MEMBERS")
public class Members {

	private String memberId;
	private String memberName;
	private String memberUserDbId;
	private GroupChat groupChat;
	private String role;
	private String status;
	
	public Members() {
	
	}

	@Id
	@Column(name="PID",length=100,nullable=false)
	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	@Column(name="MNAME",length=255,nullable=false)
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}

	@Column(name="MUDBID",length=100,nullable=true)
	public String getMemberUserDbId() {
		return memberUserDbId;
	}

	public void setMemberUserDbId(String memberUserDbId) {
		this.memberUserDbId = memberUserDbId;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="GRID",nullable=true)
	public GroupChat getGroupChat() {
		return groupChat;
	}

	public void setGroupChat(GroupChat groupChat) {
		this.groupChat = groupChat;
	}

	@Column(name="ROLE",length=100,nullable=true)
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	@Column(name="STATUS",length=10,nullable=false)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
	
}
