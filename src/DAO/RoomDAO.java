/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

/**
 *
 * @author Lenovo
 */
import cinema.Database;
import java.sql.*;
import entity.Room;
public class RoomDAO {
    private Connection getConnect() throws ClassNotFoundException, SQLException{
       return Database.getDB().connect();
    }
    public void addRoom(Room room) throws SQLException, ClassNotFoundException{
        String sql="insert into theater values(?,?,?,?,?)";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){
            pst.setString(1,room.getId());
            pst.setString(2,room.getName());
            pst.setInt(3,room.getRowNum());
            pst.setInt(4,room.getSeatPerRow());
            pst.setInt(5,room.getSeatCount());
            pst.executeUpdate();
        }
    }
    public void editRoom(Room room) throws SQLException, ClassNotFoundException{
        String sql="update theater set theater_name=?,row_num=?,seat_per_row=?,seat_total=? where theater_id=?";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){        
            pst.setString(1,room.getName());
            pst.setInt(2,room.getRowNum());
            pst.setInt(3,room.getSeatPerRow());
            pst.setInt(4,room.getSeatCount());
            pst.setString(5,room.getId());
            pst.executeUpdate();
        }
    }
    public void deleteRoom(String id) throws SQLException, ClassNotFoundException{
        String sql="delete from theater where theater_id=?";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){
            pst.setString(1,id);
            pst.executeUpdate();
        }
    }
}
