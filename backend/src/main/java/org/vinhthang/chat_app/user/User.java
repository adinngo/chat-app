package org.vinhthang.chat_app.user;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.engine.internal.Cascade;
import org.vinhthang.chat_app.message_content.MessageContent;
import org.vinhthang.chat_app.message_room.MessageRoom;
import org.vinhthang.chat_app.message_room_member.MessageRoomMember;
import org.vinhthang.chat_app.user.UserStatus;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "app_user")
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class User {

    @Id
    private String username;

    private String password;

    @Enumerated(EnumType.STRING)
    private UserStatus status;

    private LocalDateTime lastLogin = LocalDateTime.now();

    private String avatarUrl;

    @OneToMany(mappedBy = "createdBy")
    private List<MessageRoom> messageRooms;

    @OneToMany(mappedBy = "user")
    private List<MessageRoomMember> messageRoomMembers;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<MessageContent> messageContents;

}
