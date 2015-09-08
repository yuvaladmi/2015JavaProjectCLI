package model;

import controller.Controller;

public abstract class CommonModel implements Model {
    public Controller c;
    public CommonModel(Controller c) {
	this.c=c;
    }
}
