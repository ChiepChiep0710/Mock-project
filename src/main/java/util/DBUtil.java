package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class DBUtil {
    private static DBUtil instance;

    public static DBUtil getInstance() {
        return instance = instance != null ? instance : new DBUtil();
    }

    public Connection getConnection() {
        try {
            String url =  "jdbc:sqlserver://sql.bsite.net\\MSSQL2016;"
                    + "database=hieunm69_;"
                    + "user=hieunm69_;"
                    + "password=Qwertyuiop[;"
                    + "encrypt=true;"
                    + "trustServerCertificate=true;"
                    + "loginTimeout=30;";;

            return DriverManager.getConnection(url);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public PreparedStatement statementBindind(PreparedStatement preparedStatement, Object ... args) {
        try{
            for (int i = 0; i < args.length; i++) {
                if (args[i] instanceof String){
                    preparedStatement.setString(i+1,(String) args[i]);
                } else if (args[i] instanceof Integer) {
                    preparedStatement.setInt(i+1,(Integer) args[i]);
                }else if (args[i] instanceof Double) {
                    preparedStatement.setDouble(i+1,(double) args[i]);
                }else{
                    System.out.println("MISSING TYPE: " + args[i].getClass());
                }
            }
        }catch (Exception e){
            e.printStackTrace();

            return null;
        }
        return preparedStatement;
    }
}
