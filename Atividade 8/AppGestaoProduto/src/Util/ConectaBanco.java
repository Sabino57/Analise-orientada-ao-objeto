package Util;
public class ConectaBanco {
    public static java.sql.Connection obtemConexao(){
        java.sql.Connection con = null;
        try{
            Class.forName("com.mysql.jbdc.Driver");
            con = DriverManager.getConnection("jbdc.mysql://localhost:3306/dbloja", "root", "");
        } catch (ClassNotFoundException | SQLException err1) {
            throw new RuntimeException(err1);
        }
        return con;
        
    }
}
