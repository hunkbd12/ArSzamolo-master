/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package arszamolo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author NOW-SIDE
 */
public class Adatbazis {
    
    Termek[] termekek = new Termek[100];
    int termekekSzama = 0;
    
    public Adatbazis(){
    
    
    }
    
    public int getTermekekSzama(){
    
    return termekekSzama;
    }
    
    public Termek[] readAllRecords(){
        
        try{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      }catch (Exception e){
        System.err.println("Error: "+e);
    }
        try{       
       Connection con;
       con=DriverManager.getConnection("jdbc:mysql://localhost/ar_szamlalo", "root", "");

       Statement s = con.createStatement();

       String query = "SELECT * FROM termekek";
       ResultSet rs = s.executeQuery(query);
       
       while (rs.next())
       {
          int az = rs.getInt("id");
          String termekNev = rs.getString("termekNev");
          int beszerzesiAr = rs.getInt("beszerzesiAr");
          this.termekek[this.termekekSzama]= new Termek(termekNev,beszerzesiAr);
          this.termekekSzama++;
          
          //int ar = rs.getInt("ar");
          //... adatok feldolgozása...
          
       }
       con.close();
       
    }catch (SQLException e){
       System.err.println("Error: "+e.getMessage());
    }
        
        
    return this.termekek;
    }
    /**
     * Method to write a new line to DB!
     * @param nev
     * @param beszerAr 
     */
    public void writeRow(String nev,int beszerAr){
          try{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      }catch (Exception e){
        System.err.println("Error: "+e);
    }
        try{       
       Connection con;
       con=DriverManager.getConnection("jdbc:mysql://localhost/ar_szamlalo", "root", "");

       Statement statement = con.createStatement();

       String query = "INSERT INTO termekek VALUES("+null+",'"+nev+"',"+beszerAr+")";
       statement.executeUpdate(query);
       
       con.close();
       
    }catch (SQLException e){
       System.err.println("Error: "+e.getMessage());
    }
        
    }
    
    public void deleRow(String nev){
    
        
          try{
      Class.forName("com.mysql.jdbc.Driver").newInstance();
      }catch (Exception e){
        System.err.println("Error: "+e);
    }
        try{       
       Connection con;
       con=DriverManager.getConnection("jdbc:mysql://localhost/ar_szamlalo", "root", "");

       Statement statement = con.createStatement();

       String query = "DELETE FROM termekek WHERE termekNev='"+nev+"'";
       statement.executeUpdate(query);
       
       con.close();
       
    }catch (SQLException e){
       System.err.println("Error: "+e.getMessage());
    }
        
    
    }
    
}
