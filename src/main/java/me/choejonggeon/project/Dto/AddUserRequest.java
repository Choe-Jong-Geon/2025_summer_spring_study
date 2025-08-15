package me.choejonggeon.project.Dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AddUserRequest {
    public String id;
    public String name;
    public String password;
    public String expiration;
}
