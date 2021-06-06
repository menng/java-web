package demo.web;

import com.mysql.cj.jdbc.Driver;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

import java.io.File;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Properties;

public class JdbcDemo {

    public static void main(String[] args) throws Exception {
        // 注册驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        // 尝试手动注册
//        DriverManager.registerDriver(new Driver());

//        PrintWriter printWriter = new PrintWriter(new File("log.txt"));
//        DriverManager.setLogWriter(printWriter);

        // 建立连接
//        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc?useUnicode=true&characterEncoding=utf8", "root", "root");
        Properties info = new Properties();
        info.setProperty("user", "root");
        info.setProperty("password", "root");
        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost.charlesproxy.com:3306/jdbc?useUnicode=true&characterEncoding=utf8", info);


//        String id = "1 or 1=1";
//        String sql = "delete from user where id=" + id;
//        Statement statement = connection.createStatement();
//        statement.executeUpdate(sql);
        //PreparedStatement 有效的防止sql注入(SQL语句在程序运行前已经进行了预编译,当运行时动态地把参数传给PreprareStatement时，即使参数里有敏感字符如 or '1=1'也数据库会作为一个参数一个字段的属性值来处理而不会作为一个SQL指令)
        String sql = "select * from user";
        PreparedStatement ps = connection.prepareStatement(sql);
        ResultSet resultSet = ps.executeQuery();
        while (resultSet.next()) {
            System.out.println(resultSet.getString("name"));
        }


        System.out.println(connection);

        // 释放连接
        resultSet.close();
        connection.close();
    }
}
