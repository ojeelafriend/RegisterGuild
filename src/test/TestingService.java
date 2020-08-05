package test;

import com.sun.xml.internal.ws.api.model.ExceptionType;
import controller.Config_db;
import java.sql.Connection;
import javax.swing.JOptionPane;
import model.User;
import model.UserDB;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Lenovo
 */
public class TestingService {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
            
            User user = new User("Cruzo","261728392","Araceli#2034","Esto es un mensaje de prueba del update",2);
            user.setIdUser(1);
            UserDB userDB = new UserDB();
            userDB.updateUser(user);

    }

}
