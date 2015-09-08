package view;

import java.util.HashMap;

import controller.Command;

public interface View {

   
    public void setHashMap(HashMap<String, Command> hm);
    
    public void start();
}
