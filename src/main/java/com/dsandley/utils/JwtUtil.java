/**
 * 
 */
package com.dsandley.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import io.jsonwebtoken.Claims;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author daniel Service to extract data from the JWT
 */

@Service
public class JwtUtil {

    // TODO to assign this to a env variable
    /**
     * jwt secret.
     */
    private String secretKey = "secret";
    //TODO disable magic number in check styles
    /**
     * time modifer that is hard coded then passed in.
     */
    private int timeModifier = 1000 * 60 * 60 * 10;

    /**
     * Returns back the username from the jwt.
     * @param token
     * @return username
     */
    public String extractUsername(final String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * Returns back the expiration date of the token.
     * @param token
     * @return expiration date
     */
    public Date extractExpiration(final String token) {
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * Extracts all the claims from the token.
     * @param claimsResolver
     * @param <T>
     * @param token
     * @return claim
     */
    public <T> T extractClaim(final String token,
            final Function<Claims, T>  claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    /**
     * parses out all the info.
     * @param token
     * @return JWT
     */
    private Claims extractAllClaims(final String token) {
        return Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token)
                .getBody();
    }

    /**
     * checks to see if the token is expired.
     * @param token
     * @return boolean
     */
    private Boolean isTokenExpired(final String token) {
        return extractExpiration(token).before(new Date());
    }

    /**
     * returns a new token.
     * @param userDetails
     * @return JWT
     */
    public String generateToken(final UserDetails userDetails) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, userDetails.getUsername());
    }

    /**
     * returns back a new token.
     * @param claims
     * @param subject
     * @return token
     */

    private String createToken(final Map<String, Object> claims,
            final String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(
                        System.currentTimeMillis() + timeModifier))
                .signWith(SignatureAlgorithm.HS256, secretKey).compact();
    }

    /**
     * validates the JWT.
     * @param token
     * @param userDetails
     * @return boolean
     */
    public Boolean validateToken(final String token,
            final UserDetails userDetails) {
        final String username = extractUsername(token);
        return (username.equals(userDetails.getUsername())
                && !isTokenExpired(token));
    }
}
