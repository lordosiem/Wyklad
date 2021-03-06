/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


package dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import model.Car;
import model.Rent;
import util.DbUtil;

/**
 *
 * @author Adrian
 */
//asdasdas
public class RentDao {

       private Connection connection;

    public RentDao() {
        connection = DbUtil.getConnection();
    }
    
    
            public void addRent(Rent rent) {   
            //Integer id=getLastId();
        try {
 
            PreparedStatement preparedStatement = connection
                    .prepareStatement("insert into wypozyczenie(id_wypozyczenie,id,userid,data_wypozyczenia,data_zwrotu,status) values (?, ?, ?, ?, ?, ?)");
            
            preparedStatement.setInt(1,rent.getIdWypozyczenie());
            preparedStatement.setInt(2, rent.getIdSamochod());
            preparedStatement.setInt(3, rent.getIdUser());
            preparedStatement.setDate(4, new java.sql.Date(rent.getDataWypozyczenia().getTime()));
            preparedStatement.setDate(5, new java.sql.Date(rent.getDataZwrotu().getTime()));
            preparedStatement.setString(6, rent.getStatus());
           
            
            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
            
                public void acceptRent(Rent rent) {

        try {

            PreparedStatement preparedStatement = connection
                    .prepareStatement("update wypozyczenie set status=?"
                            + "where id_wypozyczenie=?");

                // Parameters start with 1  
            preparedStatement.setString(1, rent.getStatus());

            preparedStatement.setInt(2, rent.getIdWypozyczenie());
/*
            preparedStatement.setDate(3, new java.sql.Date(rent.getDataWypozyczenia().getTime()));

            preparedStatement.setDate(4, new java.sql.Date(rent.getDataZwrotu().getTime()));

            preparedStatement.setString(5, rent.getStatus());

            preparedStatement.setInt(6, rent.getIdWypozyczenie());
  */          
            preparedStatement.executeUpdate();

        } catch (SQLException e) {

            e.printStackTrace();

        }

    }
            
            
}