package com.hems.models;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
public class AuthenticationResponse {
    public String token;
}
