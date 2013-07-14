package posix;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;


public class LoaderUtil{

    
    

    public static void copyJarFolder(String folderName){
        URL me = LoaderUtil.class.getProtectionDomain().getCodeSource().getLocation();
       
    
    
    
    }
    
        private static void copyJarFolder(String jarName, String folderName, String dest) {
          
          try {
               ZipFile z = new ZipFile(jarName);
               Enumeration entries = z.entries();
               while (entries.hasMoreElements()) {
                    ZipEntry entry = (ZipEntry)entries.nextElement();
                    if (entry.getName().contains(folderName)) {
                         File f = new File(entry.getName());
                         if (entry.isDirectory()) {
                              f.mkdir();
                         }
                         else if (!f.exists()) {
                              File destFile = new File(dest + System.getProperty("system.seperator") +  entry.getName());
                              if (copyFromJar(entry.getName(), destFile)) {
                                   System.out.println("Copied: " + entry.getName());
                              }
                         }
                    }
               }
          }
          catch (IOException e) {
               e.printStackTrace();
          }
     }
        /* 
      * Copies a file out of the jar to a physical location.  
      *    Doesn't need to be private, uses a resource stream, so may have
      *    security errors if ran from webstart application 
      */
     public static boolean copyFromJar(String sResource, File fDest) {
          if (sResource == null || fDest == null) return false;
          InputStream sIn = null;
          OutputStream sOut = null;
          File sFile = null;
          try {
               fDest.getParentFile().mkdirs();
               sFile = new File(sResource);
          }
          catch(Exception e) {}
          try {
               int nLen = 0;
               sIn = LoaderUtil.class.getResourceAsStream(sResource);
               if (sIn == null)
                    throw new IOException("Error copying from jar"  + 
                         "(" + sResource + " to " + fDest.getPath() + ")");
               sOut = new FileOutputStream(fDest);
               byte[] bBuffer = new byte[1024];
               while ((nLen = sIn.read(bBuffer)) > 0)
                    sOut.write(bBuffer, 0, nLen);
               sOut.flush();
          }
          catch(IOException ex) {
               ex.printStackTrace();
          }
          finally {
               try {
                    if (sIn != null)
                         sIn.close();
                    if (sOut != null)
                         sOut.close();
               }
               catch (IOException eError) {
                    eError.printStackTrace();
               }
          }
          return fDest.exists();
     }

}
