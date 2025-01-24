package io.goorm.mini.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


//@Configuration
public class JasyptConfig {

    @Value("${jasypt.encryptor.keyholder}")
    private String secretKey;

    @Bean("jasyptStringEncryptor")
    public StandardPBEStringEncryptor stringEncryptor() throws IOException {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

        encryptor.setPassword(secretKey);
        encryptor.setAlgorithm("PBEWithMD5AndDES");

        return encryptor;
    }

}
