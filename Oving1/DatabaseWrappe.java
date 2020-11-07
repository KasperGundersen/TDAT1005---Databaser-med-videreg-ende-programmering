/**
 * Øving 1 - TDAT1005 Databaser med videregående programmering(2019 vår)
 * Ø1: JDBC (workshop)
 * 
 */

import java.util.Scanner;
import java.sql.*;

 class DatabaseWrappe{ //DatabaseWrapper
    public static void main(String[] args){
        try{
            System.out.println("Skriv inn passord:");
            Scanner sc = new Scanner(System.in);
            //String password = sc.nextLine();

            String url = "database+username+password";
            Connection con = DriverManager.getConnection(url);

            Statement stmt = con.createStatement();
            ResultSet res = stmt.executeQuery("SELECT * FROM person ORDER BY fornavn");

            while(res.next()){
                System.out.println("Fornavn: " + res.getString("fornavn"));
            }

            con.close();
        }
        catch(Exception e){
            System.out.println("buuu");
            e.printStackTrace();
        }
    }
}
