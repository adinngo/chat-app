package org.vinhthang.chat_app.message_content;


import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.vinhthang.chat_app.message_room.MessageRoom;
import org.vinhthang.chat_app.message_room.MessageRoomRepo;
import org.vinhthang.chat_app.user.User;
import org.vinhthang.chat_app.user.UserRepo;

@Component
@RequiredArgsConstructor
public class MessageContentMapper {

    final MessageRoomRepo messageRoomRepo;
    final UserRepo userRepo;

    public MessageContentDTO toDTO(final MessageContent messageContent, final MessageContentDTO messageContentDTO) {
        messageContentDTO.setId(messageContent.getId());
        messageContentDTO.setContent(messageContent.getContent());
        messageContentDTO.setDateSent(messageContent.getDateSent());
        messageContentDTO.setMessageType(messageContent.getMessageType());
        messageContentDTO.setMessageRoomId(messageContent.getMessageRoom().getId());
        messageContentDTO.setSender(messageContent.getUser().getUsername());
        return messageContentDTO;
    }

    public MessageContent toEntity(final MessageContentDTO messageContentDTO, final MessageContent messageContent) {
        messageContent.setId(messageContentDTO.getId());
        messageContent.setContent(messageContentDTO.getContent());
        messageContent.setDateSent(messageContentDTO.getDateSent());
        messageContent.setMessageType(messageContentDTO.getMessageType());

        final MessageRoom messageRoom = messageContentDTO.getMessageRoomId() == null ? null :
                messageRoomRepo.findById(messageContentDTO.getMessageRoomId())
                        .orElseThrow(() -> new EntityNotFoundException("Message Room not found"));

        final User user = messageContentDTO.getSender() == null ? null :
                userRepo.findById(messageContentDTO.getSender())
                        .orElseThrow(() -> new EntityNotFoundException("User not found"));
        return messageContent;
    }
}
