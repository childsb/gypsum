package posix;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.UnsatisfiedLinkError;

public class Process{

	public static final int SUCCESS = 0;
    public static final int FAILURE = -1;
    public static final String LIB_NAME = "posixProcess.so";
    

    public static native int setuid(int uid);
    public static native int seteuid(int uid);
    public static native int setgid(int gid);
    public static native int setegid(int gid);
    
	static {
		try{
				System.loadLibrary("posix_Process");
        	}catch(UnsatisfiedLinkError ex){
        		
        		String libPath = System.getProperty("JAVA_POSIX_LIBRARY");
        		if(libPath == null){
        			libPath=System.getProperty("user.home");
        		}
        		System.out.println("Could looad library in: " + System.getProperty("java.library.path\nTrying:") + libPath);
        		
        		if(libPath!=null && !"".equals(libPath)){
        		    System.out.println("Loading library from " + libPath);
        		    System.load(libPath);
        		}else{
        		    // load the library from the JAR file.
        		    java.lang.Process p;
                    try{
                        p=Runtime.getRuntime().exec("uname");
                    
        	        BufferedReader brInput=new BufferedReader(new InputStreamReader(p.getInputStream()));

        	        StringBuffer unameResult=new StringBuffer();
        	        String s = null;
        	        while ((s=brInput.readLine())!=null)
                        unameResult.append(s);
        	        
        	        File fileOut = LoaderUtil.getTempFile(LIB_NAME);
        	        libPath = unameResult.toString() + "/" + LIB_NAME;
                    
        	        LoaderUtil.copyFileFromJar(libPath, fileOut);
        	        System.out.println("Loading library from JAR.  Absolute path: " + libPath);
        	        System.load(fileOut.getAbsolutePath());
                    
                    }catch (IOException e){
                        // TODO Auto-generated catch block
                        e.printStackTrace();
        	        }
        		    
        		}
        	
        	}
    }
    
	public static void main(String[] argv){
		
		Process nt = new Process();
		
		System.out.println("Invocation returned " + nt.setuid(459));
	}

}
