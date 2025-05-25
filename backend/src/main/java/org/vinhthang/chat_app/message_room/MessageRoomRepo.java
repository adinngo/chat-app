package org.vinhthang.chat_app.message_room;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageRoomRepo extends JpaRepository<MessageRoom, UUID> {
}
