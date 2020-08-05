/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import controller.Config_db;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Lenovo
 */
public class UserDB {

    private String sqlQuery;
    private PreparedStatement preparedStatement = null;
    private ResultSet resultSet = null;
    Config_db config_db = new Config_db();
    private static DefaultTableModel defaultTableModel;
    
    
    

    public void createUser(User user) {

        try (Connection connection = config_db.get_connection()) {

            sqlQuery = "INSERT INTO user (username,rank,wsp,discord,annot,active) VALUES (?,?,?,?,?,?)";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setInt(2, user.getRankGuild());
            preparedStatement.setString(3, user.getNumberPhone());
            preparedStatement.setString(4, user.getDiscordProfile());
            preparedStatement.setString(5, user.getAnnotations());
            preparedStatement.setBoolean(6, user.isMemberActivity());
            preparedStatement.executeUpdate();

            System.out.println("Send succesfully to the register user");

            connection.close();
        } catch (SQLException ERROR_METHOD) {
            System.out.println("Error in the class UserDB, check please. --- CREATE " + ERROR_METHOD);
        }

    }

    public void readUser(JTable table, boolean activityMargin) {

        defaultTableModel = (DefaultTableModel) table.getModel();
        defaultTableModel.setRowCount(0);
        
        
        sqlQuery = "SELECT * FROM user WHERE active = ? ";

        try (Connection connection = config_db.get_connection()) {
            preparedStatement = connection.prepareStatement(sqlQuery);
            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                Vector vector = new Vector();
                vector.add(resultSet.getString(1));
                vector.add(resultSet.getString(2));
                vector.add(resultSet.getString(3));
                vector.add(resultSet.getString(4));
                vector.add(resultSet.getString(5));
                vector.add(resultSet.getString(6));

                defaultTableModel.addRow(vector);
                table.setModel(defaultTableModel);

                System.out.println("Send succesfully to the JTable");
            }
        } catch (SQLException ERROR_METHOD) {
            System.out.println("Error in the class UserDB, check please. READ - active --- " + ERROR_METHOD);
        }
        
    

    
    }
    
    public void updateUser(User user) {

        try (Connection connection = config_db.get_connection()) {
            sqlQuery = "UPDATE user SET username= ?, rank = ?, wsp = ?, discord = ?, annot = ? WHERE id_user = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setInt(2, user.getRankGuild());
            preparedStatement.setString(3, user.getNumberPhone());
            preparedStatement.setString(4, user.getDiscordProfile());
            preparedStatement.setString(5, user.getAnnotations());
            preparedStatement.setInt(6, user.getIdUser());
            preparedStatement.executeUpdate();

            System.out.println("Update to information the user is succesfully");

            connection.close();

        } catch (SQLException ERROR_METHOD) {
            System.out.println("Error in the class UserDB, check please. --- UPDATE " + ERROR_METHOD);
        }

    }

    public String deleteUser(String username) {
        try (Connection connection = config_db.get_connection()) {
            sqlQuery = "UPDATE user SET  active = ? WHERE user = ?";
            preparedStatement = connection.prepareStatement(sqlQuery);
            preparedStatement.setBoolean(1, false);
            preparedStatement.setString(2, username);
            preparedStatement.executeUpdate();

            System.out.println("Unsubscribed user succesfully");
            connection.close();
        } catch (SQLException ERROR_METHOD) {
            System.out.println("Error in the class UserDB, check please. --- DELETE " + ERROR_METHOD);
        }
        return username;
    }

    
    
    
    
  //GETTERS AND SETTERS  
    
    public static DefaultTableModel getDefaultTableModel() {
        return defaultTableModel;
    }

    public static void setDefaultTableModel(DefaultTableModel defaultTableModel) {
        UserDB.defaultTableModel = defaultTableModel;
    }

    
    
    
    
}
