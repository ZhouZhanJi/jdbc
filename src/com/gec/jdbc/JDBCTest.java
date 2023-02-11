package com.gec.jdbc;

import org.junit.Test;

import java.sql.*;

import static java.sql.DriverManager.*;

public class JDBCTest {
    public static void main(String[] args) {

    }

    @Test
    public void test1() throws Exception {
        String url = "jdbc:mysql://localhost:3306/clerk";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection ct =DriverManager.getConnection(url,username,password);
        Statement st = ct.createStatement();
        String sql = "create table jdbctest(id int primary key auto_increment,name varchar(20))";
        int i = st.executeUpdate(sql);
        System.out.println(i);
        st.close();
        ct.close();
    }

    @Test
    public void test2() throws Exception {
        String url = "jdbc:mysql://localhost:3306/clerk?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection ct =DriverManager.getConnection(url,username,password);
        Statement st = ct.createStatement();
        String sql = "insert into jdbctest(name) values('哦哦')";
        int i = st.executeUpdate(sql);
        System.out.println(i);
        st.close();
        ct.close();
    }
    @Test
    public void test3() throws Exception {
        String url = "jdbc:mysql://localhost:3306/clerk?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";
        Class.forName("com.mysql.jdbc.Driver");
        Connection ct =DriverManager.getConnection(url,username,password);
        Statement st = ct.createStatement();
        String sql = "select * from jdbctest";
        ResultSet rs = st.executeQuery(sql);
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id+"\t"+name);
        }
        st.close();
        ct.close();

    }


    @Test
    public void test4() throws Exception {
        String url = "jdbc:mysql://localhost:3306/clerk?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";
//        1.加载驱动：通过反射加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
//        2.获得连接
        Connection ct =DriverManager.getConnection(url,username,password);
//        3.获得sql发送对象
        String sql = "select * from jdbctest";
        PreparedStatement ps = ct.prepareStatement(sql);
//        4.发送sql语句
        ResultSet rs = ps.executeQuery();
//        5.返回结果
        while(rs.next()){
            int id = rs.getInt("id");
            String name = rs.getString("name");
            System.out.println(id+"\t"+name);
        }
        ps.close();
        ct.close();

    }


    @Test
    public void test5() throws Exception {
        String url = "jdbc:mysql://localhost:3306/clerk?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";
//        1.加载驱动：通过反射加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
//        2.获得连接
        Connection ct =DriverManager.getConnection(url,username,password);
//        3.获得sql发送对象
        String sql = "insert into jdbctest(id,name)values(?,?)";
        PreparedStatement ps = ct.prepareStatement(sql);
        String name = "王五";
        ps.setString(1,"20");
        ps.setString(2,name);
//        4.发送sql语句
        int i=ps.executeUpdate();
//        5.返回结果
        System.out.println(i);
        ps.close();
        ct.close();

    }


    @Test
    public void test6() throws Exception {
        String url = "jdbc:mysql://localhost:3306/clerk?useUnicode=true&characterEncoding=utf8";
        String username = "root";
        String password = "root";
//        1.加载驱动：通过反射加载驱动类
        Class.forName("com.mysql.jdbc.Driver");
//        2.获得连接
        Connection ct =DriverManager.getConnection(url,username,password);
//        3.获得sql发送对象
        String sql = "insert into jdbctest(id,name)values(21,'haha')";
        PreparedStatement ps = ct.prepareStatement(sql);
//        4.发送sql语句
        int i=ps.executeUpdate();
//        5.返回结果
        System.out.println(i);
        ps.close();
        ct.close();

    }
}