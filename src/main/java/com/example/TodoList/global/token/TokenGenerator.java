package com.example.TodoList.global.token;

public class TokenGenerator {

    // 암호화
    public static String encryptId (Long userId) {
        return "fshfjhasf" + userId + "471d21d";
    }

    // 복호화
    public static Long decrypt (String token) {
        return Long.parseLong(token.substring(9, token.length()-7));

    }
}