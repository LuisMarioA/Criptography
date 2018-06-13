package leerescribirarchivos;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFileChooser;

public class LeerEscribirArchivos {
    public static byte[] leerArchivo(String nombreArchivo){
        InputStream inputStream;
        try {
            inputStream = new FileInputStream( nombreArchivo );
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            final byte[] BUFFER = new byte[1024];
            int readed = -1;
            while ((readed = inputStream.read(BUFFER)) != -1) {
                baos.write(BUFFER, 0, readed);
            }
            return baos.toByteArray();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static int escribeArchivo(String nombreArchivo, byte[] bytes){
        try {
            OutputStream fich_out = new FileOutputStream ( nombreArchivo );
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream( );
            outputStream.write( bytes );
            fich_out.write(outputStream.toByteArray());
            fich_out.close();
            return 0;
        } catch (IOException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 1;
    }
    
    public static byte[] AES_DES(int modo,byte[] bytes,String clave,String standard,String metodo){
        try{
            byte[] bloqueCifrado=null;
            SecretKeySpec ks = new SecretKeySpec(clave.getBytes(),standard);
            Cipher cifrado = Cipher.getInstance(standard+"/"+metodo+"/PKCS5Padding");
            //Escojo modo cifrado o descifrado segun sea el caso
            byte[] ivDES = {1,2,3,4,5,6,7,8};
            byte[] ivAES = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6};
            //MODO 1 ENCRYPT
            if (modo==1){
                if(metodo.equals("ECB"))
                    cifrado.init(Cipher.ENCRYPT_MODE, ks);
                else{
                    if(standard.equals("DES")){
                        IvParameterSpec ivspec = new IvParameterSpec(ivDES);
                        cifrado.init(Cipher.ENCRYPT_MODE, ks, ivspec);
                        System.out.println("Encrypt");
                    }else if(standard.equals("AES")){
                        IvParameterSpec ivspec = new IvParameterSpec(ivAES);
                        cifrado.init(Cipher.ENCRYPT_MODE, ks, ivspec);
                        System.out.println("Encrypt");
                    }
                }
            }
            //MODO = 2 DECRYPT
            else if (modo==2){
                if(metodo.equals("ECB"))
                    cifrado.init(Cipher.DECRYPT_MODE, ks);
                else{
                    if(standard.equals("DES")){
                        IvParameterSpec ivspec = new IvParameterSpec(ivDES);
                        cifrado.init(Cipher.DECRYPT_MODE, ks, ivspec);
                        System.out.println("Decrypt");
                    }else if(standard.equals("AES")){
                        IvParameterSpec ivspec = new IvParameterSpec(ivAES);
                        cifrado.init(Cipher.DECRYPT_MODE, ks, ivspec);
                        System.out.println("Decrypt");
                    }
                }
            }
            bloqueCifrado = cifrado.doFinal(bytes);
            return bloqueCifrado;
        } catch (InvalidKeyException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalBlockSizeException ex) {
        Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (BadPaddingException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidAlgorithmParameterException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public static byte[] privateKeyRSAencrypt(PrivateKey privateKey, byte[] bytes) 
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  
        return cipher.doFinal(bytes);  
    }
    
    public static byte[] publicKeyRSAdecrypt(PublicKey publicKey, byte [] encrypted) 
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);
        return cipher.doFinal(encrypted);
    }
    
    public static byte[] publicKeyRSAencrypt(PublicKey publicKey, byte[] bytes) 
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
        return cipher.doFinal(bytes);  
    }
    
    public static byte[] privateKeyRSAdecrypt(PrivateKey privateKey, byte [] encrypted) 
            throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        return cipher.doFinal(encrypted);
    }
    
    
    public static byte[] getHash(byte[] bytes,String opcion) {
        try {
            java.security.MessageDigest md = java.security.MessageDigest
                .getInstance(opcion);
            byte[] array = md.digest(bytes);
            return array;
        } catch (java.security.NoSuchAlgorithmException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }
    
    public static PrivateKey readPrivateKey(byte[] bytes) 
            throws IOException, NoSuchAlgorithmException, InvalidKeySpecException{    
        PKCS8EncodedKeySpec ks = new PKCS8EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PrivateKey pvt = kf.generatePrivate(ks);
        return pvt;
    }
    
    public static PublicKey readPublicKey(byte[] bytes) 
            throws NoSuchAlgorithmException, InvalidKeySpecException, IOException{
        X509EncodedKeySpec ks = new X509EncodedKeySpec(bytes);
        KeyFactory kf = KeyFactory.getInstance("RSA");
        PublicKey pub = kf.generatePublic(ks);
        return pub;
    }
    
    public static String bytesToString(byte[] bytes){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < bytes.length; ++i) {
            sb.append(Integer.toHexString((bytes[i] & 0xFF) | 0x100)
                .substring(1, 3));
        }
        return sb.toString();
    }
    
    public static String creaCadena(int n){
        char[] conjunto = new char[n];
        for(int i=0;i<n;i++){
            int el = (int)(Math.random()*256);
            conjunto[i] = (char)el;
        }
        System.out.println(new String(conjunto));
        return new String(conjunto);
    }
    
    public static boolean proccesEncrypt(PrivateKey privateKey,PublicKey publicKey,String rutaArchivo,
            String nombreArchivo,String standard,String metodo,String hash){
        try{
            int longClave=0;
            byte[] bytes=leerArchivo(rutaArchivo + "\\" + nombreArchivo); //Ruta del archivo
            String claveA="";
            if(standard.equals("AES")){
                claveA=creaCadena(16);
                longClave=16;
            }else if(standard.equals("DES")){
                claveA=creaCadena(8);
                longClave=8;
            }
            byte[] bytesClave=publicKeyRSAencrypt(publicKey,claveA.getBytes());
            String clave=bytesToString(claveA.getBytes()).substring(0,longClave);
            System.out.println(clave);
            byte[] bytesCifrados=AES_DES(1,bytes,clave,standard,metodo);
            byte[] bytesHash=getHash(bytes,hash);
            System.out.println(bytesToString(bytesHash));
            byte[] bytesHashCifrados = privateKeyRSAencrypt(privateKey, bytesHash);
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            outputStream.write( bytesClave );
            outputStream.write( bytesHashCifrados );
            outputStream.write( bytesCifrados );
            escribeArchivo(rutaArchivo+"\\encryptedFile.txt", outputStream.toByteArray()); //Ruta del archivo
            return true;
        }catch (Exception ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
    }
    
    public static boolean proccesDecrypt(PublicKey publicKey,PrivateKey privateKey,String rutaArchivo,
            String nombreArchivo,String standard,String metodo,String hash){
        try{
            int longClave=8;
            if(standard.equals("AES"))
                longClave=16;
            byte[] bytes=leerArchivo(nombreArchivo); //Reuta del archivo
            byte[] bytesClaveCifrada=new byte[256];
            byte[] bytesHashCifrado=new byte[256];
            byte[] bytesDatosCifrados=new byte[bytes.length-256-256];
            System.arraycopy(bytes, 0, bytesClaveCifrada, 0, 256);
            System.arraycopy(bytes, 256, bytesHashCifrado, 0, 256);
            System.arraycopy(bytes, 256+256, bytesDatosCifrados, 0, bytes.length-256-256);
            byte[] bytesClave=privateKeyRSAdecrypt(privateKey, bytesClaveCifrada);
            byte[] bytesHash=publicKeyRSAdecrypt(publicKey, bytesHashCifrado);
            System.out.println(bytesToString(bytesHash));
            String clave=bytesToString(bytesClave);
            System.out.println(clave.substring(0, longClave));
            byte[] bytesDatos=AES_DES(2,bytesDatosCifrados,clave.substring(0, longClave),standard,metodo);
            byte[] bytesHashDatos=getHash(bytesDatos,hash);
            if(bytesToString(bytesHash).equals(bytesToString(bytesHashDatos))){
                System.out.println("Correcto");
                escribeArchivo(rutaArchivo+"\\decryptedFile.txt", bytesDatos); //Ruta del archivo
                return true;
            }
        }catch (Exception ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return false;
    }
    
    public static File seleccionarArchivo(){
        JFileChooser fc = new JFileChooser();
        fc.setCurrentDirectory(new File("."));
        int respuesta = fc.showOpenDialog(fc);
        if (respuesta == JFileChooser.APPROVE_OPTION){
            return fc.getSelectedFile();
        }
        return null;
    }
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        try{
            byte[] privateKeyBytes=leerArchivo("privada.key");
            PrivateKey privateKey=readPrivateKey(privateKeyBytes);
            byte[] publicKeyBytes=leerArchivo("publica.key");
            PublicKey publicKey=readPublicKey(publicKeyBytes);
            File file=seleccionarArchivo();
            String rutaArchivo=file.getParentFile().toString();
            String nombreArchivo=file.getName();
            proccesEncrypt(privateKey,publicKey,rutaArchivo,nombreArchivo,"AES","OFB","MD5");
            file=seleccionarArchivo();
            rutaArchivo=file.getParentFile().toString();
            nombreArchivo=file.getName();
            proccesDecrypt(publicKey,privateKey,rutaArchivo,nombreArchivo,"AES","OFB","MD5");
        }catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InvalidKeySpecException ex) {
            Logger.getLogger(LeerEscribirArchivos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //----Docum¿ento a cifrar, AES/DES, Cifrar,Decifrar, METDOD OFB;TC, HASH----
    /*
    4e838a0859cbcbd73171a5f0dfbd0a560026dd02
    daaef200ebb921e011e3ae922dd3266b
    */
}