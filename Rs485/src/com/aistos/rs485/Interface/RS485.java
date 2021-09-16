package com.aistos.rs485.Interface;

public interface RS485 {

	public void init();
	
	public boolean state(int valveNumber);
	
	public boolean start(int valveNumber);
	
	public boolean stop(int valveNumer);
	
}
