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
@Table(name="GROUPCHAT")
public class GroupChat {

	private String groupId;
	private String groupName;
	private String status;
	private String createBy;
	private Date createDate;
	private String createTime;
	private String deleteBy;
	private Date deleteDate;
	private String deleteTime;
	private List<Members>members;
	private List<GroupChatDeatails>groupChatDeatails;
	
	public GroupChat() {
		
	}

	@Id
	@Column(name="PID",nullable=false,length=100)
	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	@Column(name="GNAME",nullable=false,length=255)
	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	@Column(name="STATUS",nullable=false,length=10)
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name="CRETBY",nullable=true,length=255)
	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	@Column(name="DELTBY",nullable=true,length=255)
	public String getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
	}

	@OneToMany(mappedBy="groupChat",targetEntity=GroupChatDeatails.class)
	public List<GroupChatDeatails> getGroupChatDeatails() {
		return groupChatDeatails;
	}

	public void setGroupChatDeatails(List<GroupChatDeatails> groupChatDeatails) {
		this.groupChatDeatails = groupChatDeatails;
	}

	@Column(name="CDATE",nullable=true,length=100)
	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	@Column(name="CTIME",nullable=true,length=50)
	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	@Column(name="DTIME",nullable=true,length=50)
	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	@Column(name="DDATE",nullable=true,length=100)
	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	@OneToMany(mappedBy="groupChat",targetEntity=Members.class)
	public List<Members> getMembers() {
		return members;
	}

	public void setMembers(List<Members> members) {
		this.members = members;
	}
	
	
	
}
