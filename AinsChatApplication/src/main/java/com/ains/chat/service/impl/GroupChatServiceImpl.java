/**
 * Jun 11, 2019	
 * AinsChatApplication
 * com.ains.chat.service.impl
 */
package com.ains.chat.service.impl;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ains.chat.dao.ChatDao;
import com.ains.chat.dao.GroupChatDao;
import com.ains.chat.dao.GroupChatDetailsDao;
import com.ains.chat.dao.MembersDao;
import com.ains.chat.helper.ChatDto;
import com.ains.chat.helper.GroupChatDetailsDto;
import com.ains.chat.helper.GroupChatDto;
import com.ains.chat.helper.MembersDto;
import com.ains.chat.model.Chat;
import com.ains.chat.model.GroupChat;
import com.ains.chat.model.GroupChatDeatails;
import com.ains.chat.model.Members;
import com.ains.chat.model.PrivateChat;
import com.ains.chat.service.GroupChatService;
import com.ains.chat.utill.AppConstant;

/**
 * @author Tharaka Chandralal
 */
@Service
public class GroupChatServiceImpl implements GroupChatService{

	@Autowired
	private GroupChatDao groupChatDao;
	
	@Autowired
	private GroupChatDetailsDao groupChatDetailsDao;

	@Autowired
	private MembersDao membersDao;
	
	@Autowired
	private ChatDao chatDao;
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#createGroup(com.ains.chat.helper.GroupChatDto)
	 */
	@Override
	public String createGroup(GroupChatDto groupChatDto) throws Exception {
		
		if (groupChatDto.getGroupName().isEmpty() && groupChatDto.getCreateBy().isEmpty()) {
			
			return "Group Creation Faild . . !";
			 
		}else {

			GroupChat groupChat = new GroupChat();
			Members members = new Members();
			
			
			Date time = new Date();
		    String strDateFormat = "hh:mm:ss a";
		    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
		    String formattedDate= dateFormat.format(time);
		    
			groupChat.setGroupId(UUID.randomUUID().toString());
			groupChat.setGroupName(groupChatDto.getGroupName());
			groupChat.setStatus(AppConstant.ACTIVE);
			groupChat.setCreateDate(new Date());
			groupChat.setCreateTime(formattedDate);
			groupChat.setCreateBy(groupChatDto.getCreateBy());
			
			 groupChatDto.getMembersDtos().forEach(each->{
			    	members.setMemberId(UUID.randomUUID().toString());
				    members.setMemberName(groupChatDto.getCreateBy());
			    	members.setMemberUserDbId(UUID.randomUUID().toString());
			    	members.setRole(AppConstant.GROUP_SUPER_ADMIN);
			    	members.setStatus(AppConstant.ACTIVE);
			    	members.setGroupChat(groupChatDao.save(groupChat));
			    	membersDao.save(members);
			    });
			 
			 return groupChat.getGroupId();
		}
		
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#addMembers(com.ains.chat.helper.GroupChatDto)
	 */
	@Override
	public String addMembers(GroupChatDto groupChatDto) throws Exception {
		
		Members members = new Members();
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupChatDto.getGroupId(),AppConstant.ACTIVE);
		
		groupChatDto.getMembersDtos().forEach(each->{
			members.setMemberId(UUID.randomUUID().toString());
			members.setGroupChat(groupChat);
			members.setRole(AppConstant.GROUP_USER);
			members.setStatus(AppConstant.ACTIVE);
			members.setMemberUserDbId(UUID.randomUUID().toString());
			members.setMemberName(each.getMemberName());
			
			membersDao.save(members);
		});
		return "Member Added Succsess . . !";
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#deleteGroup(java.lang.String, java.lang.String)
	 */
	@Override
	public String deleteGroup(String groupId, String memberName) throws Exception {
		
		List<Members> members = membersDao.findAllByMemberNameAndStatus(memberName,AppConstant.ACTIVE);
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupId,AppConstant.ACTIVE);
		ArrayList<String>rolesName = new ArrayList<>(); 
		members.forEach(each->{
			rolesName.add(each.getRole());
		});
		
		String role = rolesName.get(1);
		
		if (role.equals(AppConstant.GROUP_SUPER_ADMIN)) {
			groupChat.setStatus(AppConstant.DEACTIVE);
			groupChatDao.save(groupChat);
			
			return "Group Delete Succsess . . !";
		}else {
			return "Group Delete Faild Try Again . . !";
		}
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#RemoveUser(java.lang.String)
	 */
	@Override
	public String removeUser(String groupId,String memberName,String userId) throws Exception {
		
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupId,AppConstant.ACTIVE);
		Members members = membersDao.findOneByGroupChatAndMemberNameAndStatus(groupChat, memberName, AppConstant.ACTIVE);
		Members remove = membersDao.findOneByMemberIdAndStatus(userId,AppConstant.ACTIVE);
		remove.setStatus(AppConstant.DEACTIVE);
		if (members.getRole().equals(AppConstant.GROUP_SUPER_ADMIN) || members.getRole().equals(AppConstant.GROUP_ADMIN)) {
			membersDao.save(remove);
			return "Member Succsessfully Removed . . !";
			
		}else {
			return "Un Authorizerd . . !";
		}
	
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#sendGroupChat(com.ains.chat.helper.GroupChatDto)
	 */
	@Override
	public String sendGroupChat(GroupChatDto groupChatDto) throws Exception {
		
		
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupChatDto.getGroupId(),AppConstant.ACTIVE);
		Chat chat = new Chat();
		
		GroupChatDeatails groupChatDeatails = new GroupChatDeatails();
		groupChatDto.getGroupChatDetailsDtos().forEach(each->{
			
			chat.setChatId(UUID.randomUUID().toString());
			chat.setChatType(AppConstant.GROUP_CHAT);
			chat.setDate(new Date());
			chat.setTime(formattedDate);
			chat.setMassage(each.getChatDto().getMassage());
			chat.setStatus(AppConstant.ACTIVE);
			chat.setUserName(each.getUsersNames());
			
			groupChatDeatails.setGroupDetailsId(UUID.randomUUID().toString());
			groupChatDeatails.setChat(chatDao.save(chat));
			groupChatDeatails.setGroupChat(groupChatDao.save(groupChat));
			groupChatDeatails.setStatus(AppConstant.ACTIVE);
			groupChatDeatails.setUsersNames(each.getUsersNames());
			groupChatDeatails.setDate(new Date());
			groupChatDetailsDao.save(groupChatDeatails);
		});
		
		
		return "Massage Send Succsess . . !";
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#getAllGroups(java.lang.String)
	 */
	@Override
	public List<GroupChatDto> getAllGroupsNames(String membersName) throws Exception {
		
		List<Members>members = membersDao.findAllByMemberNameAndStatus(membersName,AppConstant.ACTIVE);
		ArrayList<String>groupsIds = new ArrayList<>();
		ArrayList<GroupChatDto>groupChatDtos = new ArrayList<>();
		
		members.forEach(each->{
			groupsIds.add(each.getGroupChat().getGroupId());
		});
		
		groupsIds.forEach(each->{
			try {
				List<GroupChat>groupChats = groupChatDao.findAllByGroupIdAndStatus(each, AppConstant.ACTIVE);
				groupChats.forEach(group->{
					try {
						groupChatDtos.add(getAllGroupsByNames(group));
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		
		return groupChatDtos;
	}
	

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#getAllGroupChat(java.lang.String, java.lang.String)
	 */
	@Override
	public List<GroupChatDto> getAllGroupChat(String groupId, String memberName) throws Exception {
		
		GroupChat group = groupChatDao.findOneByGroupIdAndStatus(groupId, AppConstant.ACTIVE);
		List<Members>members = membersDao.findAllByGroupChatAndStatus(group, AppConstant.ACTIVE);
		
		List<GroupChat> groupChat = groupChatDao.findAllByGroupIdAndStatus(groupId, AppConstant.ACTIVE);
		ArrayList<GroupChatDto> groupChatDtos = new ArrayList<>();
		
		members.forEach(member->{
			if (member.getMemberName().equals(memberName)) {
				
				groupChat.forEach(each->{
					try {
						groupChatDtos.add(getAllGroupChat(each));
					} catch (Exception e) {
						e.printStackTrace();
					}
				});
			
				System.out.println("Authorized . . !");
			}else {
				System.out.println("Un Authorized . . !");
			}
		});
		
		
		return groupChatDtos;
	}
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#editGroupName(com.ains.chat.helper.GroupChatDto)
	 */
	@Override
	public String editGroupName(GroupChatDto groupChatDto,String memberName) throws Exception {
		
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupChatDto.getGroupId(), AppConstant.ACTIVE);
		Members members = membersDao.findOneByGroupChatAndMemberNameAndStatus(groupChat, memberName, AppConstant.ACTIVE);
		
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
		if (members.getRole().equals(AppConstant.GROUP_ADMIN) || members.getRole().equals(AppConstant.GROUP_SUPER_ADMIN)) {
			
			groupChat.setGroupName(groupChatDto.getGroupName());
			groupChat.setCreateDate(new Date());
			groupChat.setCreateTime(formattedDate);
			groupChatDao.save(groupChat);
			
			return "Group Name Succsessfully Updated . . !";
			
		}else {
			
			return "Un Authorized . . !";
		}
		
		
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#editChat(com.ains.chat.helper.GroupChatDto)
	 */
	@Override
	public String editChat(GroupChatDto groupChatDto) throws Exception {
		
		
		
		Date time = new Date();
	    String strDateFormat = "hh:mm:ss a";
	    DateFormat dateFormat = new SimpleDateFormat(strDateFormat);
	    String formattedDate= dateFormat.format(time);
	    
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupChatDto.getGroupId(),AppConstant.ACTIVE);
	
		groupChatDto.getGroupChatDetailsDtos().forEach(each->{
			GroupChatDeatails groupChatDeatails = groupChatDetailsDao.findOneByGroupDetailsId(each.getGroupDetailsId());
			Chat chat;
			try {
				chat = chatDao.findByChatIdAndStatusOrderByDateAsc(each.getChatDto().getChatId(),AppConstant.ACTIVE);
				chat.setChatType(AppConstant.GROUP_CHAT);
				chat.setDate(new Date());
				chat.setTime(formattedDate);
				chat.setMassage(each.getChatDto().getMassage());
				chat.setStatus(AppConstant.ACTIVE);
				chat.setUserName(each.getUsersNames());
				
				groupChatDeatails.setChat(chatDao.save(chat));
				groupChatDeatails.setGroupChat(groupChatDao.save(groupChat));
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			groupChatDetailsDao.save(groupChatDeatails);
		});
		
		return "Massage Edited Succsess . . !";
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#searchGroupChat(java.lang.String)
	 */
	@Override
	public GroupChatDto searchGroupChat(String groupId) throws Exception {
		
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupId, AppConstant.ACTIVE);
		
		GroupChatDto groupChatDto = getAllGroupChat(groupChat);
		
		return groupChatDto;
	}
	

	

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#promoteMember()
	 */
	@Override
	public String promoteMember(String memberId) throws Exception {
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(memberId, AppConstant.ACTIVE);
		
		return "";
	}
	
	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#getAllMembers(java.lang.String)
	 */
	@Override
	public List<MembersDto> getAllMembers(String groupId) throws Exception {
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupId, AppConstant.ACTIVE);
		List<Members>members = membersDao.findAllByGroupChatAndStatus(groupChat, AppConstant.ACTIVE);
		ArrayList<MembersDto>membersDtos = new  ArrayList<MembersDto>();
		
		members.forEach(each->{
			try {
				membersDtos.add(getMember(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return membersDtos;
	}
	
	private GroupChatDto getAllGroupsByNames(GroupChat groupChat)throws Exception{
		
		GroupChatDto groupChatDto = new GroupChatDto();
		groupChatDto.setGroupId(groupChat.getGroupId());
		groupChatDto.setGroupName(groupChat.getGroupName());
		return groupChatDto;
	}
	
	private GroupChatDto getAllGroupChat(GroupChat groupChat)throws Exception{
		
		GroupChatDto groupChatDto = new GroupChatDto();
		ArrayList<GroupChatDetailsDto> groupChatDetailsDtos = new ArrayList<>();
		groupChatDto.setGroupId(groupChat.getGroupId());
		groupChatDto.setCreateBy(groupChat.getCreateBy());
		groupChatDto.setCreateDate(groupChat.getCreateDate());
		groupChatDto.setCreateTime(groupChat.getCreateTime());
		
		groupChat.getMembers().forEach(each->{
			
		});
		
		groupChat.getGroupChatDeatails().forEach(each->{
		
			try {
				groupChatDetailsDtos.add(getDetails(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
				
		});
		
		groupChatDto.setGroupChatDetailsDtos(groupChatDetailsDtos);
	
		return groupChatDto;
	}

	
	private GroupChatDetailsDto getDetails(GroupChatDeatails groupChatDeatails)throws Exception{
		GroupChatDetailsDto groupChatDetailsDto = new GroupChatDetailsDto();
		ChatDto chatDto = new ChatDto();
		Chat chat= chatDao.findByChatIdAndStatusOrderByDateAsc(groupChatDeatails.getChat().getChatId(),AppConstant.ACTIVE);
		
		
		chatDto.setChatId(chat.getChatId());
		chatDto.setChatType(chat.getChatType());
		chatDto.setDate(chat.getDate());
		chatDto.setMassage(chat.getMassage());
		chatDto.setTime(chat.getTime());
		chatDto.setUserName(chat.getUserName());
		
		
		groupChatDetailsDto.setChatDto(chatDto);
		groupChatDetailsDto.setGroupDetailsId(groupChatDeatails.getGroupDetailsId());
		groupChatDetailsDto.setUsersNames(groupChatDeatails.getUsersNames());
		
		return groupChatDetailsDto;
	}
	
	private MembersDto getMember(Members members)throws Exception{
		MembersDto membersDto = new MembersDto();
		membersDto.setMemberId(members.getMemberId());
		membersDto.setMemberName(members.getMemberName());
		membersDto.setMemberUserDbId(members.getMemberUserDbId());
		membersDto.setRole(members.getRole());
		
		return membersDto;
	}

	/* (non-Javadoc)
	 * @see com.ains.chat.service.GroupChatService#loardAllGroupChat(java.lang.String)
	 */
	@Override
	public List<GroupChatDetailsDto> loardAllGroupChat(String groupId) throws Exception {
		
		GroupChat groupChat = groupChatDao.findOneByGroupIdAndStatus(groupId, AppConstant.ACTIVE);
		
		List<GroupChatDeatails>groupChatDeatails = groupChatDetailsDao.findAllByGroupChatAndStatusOrderByDateAsc(groupChat,AppConstant.ACTIVE);
		
		ArrayList<GroupChatDetailsDto>groupChatDetailsDtos = new ArrayList<>();
		
		groupChatDeatails.forEach(each->{
			try {
				groupChatDetailsDtos.add(getDetails(each));
			} catch (Exception e) {
				e.printStackTrace();
			}
		});
		return groupChatDetailsDtos;
	}

	
 }
