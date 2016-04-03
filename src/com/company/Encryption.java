package com.company;

import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by User on 03.04.2016.
 */
public class Encryption {
    public static void main(String[] args) {
        try {
            String password = "Hi Johny. It's Walker!";
          //  System.out.println("plain pass="+password);
            String encryptedPassword = Encryprt.encrypt(password);
            //System.out.println("encrypted pass="+encryptedPassword);
            String decryptedPassword = Encryprt.decrypt(encryptedPassword);
         //   System.out.println("decrypted pass="+decryptedPassword);
            byte[] data = encryptedPassword.getBytes();
            byte[] data1 = decryptedPassword.getBytes();
            Path c = Paths.get("./module10.txt");


            try (OutputStream out = new BufferedOutputStream(
                    Files.newOutputStream(c))){
                out.write(data, 0, data.length);
                out.write(data1, 0, data1.length);
            }
            catch (IOException x){
                System.err.println(x);

            }

        } catch(Exception e) { System.out.println("bug"+e.getMessage()); }

    }
}
