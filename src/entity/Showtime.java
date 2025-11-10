package entity;
import java.math.BigDecimal;
import java.time.LocalDateTime;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


/**
 *
 * @author Win10
 */
public class Showtime {
    private String Show_ID;
    private String Mov_ID;
    private String Theater_ID;
    private LocalDateTime Show_date;
    private LocalDateTime Start_time;
    private LocalDateTime End_time;
    private BigDecimal Show_price;
        public Showtime(){}
        public Showtime (String id, String name, String room, LocalDateTime date, LocalDateTime start_time, LocalDateTime end_time, BigDecimal show_price ){
            this.Show_ID = Show_ID;
            this.Mov_ID = Mov_ID;
            this.Theater_ID = Theater_ID;
            this.Show_date= Show_date;
            this.Start_time = Start_time;
            this.End_time = End_time;
            this.Show_price = Show_price;
        }
    public String getShow_ID() {
        return Show_ID;
    }
    
     public void setShow_ID(String Show_ID) {
        this.Show_ID = Show_ID;
    }

    public String getMov_ID() {
        return Mov_ID;
    }

    public void setMov_ID(String Mov_ID) {
        this.Mov_ID = Mov_ID;
    }

    public String getTheater_ID() {
        return Theater_ID;
    }

    public void setTheater_ID(String Theater_ID) {
        this.Theater_ID = Theater_ID;
    }

    public LocalDateTime getShow_date() {
        return Show_date;
    }

    public void setShow_date(LocalDateTime Show_date) {
        this.Show_date = Show_date;
    }

    public LocalDateTime getStart_time() {
        return Start_time;
    }

    public void setStart_time(LocalDateTime Start_time) {
        this.Start_time = Start_time;
    }

    public LocalDateTime getEnd_time() {
        return End_time;
    }

    public void setEnd_time(LocalDateTime End_time) {
        this.End_time = End_time;
    }

    public BigDecimal getShow_price() {
        return Show_price;
    }

    public void setShow_price(BigDecimal Show_price) {
        this.Show_price = Show_price;
    }
}
