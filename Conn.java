
package QuizApplication;

import java.sql.*;


public class Conn {
    
    Connection c;
    Statement s;
    Conn(){
        try{
       c=  DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/quiz","root","Kri$na1111481");
       s=c.createStatement();
    }catch(Exception e){
        e.printStackTrace();
    }
    }
}
    

