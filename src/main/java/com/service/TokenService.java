// src/main/java/com/smartclinic/service/TokenService.java
package main.java.com.service;

import org.springframework.stereotype.Service;

@Service
public class TokenService {

    public boolean validateToken(String token) {
        // stub always true for demo
        return token != null && !token.isBlank();
    }
}
