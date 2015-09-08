package controller;

import java.util.HashMap;

import model.Model;
import view.View;

public abstract class CommonController implements Controller {
    protected Model m;
    protected View v;
    public HashMap<String, Command> hm;

    public CommonController() {
	hm = new HashMap<String, Command>();
	
    }

    public void setModel(Model m) {
	this.m = m;
    }

    public void setView(View v) {
	this.v = v;
	v.setHashMap(hm);
    }
    
    protected abstract void createHashMap();

}
