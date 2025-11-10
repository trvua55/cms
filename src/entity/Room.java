/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package entity;

/**
 *
 * @author Lenovo
 */
public class Room {
    private String id;
    private String name;
    private int rowNum;
    private int seatPerRow;
    private int seatCount;
    public Room(){}
    public Room(String id,String name,int rowNum,int seatPerRow){
       this.id=id;
       this.name=name;
       this.rowNum=rowNum;
       this.seatPerRow=seatPerRow;
       this.seatCount=rowNum * seatPerRow;
    }
    public String getId(){return id;}
    public void setId(String id){this.id=id;}
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public int getRowNum(){return rowNum;}
    public void setRowNum(int rowNum){
        this.rowNum=rowNum;
        this.seatCount=rowNum * seatPerRow;
    }
    public int getSeatPerRow(){return seatPerRow;}
    public void setSeatPerRow(int seatPerRow){
        this.seatPerRow=seatPerRow;
        this.seatCount=rowNum * seatPerRow;
    }
    public int getSeatCount(){return seatCount;}
}
