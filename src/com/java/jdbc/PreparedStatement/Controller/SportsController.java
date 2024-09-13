package com.java.jdbc.PreparedStatement.Controller;

import com.java.jdbc.PreparedStatement.Connection.GameConnection;
import com.java.jdbc.PreparedStatement.Entity.Sports;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SportsController {
    public static void main(String[] args) {
        Connection c= GameConnection.getConnection();
        char ch;
        do {
            Scanner sc=new Scanner(System.in);
            System.out.println("1.INSERT\n2.DELETE\n3.UPDATE\n4.DISPLAYBYPOSITION\n5.DISPLAYALL");
            int choice=sc.nextInt();
            switch (choice){
                case 1: {
                    System.out.println("Enter the Position of the Team:");
                    int position=sc.nextInt();
                    System.out.println("Enter the Name of the Team:");
                    String name=sc.next();
                    System.out.println("Enter the Stadium Name of the Team:");
                    String stadium =sc.next();
                    System.out.println("Enter the Points won by the Team:");
                    int points=sc.nextInt();
                    System.out.println("Enter the Captain Name of the Team:");
                    String captain =sc.next();
                    Sports s=new Sports(position,name,stadium,points,captain);
                    String insertQuery="insert into sports (position,name,stadium,points,captain) values (?,?,?,?,?)";

                    try {
                        PreparedStatement ps=c.prepareStatement(insertQuery);
                        ps.setInt(1,s.getPosition());
                        ps.setString(2,s.getName());
                        ps.setString(3,s.getStadium());
                        ps.setInt(4,s.getPoints());
                        ps.setString(5,s.getCaptain());

                        ps.execute();
                        System.out.println("Data Inserted");
                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Data not Inserted");
                    }
                }
                break;

                case 2: {
                    System.out.println("Enter the name of the team to delete");
                    String name=sc.next();
                    String deleteQuery="delete from sports where name=?";

                    try {
                        PreparedStatement ps=c.prepareStatement(deleteQuery);
                        ps.setString(1,name);
                        int a=ps.executeUpdate();

                        if (a!=0)
                            System.out.println("Data Deleted");
                        else
                            System.out.println("Something went wrong!!! Try again..");

                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Couldn't delete...");
                    }
                }
                break;

                case 3: {
                    System.out.println("Enter the name of team to change the captain:");
                    String name=sc.next();
                    System.out.println("Enter the new name of captain:");
                    String captain=sc.next();

                    String updateQuery="update sports set captain=? where name=?";
                    try {
                        PreparedStatement ps=c.prepareStatement(updateQuery);
                        ps.setString(1,captain);
                        ps.setString(2,name);

                        int a=ps.executeUpdate();
                        if (a!=0)
                            System.out.println("Captain Changed");
                        else
                            System.out.println("Something went wrong!!! Try again..");

                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Update unsuccessful");
                    }
                }
                break;
                case 4: {
                    System.out.println("Position of team by position");
                    System.out.println("Enter the number of team's position:");
                    int position=sc.nextInt();
                    String displayQuery="select * from sports where position=?";
                    try {
                        PreparedStatement ps=c.prepareStatement(displayQuery);
                        ps.setInt(1,position);

                        ResultSet rs =ps.executeQuery();
                        if (rs.next()){
                            int pos=rs.getInt("position");
                            String name=rs.getString("name");
                            String stadium=rs.getString("stadium");
                            int points=rs.getInt("points");
                            String captain=rs.getString("captain");
                            Sports s=new Sports(pos,name,stadium,points,captain);
                            System.out.println(s);
                        }
                        else
                            System.out.println("Given position not Exist...");



                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Unsuccessful operation");
                    }
                }
                break;

                case 5: {
                    System.out.println("Sports Details");
                    String displayAllQuery="select * from sports";
                    try {
                        PreparedStatement ps=c.prepareStatement(displayAllQuery);
                        ResultSet rs=ps.executeQuery();
                        while (rs.next()){
                            int position=rs.getInt("position");
                            String name=rs.getString("name");
                            String stadium =rs.getString("stadium");
                            int points=rs.getInt("points");
                            String captain=rs.getString("captain");
                            Sports s=new Sports(position,name,stadium,points,captain);
                            System.out.println(s);
                            System.out.println("===========================");

                        }

                    } catch (SQLException e) {
                        e.printStackTrace();
                        System.out.println("Unsucessful operation");
                    }
                }
                break;

                default:
                    System.out.println("Invalid Input!!!! Try again");
            }
            System.out.println("Press Y/y to try again");
            ch=sc.next().charAt(0);
        }while (ch=='Y'||ch=='y');

    }
}
