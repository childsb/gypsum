package posix;
import java.lang.UnsatisfiedLinkError;

public class Process{

	public static final int SUCCESS = 0;
    public static final int FAILURE = -1;

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
        		System.load(libPath + "posix_Process.jnilib");
        		
        	
        	}
    }
    
	public static void main(String[] argv){
		
		Process nt = new Process();
		
		System.out.println("Invocation returned " + nt.setuid(459));
	}

}
