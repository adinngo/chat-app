package org.vinhthang.chat_app.message_room_member;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.vinhthang.chat_app.message_room.MessageRoom;
import org.vinhthang.chat_app.message_room.MessageRoomRepo;
import org.vinhthang.chat_app.user.User;
import org.vinhthang.chat_app.user.UserRepo;

@Component
@RequiredArgsConstructor
public class MessageRoomMemberMapper {

    final UserRepo userRepo;
    final MessageRoomRepo messageRoomRepo;

    public MessageRoomMemberDTO toDTO(final MessageRoomMember messageRoomMember, final MessageRoomMemberDTO messageRoomMemberDTO) {
        messageRoomMemberDTO.setMessageRoomId(messageRoomMember.getMessageRoom().getId());
        messageRoomMemberDTO.setUsername(messageRoomMember.getUser().getUsername());
        messageRoomMemberDTO.setIsAdmin(messageRoomMember.getIsAdmin());
        messageRoomMemberDTO.setLastSeen(messageRoomMember.getLastSeen());
        messageRoomMemberDTO.setLastLogin(messageRoomMember.getUser().getLastLogin());
        return messageRoomMemberDTO;
    }


    public MessageRoomMember toEntity(final MessageRoomMemberDTO messageRoomMemberDTO, final MessageRoomMember messageRoomMember) {
        final MessageRoom messageRoom = messageRoomMemberDTO.getMessageRoomId() == null ? null :
                messageRoomRepo.findById(messageRoomMemberDTO.getMessageRoomId())
                .orElseThrow(() -> new EntityNotFoundException("MessageRoom not found"));
        messageRoomMember.setMessageRoom(messageRoom);

        final User createdBy = messageRoomMemberDTO.getUsername() == null ? null :
                userRepo.findById(messageRoomMemberDTO.getUsername())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));

        messageRoomMember.setUser(createdBy);
        messageRoomMember.setIsAdmin(messageRoomMemberDTO.getIsAdmin());
        messageRoomMember.setLastSeen(messageRoomMemberDTO.getLastSeen());

        return messageRoomMember;
    }
}
