package io.goorm.mini.config;

import org.jasypt.encryption.pbe.StandardPBEStringEncryptor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


@Configuration
public class JasyptConfig {

    @Value("${jasypt.encryptor.location}")
    private String filePath;

    @Bean("jasyptStringEncryptor")
    public StandardPBEStringEncryptor stringEncryptor() throws IOException {

        StandardPBEStringEncryptor encryptor = new StandardPBEStringEncryptor();

        Properties properties = new Properties();
        properties.load(new FileInputStream(filePath));

        String encryptKey = properties.getProperty("encryption.key");
        encryptor.setPassword(encryptKey);
        encryptor.setAlgorithm("PBEWithMD5AndDES");

        return encryptor;
    }

}
