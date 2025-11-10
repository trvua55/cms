package DAO;

import cinema.Database;
import entity.Showtime;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ShowtimeDAO {
    private Connection getConnect() throws ClassNotFoundException, SQLException {
        return Database.getDB().connect();
    }

    // Thêm suất chiếu mới
    public void addShowtime(Showtime showtime) throws SQLException, ClassNotFoundException {
        String sql = "INSERT INTO Showtime (Show_ID, Mov_ID, Theater_ID, Show_date, Start_time, End_time, Show_price) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement pst = getConnect().prepareStatement(sql)) {
            pst.setString(1, showtime.getShow_ID());
            pst.setString(2, showtime.getMov_ID());
            pst.setString(3, showtime.getTheater_ID());
            pst.setTimestamp(4, Timestamp.valueOf(showtime.getShow_date()));
            pst.setTimestamp(5, Timestamp.valueOf(showtime.getStart_time()));
            pst.setTimestamp(6, Timestamp.valueOf(showtime.getEnd_time()));
            pst.setBigDecimal(7, showtime.getShow_price());
            pst.executeUpdate();
        }
    }

    // Sửa suất chiếu
    public void editShowtime(Showtime showtime) throws SQLException, ClassNotFoundException {
        String sql = "UPDATE Showtime SET Mov_ID=?, Theater_ID=?, Show_date=?, Start_time=?, End_time=?, Show_price=? WHERE Show_ID=?";
        try (PreparedStatement pst = getConnect().prepareStatement(sql)) {
            pst.setString(1, showtime.getMov_ID());
            pst.setString(2, showtime.getTheater_ID());
            pst.setTimestamp(3, Timestamp.valueOf(showtime.getShow_date()));
            pst.setTimestamp(4, Timestamp.valueOf(showtime.getStart_time()));
            pst.setTimestamp(5, Timestamp.valueOf(showtime.getEnd_time()));
            pst.setBigDecimal(6, showtime.getShow_price());
            pst.setString(7, showtime.getShow_ID());
            pst.executeUpdate();
        }
    }

    // Xóa suất chiếu
    public void deleteShowtime(String showId) throws SQLException, ClassNotFoundException {
        String sql = "DELETE FROM Showtime WHERE Show_ID=?";
        try (PreparedStatement pst = getConnect().prepareStatement(sql)) {
            pst.setString(1, showId);
            pst.executeUpdate();
        }
    }

    // Lấy tất cả suất chiếu
    public List<Showtime> getAllShowtimes() throws SQLException, ClassNotFoundException {
        List<Showtime> showtimes = new ArrayList<>();
        String sql = "SELECT * FROM Showtime";
        try (PreparedStatement pst = getConnect().prepareStatement(sql);
             ResultSet rs = pst.executeQuery()) {
            while (rs.next()) {
                Showtime showtime = new Showtime();
                showtime.setShow_ID(rs.getString("Show_ID"));
                showtime.setMov_ID(rs.getString("Mov_ID"));
                showtime.setTheater_ID(rs.getString("Theater_ID"));
                showtime.setShow_date(rs.getTimestamp("Show_date").toLocalDateTime());
                showtime.setStart_time(rs.getTimestamp("Start_time").toLocalDateTime());
                showtime.setEnd_time(rs.getTimestamp("End_time").toLocalDateTime());
                showtime.setShow_price(rs.getBigDecimal("Show_price"));
                showtimes.add(showtime);
            }
        }
        return showtimes;
    }

    // Tìm suất chiếu theo ID
    public Showtime getShowtimeById(String showId) throws SQLException, ClassNotFoundException {
        String sql = "SELECT * FROM Showtime WHERE Show_ID=?";
        try (PreparedStatement pst = getConnect().prepareStatement(sql)) {
            pst.setString(1, showId);
            ResultSet rs = pst.executeQuery();
            if (rs.next()) {
                Showtime showtime = new Showtime();
                showtime.setShow_ID(rs.getString("Show_ID"));
                showtime.setMov_ID(rs.getString("Mov_ID"));
                showtime.setTheater_ID(rs.getString("Theater_ID"));
                showtime.setShow_date(rs.getTimestamp("Show_date").toLocalDateTime());
                showtime.setStart_time(rs.getTimestamp("Start_time").toLocalDateTime());
                showtime.setEnd_time(rs.getTimestamp("End_time").toLocalDateTime());
                showtime.setShow_price(rs.getBigDecimal("Show_price"));
                return showtime;
            }
        }
        return null;
    }
}