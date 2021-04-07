package com.simsoft.transport.dto;

import lombok.Data;

@Data
public class RegistrationRequest {
    private String nameSurname;
    private String username;
    private String password;
    private String email;
}
