package com.fanstastiques.fanstasdb;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class madb {
	 Path curpath = Paths.get("");
	 private String DBPath = "4fantas.db";
	 private Connection connection = null;
	 private Statement statement = null;
	 
	 public madb(String dBPath) {
	        DBPath = dBPath;
	    }
	 
	 public void connect() {
	        try {
	            Class.forName("org.sqlite.JDBC");
	            connection = DriverManager.getConnection("jdbc:sqlite:" + DBPath);
	            statement = connection.createStatement();
	            System.out.println("Connexion a " + DBPath + " avec succès");
	            this.ajouttable();
	        } catch (ClassNotFoundException notFoundException) {
	            notFoundException.printStackTrace();
	            System.out.println("Erreur de connexion");
	        } catch (SQLException sqlException) {
	            sqlException.printStackTrace();
	            System.out.println("Erreur de connexion");
	        }
	        
	    }
	 public void ajouttable(){
		 try {
			statement= connection.createStatement();
			String sql = "CREATE TABLE Utilisateur " +
	                   "(LOGIN 		   CHAR(50) PRIMARY KEY     NOT NULL," +
	                   " MDP           CHAR(50)    NOT NULL)";
			statement.executeUpdate(sql);
			statement.close();
			System.out.println("Table created successfully");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	 }
	 public void close() {
	        try {
	            connection.close();
	            statement.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 
	 public ResultSet query(String requet) {
	       ResultSet resultat = null;
	       try {
	           resultat = statement.executeQuery(requet);
	       } catch (SQLException e) {
	           e.printStackTrace();
	           System.out.println("Erreur dans la requet : " + requet);
	       }
	       return resultat;
	 
	   }
	 
	 public void adduser(Utilisateur user){
		 
		 String query= "INSERT INTO Utilisateur(lOGIN,MDP)"+
				 		" VALUES(" + "'" + user.getLogin()+ "','" + user.getMdp() +"');";
		 try {
	            statement.executeUpdate(query);
	        } catch (SQLException e) {
	            // TODO Auto-generated catch block
	            //e.printStackTrace();
	        }
		 
	 }
	 
	 public ResultSet afficheruser(){
		 String query ="SELECT * FROM Utilisateur";
		 ResultSet resultSet = this.query(query);
		  
		 return resultSet;
	 }
	 
	 public static void main(String[] args){
	    	
		        madb connexion = new madb("4fantas.db");
		        connexion.connect();
		        Utilisateur user = new Utilisateur("gros robert2","toto2");
		        connexion.adduser(user);	        
		        ResultSet resultSet=connexion.afficheruser();
		        try {
		            while (resultSet.next()) {
		                System.out.println("user : "+resultSet.getString("LOGIN"));
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        } 
		        connexion.close();
	    }
	 
}
