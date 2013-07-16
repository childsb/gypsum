package posix;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Vector;

public class UserUtil{
    private static final int NAME_LOCATION = 0;
    private static final int PASSWORD_LOCATION = 1;
    private static final int UID_LOCATION = 2;
    private static final int GID_LOCATION = 3;
    private static final int HOME_DIRECTORY_LOCATION = 5;
    
    
    public static int getUID(String name){
        try{
            Vector<String[]> pwSplit = readPasswordFile();
            for(int i=0;i<pwSplit.size();i++){
                String[] value = pwSplit.get(i);
                if(name.equals(value[NAME_LOCATION]))
                    return Integer.parseInt(value[UID_LOCATION]);
                
            }
        
        
        }catch (IOException e){
            e.printStackTrace();
        }
        return -1;
    }
    
    public static String getName(int UID){
        
        try{
            Vector<String[]> pwSplit = readPasswordFile();
            for(int i=0;i<pwSplit.size();i++){
                String[] value = pwSplit.get(i);
                if(Integer.parseInt(value[UID_LOCATION])==UID)
                    return value[NAME_LOCATION];
                
            }
        
        
        }catch (IOException e){
            e.printStackTrace();
        }
        return null;
        
    }
    
    
    private static Vector<String[]> readPasswordFile(  ) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader ("/etc/passwd"));
       String l = null;
        
        Vector<String[]> line = new Vector<String[]>();
        while( ( l = reader.readLine() ) != null ) {
            String[] lineSplit = l.split(":");
            line.add(lineSplit);
        }
        reader.close();
        return line;
    }
}
