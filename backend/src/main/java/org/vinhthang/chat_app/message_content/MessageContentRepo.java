package org.vinhthang.chat_app.message_content;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MessageContentRepo extends JpaRepository<MessageContent, UUID> {
}
