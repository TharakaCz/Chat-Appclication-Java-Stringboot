/**
 * Jun 10, 2019	
 * AinsChatApplication
 * com.ains.chat.helper
 */
package com.ains.chat.helper;

/**
 * @author Tharaka Chandralal
 */
public class GroupChatDetailsDto {

	private String groupDetailsId;
	private String usersNames;
	private String status;
	private ChatDto chatDto;
	private GroupChatDto groupChatDto;
	
	public GroupChatDetailsDto() {
		
	}

	public String getGroupDetailsId() {
		return groupDetailsId;
	}

	public void setGroupDetailsId(String groupDetailsId) {
		this.groupDetailsId = groupDetailsId;
	}

	public String getUsersNames() {
		return usersNames;
	}

	public void setUsersNames(String usersNames) {
		this.usersNames = usersNames;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public ChatDto getChatDto() {
		return chatDto;
	}

	public void setChatDto(ChatDto chatDto) {
		this.chatDto = chatDto;
	}

	public GroupChatDto getGroupChatDto() {
		return groupChatDto;
	}

	public void setGroupChatDto(GroupChatDto groupChatDto) {
		this.groupChatDto = groupChatDto;
	}
	
	
}
