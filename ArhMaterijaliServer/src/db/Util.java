/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package db;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author SOLUNAC
 */
public class Util {
    
    private Properties props;
    private static Util instance;

    public Util() throws IOException{
        props = new Properties();
        props.load(new FileInputStream("db.properties"));
    }
    

    public static Util getInstance() throws IOException{
        if(instance == null){
            instance = new Util();
        }
        return instance;
    }
    
    public String get(String key) {
        return props.getProperty(key, "");
    }
      
}
