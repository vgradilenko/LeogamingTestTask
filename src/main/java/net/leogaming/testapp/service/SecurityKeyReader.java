package net.leogaming.testapp.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

@Component
public class SecurityKeyReader {

    private final static String PUBLIC_KEY = "public_key.der";
    private final static String PRIVATE_KEY = "private_key.der";
    private ClassLoader classLoader = getClass().getClassLoader();

    @Bean
    public PublicKey getPublicKey() throws Exception {
        File file = new File(Objects.requireNonNull(classLoader.getResource(PUBLIC_KEY)).getFile());
        byte[] keyBytes = Files.readAllBytes(file.toPath());
        X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePublic(spec);
    }

    @Bean
    public PrivateKey getPrivateKey() throws Exception {
        File file = new File(Objects.requireNonNull(classLoader.getResource(PRIVATE_KEY)).getFile());
        byte[] keyBytes = Files.readAllBytes(file.toPath());
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        return kf.generatePrivate(spec);
    }
}
