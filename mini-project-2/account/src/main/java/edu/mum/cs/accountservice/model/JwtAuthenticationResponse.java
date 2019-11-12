package edu.mum.cs.accountservice.model;

public class JwtAuthenticationResponse {
    private final String jsonwebtoken;

    public JwtAuthenticationResponse(String jsonwebtoken) {
        this.jsonwebtoken = jsonwebtoken;
    }

    public String getJsonwebtoken() {
        return jsonwebtoken;
    }
}
