package org.vinhthang.chat_app.message_room;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.vinhthang.chat_app.user.User;
import org.vinhthang.chat_app.user.UserRepo;

@Component
@RequiredArgsConstructor
public class MessageRoomMapper {

    final UserRepo userRepo;

    public MessageRoomDTO toDTO(final MessageRoom messageRoom, final MessageRoomDTO messageRoomDTO) {
        messageRoomDTO.setId(messageRoom.getId());
        messageRoomDTO.setName(messageRoom.getName());
        messageRoomDTO.setIsGroup(messageRoom.getIsGroup());
        messageRoomDTO.setCreatedDate(messageRoom.getCreatedDate());
        messageRoomDTO.setCreatedBy(messageRoom.getCreatedBy().getUsername());

        return messageRoomDTO;
    }

    public MessageRoom toEntity(final MessageRoomDTO messageRoomDTO, final MessageRoom messageRoom) {
        messageRoom.setId(messageRoomDTO.getId());
        messageRoom.setName(messageRoomDTO.getName());
        messageRoom.setIsGroup(messageRoomDTO.getIsGroup());
        messageRoom.setCreatedDate(messageRoomDTO.getCreatedDate());
        final User createdBy = messageRoomDTO.getCreatedBy() == null ? null : userRepo.findById(messageRoomDTO.getCreatedBy())
                .orElseThrow(() -> new EntityNotFoundException("User not found"));
        messageRoom.setCreatedBy(createdBy);

        return messageRoom;
    }
}
