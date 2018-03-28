package jwt;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;

import java.io.File;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.util.Objects;

public class JwtRsaUtils {

    private static final String ISSUER = "aerodc";
    private final RSAPublicKey publicKey;
    private final RSAPrivateKey privateKey;


    public JwtRsaUtils() {
        this.publicKey = RSAKeysLoader.createPublicKeyPKCS1Format(readFile("jwt/jwtRS256.key"));
        this.privateKey = RSAKeysLoader.createPrivateKeyPKCS1Format(readFile("jwt/jwtRS256.key"));
    }

    public String signToken(){
        try {
            Algorithm algorithm = Algorithm.RSA256(null, this.privateKey);
            return JWT.create()
                    .withIssuer(ISSUER)
                    .sign(algorithm);
        } catch (JWTCreationException exception){
            //Invalid Signing configuration / Couldn't convert Claims.
            return null;
        }
    }

    public boolean verifyToken(String token){
        try {
            Algorithm algorithm = Algorithm.RSA256(publicKey, null);
            JWTVerifier verifier = JWT.require(algorithm)
                    .withIssuer(ISSUER)
                    .build();
            verifier.verify(token);
            return true;
        } catch (Exception e){
            return false;
        }
    }

    private File readFile(String fileName){
        ClassLoader classLoader = getClass().getClassLoader();
        return new File(Objects.requireNonNull(classLoader.getResource(fileName)).getFile());
    }
}
