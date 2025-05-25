package org.vinhthang.chat_app.message_room;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
public class MessageRoomDTO {
    private UUID id;

    private String name;

    private Boolean isGroup;

    private LocalDateTime createdDate;

    private String createdBy;
}
