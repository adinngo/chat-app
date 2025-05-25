package org.vinhthang.chat_app.message_room_member;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRoomMemberRepo extends JpaRepository<MessageRoomMember, MessageRoomMemberKey> {
}
