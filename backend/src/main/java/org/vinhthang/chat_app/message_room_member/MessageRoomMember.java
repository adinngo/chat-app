package org.vinhthang.chat_app.message_room_member;


import jakarta.persistence.*;
import lombok.*;
import org.vinhthang.chat_app.message_room.MessageRoom;
import org.vinhthang.chat_app.user.User;

import java.time.LocalDateTime;

@Entity
@Table(name = "message_room_member")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@IdClass(MessageRoomMemberKey.class)
public class MessageRoomMember {

    @Id
    @ManyToOne
    @JoinColumn(name = "message_room_id")
    private MessageRoom messageRoom;

    @Id
    @ManyToOne
    @JoinColumn(name = "username")
    private User user;

    private Boolean isAdmin;

    private LocalDateTime lastSeen;


}
