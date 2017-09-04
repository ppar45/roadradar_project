/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author jeffrey
 */
public class Data {
    private static String JDBC_CONNECTION_URL = 
			"jdbc:derby://localhost:1527/RoadData";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        try {

                CSVLoader loader = new CSVLoader(getCon());

                loader.loadCSV("D:\\Road_Segment.csv","ROAD_SEGMENT",true);

        } catch (Exception e) {
                e.printStackTrace();
        }
    }
    
    private static Connection getCon() {
        Connection connection = null;
        try {
                Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
                connection = DriverManager.getConnection(JDBC_CONNECTION_URL,"Jeffrey","Lsj19920615");

        } catch (ClassNotFoundException e) {
                e.printStackTrace();
        } catch (SQLException e) {
                e.printStackTrace();
        }

        return connection;
	}
    
}
