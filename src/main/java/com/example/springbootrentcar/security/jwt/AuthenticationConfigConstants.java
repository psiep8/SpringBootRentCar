package com.example.springbootrentcar.security.jwt;


public class AuthenticationConfigConstants {
    public static final String SECRET = "Secret";
    public static final long EXPIRATION_TIME = 864000000; // 10 days
    public static final String HEADER_STRING = "Authorization";
}
