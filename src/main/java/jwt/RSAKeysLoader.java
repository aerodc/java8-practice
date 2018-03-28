package jwt;


import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openssl.PEMKeyPair;
import org.bouncycastle.openssl.PEMParser;
import org.bouncycastle.openssl.jcajce.JcaPEMKeyConverter;

import java.io.File;
import java.io.FileReader;
import java.security.KeyPair;
import java.security.Security;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;

public class RSAKeysLoader {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static RSAPrivateKey createPrivateKeyPKCS1Format(File privateKeyFile) {
        try {
            PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
            Object object = pemParser.readObject();
            KeyPair kp = converter.getKeyPair((PEMKeyPair) object);
            return (RSAPrivateKey) kp.getPrivate();
        } catch (Exception e) {
            return null;
        }
    }

    public static RSAPublicKey createPublicKeyPKCS1Format(File privateKeyFile) {
        try {
            PEMParser pemParser = new PEMParser(new FileReader(privateKeyFile));
            JcaPEMKeyConverter converter = new JcaPEMKeyConverter().setProvider("BC");
            Object object = pemParser.readObject();
            KeyPair kp = converter.getKeyPair((PEMKeyPair) object);

            return (RSAPublicKey) kp.getPublic();
        } catch (Exception e) {
            return null;
        }
    }
}
