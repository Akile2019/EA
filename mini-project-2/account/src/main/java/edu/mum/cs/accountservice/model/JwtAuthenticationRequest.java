package edu.mum.cs.accountservice.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class JwtAuthenticationRequest {
    private String useraccount;
    private String password;
}
