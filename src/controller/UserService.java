/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.User;
import model.UserDB;

/**
 *
 * @author Lenovo
 */
public class UserService {

    UserDB tableModel = new UserDB();
    UserDB manipulationData = new UserDB();

    public void validateCreationUser(String name, String numberPhone, String discordProfile, String annotations, int rank) {

        User user = new User(name, numberPhone, discordProfile, annotations, rank);
        manipulationData.createUser(user);

    }

    public void viewUser(JTable table, boolean activityMargin) {
        manipulationData.readUser(table, activityMargin);
    }
   

    public void validateUpgradeData(int userID, String name, String numberPhone, String discordProfile, String annotations, int rank) {

        User user = new User(userID, name, numberPhone, discordProfile, annotations, rank);
        manipulationData.updateUser(user);
    }
    
    
    
    
}
