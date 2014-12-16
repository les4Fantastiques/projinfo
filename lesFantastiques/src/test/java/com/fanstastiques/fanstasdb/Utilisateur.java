package com.fanstastiques.fanstasdb;

public class Utilisateur {

	private String login = new String();
	private String mdp = new String();
	
	public Utilisateur(String login, String mdp) {
		super();
		this.login = login;
		this.mdp = mdp;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getMdp() {
		return mdp;
	}

	public void setMdp(String mdp) {
		this.mdp = mdp;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
