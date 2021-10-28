package task;

import java.io.*;

public class Fw {
    static void writeToFile(String name, String str) {
        try
        {
            FileWriter writer = new FileWriter(name, true);
            writer.write(str+"\n");
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    static void clear(String name){
        try
        {
            FileWriter writer = new FileWriter(name, false);
            writer.write("");
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    static String getPasswd(String fileName, String comp) {
        try(BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            for(String line; (line = br.readLine()) != null; ) {
                String[] parts = line.split(":");
                if(parts[0].equals(comp)){
                    return parts[1];
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
