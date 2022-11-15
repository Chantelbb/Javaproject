package com.example.don_bosco;


import java.sql.Connection;
import java.sql.DriverManager;




//import static java.lang.Class.forName;

    public class databaseController {

        public static void main(String[] args) {

            getconnection();

        }

        public static Connection getconnection() {
            try{
                String driver = "com.mysql.cj.jdbc.Driver";
                String databaseurl = "jdbc:mysql://localhost:3306/db_wall";
                String username = "root";
                String password = "Patanjali@34";
                Class.forName(driver);
                Connection conn = DriverManager.getConnection(databaseurl,username,password);
                System.out.println("database connected");
                return conn;
            }
            catch(Exception e){
                System.out.println(e);
            }

            return null;
        }
    }

