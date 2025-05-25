package org.vinhthang.chat_app.message_room_member;

import lombok.Data;
import org.vinhthang.chat_app.message_room.MessageRoom;
import org.vinhthang.chat_app.user.User;

import java.io.Serializable;

@Data
public class MessageRoomMemberKey implements Serializable {

    private User user;

    private MessageRoom messageRoom;


}
