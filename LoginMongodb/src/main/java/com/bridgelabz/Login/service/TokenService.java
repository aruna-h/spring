package com.bridgelabz.Login.service;

import java.io.UnsupportedEncodingException;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

/**
 * @author bridgelabz
 *
 */
@Service
public class TokenService {

	public static final String TOKEN_SECRET = "what";

	/**
	 * method of creating token
	 * @param string
	 * @return
	 */
	public String createToken(String string) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			String token = JWT.create().withClaim("id", string.toString()).withClaim("createdAt", new Date())
					.sign(algorithm);
			return token;
		} catch (UnsupportedEncodingException exception) {
			exception.printStackTrace();
			// log WRONG Encoding message
		} catch (JWTCreationException exception) {
			exception.printStackTrace();
			// log Token Signing Failed
		}
		return null;
	}

	public String getUserIdFromToken(String token) {
		try {
			Algorithm algorithm = Algorithm.HMAC256(TOKEN_SECRET);
			JWTVerifier verifier = JWT.require(algorithm).build();
			DecodedJWT jwt = verifier.verify(token);
			return jwt.getClaim("id").asString();
		} catch (UnsupportedEncodingException exception) {
			exception.printStackTrace();
			// log WRONG Encoding message
			return null;
		} catch (JWTVerificationException exception) {
			exception.printStackTrace();
			// log Token Verification Failed
			return null;
		}
	}

	/**
	 * checking whether token is valid or not
	 * @param token
	 * @return
	 */
	public boolean isTokenValid(String token) {
		String userId = this.getUserIdFromToken(token);
		return userId != null;
	}
}