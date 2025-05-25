package org.vinhthang.chat_app.message_room_member;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageRoomMemberDTO {

    private UUID messageRoomId;

    private String username;

    private Boolean isAdmin;

    private LocalDateTime lastSeen;

    private LocalDateTime lastLogin;

}
