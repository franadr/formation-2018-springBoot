package com.intech.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.*;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Date;

import static java.util.Collections.emptyList;


@Service
public class JwtService {

    @Value("${security.jwt.expiration}")
    private long EXPIRATIONTIME ; // 10 days
    @Value("${security.jwt.secret}")
    private String SECRET ;
    @Value("${security.jwt.token.prefix}")
    private String TOKEN_PREFIX ;
    @Value("${security.jwt.header.string}")
    private String HEADER_STRING ;
    private KeyStore keyStore = null;

    public JwtService() {
        try {
            this.keyStore = KeyStore.getInstance(KeyStore.getDefaultType());
        } catch (KeyStoreException e) {
            e.printStackTrace();
        }
    }

    public String generateJwt(String username) {

        {
            try {

                keyStore.load(new FileInputStream("myapp.jks"),"keystorepassword".toCharArray());
                Key key = keyStore.getKey("heroes2","adriano17".toCharArray());
                return Jwts.builder()
                        .setSubject(username)
                        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATIONTIME))
                        .signWith(SignatureAlgorithm.RS256, key)
                        .compact();
            } catch (KeyStoreException | CertificateException | UnrecoverableKeyException | NoSuchAlgorithmException | IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }

    public Authentication getAuthentication(HttpServletRequest request) {
        Key key;
        PublicKey publicKey = null;

        try{
        
        keyStore.load(new FileInputStream("myapp.jks"),"keystorepassword".toCharArray());
        key = keyStore.getKey("heroes2","adriano17".toCharArray());

        X509Certificate certificate = (X509Certificate) keyStore.getCertificate("heroes2");

        publicKey = certificate.getPublicKey();

    } catch (CertificateException | UnrecoverableKeyException | NoSuchAlgorithmException | IOException | KeyStoreException e) {
        e.printStackTrace();
    }
    String token = request.getHeader(HEADER_STRING);

        if (token != null) {
        // parse the token.
        String user = Jwts.parser()
                .setSigningKey(publicKey)
                .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                .getBody()
                .getSubject();

        return user != null ?
                new UsernamePasswordAuthenticationToken(user, null, emptyList()) :
                null;
    }
        return null;
}
}


