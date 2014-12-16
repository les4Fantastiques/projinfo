package com.fanstastiques.fanstasdb;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.Statement;

import twitter4j.TwitterException;
import lesFantastiques.lesFantastiques.recevoirtrends;
import lesFantastiques.lesFantastiques.testInternet;

public class madb {
	 Path curpath = Paths.get("");
	 private String DBPath = "Chemin aux base de donnée SQLite";
	 private Connection connection = null;
	 private Statement statement = null;
	 
	 public madb(String dBPath) {
	        DBPath = dBPath;
	    }
	 
	 
	 
	 
	 public static void main(String[] args){
	    	
			recevoirtrends montrend = new recevoirtrends();
			try {
				System.out.println(montrend.prendretrends());
			} catch (TwitterException e) {
				// TODO Auto-generated catch block
				//e.printStackTrace();
				System.out.println("pas connecté à internet");
			}
	    }
	 
}
