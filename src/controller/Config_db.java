/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Niusclass
 */
public class Config_db {
    
     //Atributte.
    private final static String db_name = "zen";
    private final static String db_user = "root";
    private final static String db_pw = "";
    private String db_query = "";

    public Connection get_connection() {

        Connection cn = null;

        try {
            cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db_name, db_user, db_pw);
            if (cn != null) {
                System.out.println("You have successfully connected");
            } else {
                System.out.println("Failed to connect, check database configuration.");
            }
        } catch (SQLException e) {
            System.out.println(e);
        }

        return cn;

    }

    public void addQuery(){}
    
}

    

