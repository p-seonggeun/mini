package io.goorm.mini.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.bcrypt.BCrypt;

@Slf4j
public class PasswordUtil {

    public static String encryptPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public static boolean matches(String rawPassword, String encryptedPassword) {
        log.debug("encryptPassword(rawPassword) : " + encryptPassword(rawPassword));
        log.debug("encryptedPassword : " + encryptedPassword);

        return BCrypt.checkpw(rawPassword, encryptedPassword);


    }

}
