package org.vinhthang.chat_app.user;


import lombok.Data;



@Data
public class UserDTO {

    private String username;

    private String password;

    private UserStatus status;

    private String avatarUrl;


}
