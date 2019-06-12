/**
 * Jun 11, 2019	
 * AinsChatApplication
 * com.ains.chat.helper
 */
package com.ains.chat.helper;

/**
 * @author Tharaka Chandralal
 */
public class MembersDto {

	private String memberId;
	private String memberName;
	private String memberUserDbId;
	private GroupChatDto groupChatDto;
	private String role;
	
	public MembersDto() {
		
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}
	
	public String getMemberName() {
		return memberName;
	}

	public void setMemberName(String memberName) {
		this.memberName = memberName;
	}
	
	public String getMemberUserDbId() {
		return memberUserDbId;
	}

	public void setMemberUserDbId(String memberUserDbId) {
		this.memberUserDbId = memberUserDbId;
	}

	public GroupChatDto getGroupChatDto() {
		return groupChatDto;
	}

	public void setGroupChatDto(GroupChatDto groupChatDto) {
		this.groupChatDto = groupChatDto;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	
	
}
