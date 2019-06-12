/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.helper
 */
package com.ains.chat.helper;

import java.util.Date;
import java.util.List;

import com.ains.chat.model.GroupChatDeatails;

/**
 * @author Tharaka Chandralal
 */
public class GroupChatDto {

	private String groupId;
	private String groupName;
	private String status;
	private String createBy;
	private Date createDate;
	private String createTime;
	private String deleteBy;
	private Date deleteDate;
	private String deleteTime;
	private List<MembersDto>membersDtos;
	private List<GroupChatDetailsDto>groupChatDetailsDtos;
	
	public GroupChatDto() {
		
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCreateBy() {
		return createBy;
	}

	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public String getCreateTime() {
		return createTime;
	}

	public void setCreateTime(String createTime) {
		this.createTime = createTime;
	}

	public String getDeleteBy() {
		return deleteBy;
	}

	public void setDeleteBy(String deleteBy) {
		this.deleteBy = deleteBy;
	}

	public Date getDeleteDate() {
		return deleteDate;
	}

	public void setDeleteDate(Date deleteDate) {
		this.deleteDate = deleteDate;
	}

	public String getDeleteTime() {
		return deleteTime;
	}

	public void setDeleteTime(String deleteTime) {
		this.deleteTime = deleteTime;
	}

	public List<MembersDto> getMembersDtos() {
		return membersDtos;
	}

	public void setMembersDtos(List<MembersDto> membersDtos) {
		this.membersDtos = membersDtos;
	}

	public List<GroupChatDetailsDto> getGroupChatDetailsDtos() {
		return groupChatDetailsDtos;
	}

	public void setGroupChatDetailsDtos(List<GroupChatDetailsDto> groupChatDetailsDtos) {
		this.groupChatDetailsDtos = groupChatDetailsDtos;
	}
	
	
	
}
