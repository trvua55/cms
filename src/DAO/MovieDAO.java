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
import entity.Movie;
import java.sql.*;
public class MovieDAO {
    private Connection getConnect() throws ClassNotFoundException, SQLException{
       return Database.getDB().connect();
    }

    /**
     *
     * @param movie
     * @throws SQLException
     * @throws ClassNotFoundException
     */
    public void addMovie(Movie movie) throws SQLException, ClassNotFoundException{
        String sql="insert into movie values(?,?,?,?,?,?)";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){
            pst.setString(1,movie.getId());
            pst.setString(2,movie.getTitle());
            pst.setString(3,movie.getGenre());
            pst.setString(4,movie.getDirector());
            pst.setInt(5,movie.getDuration());
            pst.setBoolean(6,movie.isShowing());
            pst.executeUpdate();
        }
    }
    public void editMovie(Movie movie) throws SQLException, ClassNotFoundException{
        String sql="update movie set mov_title=?,mov_genre=?,mov_director=?,mov_duration=?,mov_is_showing=? where mov_id=?";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){
            pst.setString(1,movie.getTitle());
            pst.setString(2,movie.getGenre());
            pst.setString(3,movie.getDirector());
            pst.setInt(4,movie.getDuration());
            pst.setBoolean(5,movie.isShowing());
            pst.setString(6,movie.getId());
            pst.executeUpdate();
        }
    }
    public void deleteMovie(String id) throws SQLException, ClassNotFoundException{
        String sql="delete from movie where mov_id=?";
        try(PreparedStatement pst=getConnect().prepareStatement(sql)){
            pst.setString(1,id);
            pst.executeUpdate();
        }
    }
}
