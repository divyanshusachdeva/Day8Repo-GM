package com.graymatter;

public class Sender<T> {

	T msg;
	
	public void setMessage(T msg) {
		this.msg = msg;
	}
	
	public void sendMessage() {
		System.out.println("From class Sender mesage to receiver.");
	}
	
	public static void main(String[] args) {

		Sender<String> strSender = new Sender<String>();
		strSender.setMessage("Hello!");
		strSender.sendMessage();
		
	}

}
