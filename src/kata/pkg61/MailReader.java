package kata.pkg61;

import java.beans.Statement;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class MailReader {
    
    public static ArrayList <Person> read() throws ClassNotFoundException, SQLException{
        ArrayList <Person> people = new ArrayList<>();
        Class.forName("org.sqlite.JDBC");
        Connection cn = DriverManager.getConnection("jdbc:sqlite:KATA.sDB");
        java.sql.Statement st = cn.createStatement();
        ResultSet rs = st.executeQuery("SELECT * from People");
        ArrayList<String> mailList = new ArrayList<>();
        while(rs.next()){
            int id = rs.getInt("id");
            String name= rs.getString("name");
            String genero= rs.getString("genero");
            float peso = rs.getFloat("peso");
            String mail = rs.getString("mail");
            people.add(new Person(id,name,mail,peso,genero));
        }
        
        rs.close();
        st.close();
        cn.close();
        return people;      
    }
}
