/**
 * Jun 11, 2019	
 * AinsChatApplication
 * com.ains.chat.dao
 */
package com.ains.chat.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ains.chat.model.GroupChat;
import com.ains.chat.model.Members;

/**
 * @author Tharaka Chandralal
 */
public interface MembersDao extends CrudRepository<Members, String>{

	Members findOneByMemberNameAndStatus(String memberName,String status);
	
	Members findOneByMemberIdAndStatus(String memberId,String status);
	
	List<Members>findAllByMemberNameAndStatus(String memberName,String status);
	
	List<Members>findAllByGroupChatAndStatus(GroupChat groupChat,String status);
	
	Members findOneByGroupChatAndMemberNameAndStatus(GroupChat groupChat,String memberName,String status);
	
	Members findOneByGroupChatAndStatus(GroupChat groupChat,String status);
}
