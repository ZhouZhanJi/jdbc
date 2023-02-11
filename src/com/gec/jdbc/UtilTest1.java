package com.gec.jdbc;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
public class UtilTest1 {
    public static void main(String[] args) throws SQLException {
        test3();
//        ArrayList<User> users = findUsers();
//        users.forEach(li -> System.out.println(li));
    }

    private static void test3() throws SQLException {
        //查询语句
        String sql = "select * from user where id =?;";
        ResultSet rs = JDBCUtil.executeQuery(sql, 2);
        while (rs.next()) {
            System.out.println(rs.getString("id") + "\t" + rs.getString("username") + "\t" + rs.getString("password")+ "\t" + rs.getString("type"));
        }
        //关闭资源
        JDBCUtil.close(rs);
    }

    private static void test1() {
        String sql = "insert into user (name,sex)values(?,?);";
        int i = JDBCUtil.executeUpdate(sql, "老吴", "男");
        if (i > 0) {
            System.out.println("添加成功" + i + "条数据");
        }
    }

    //查询的结果封装到对象中，再将对象封装到集合中

    private static ArrayList<User> findUsers() {

        String sql = "select * from user";
        ResultSet rs = JDBCUtil.executeQuery(sql);

        //定义一个集合用来存放数据
        ArrayList<User> list = new ArrayList<>();

        try {
            while (rs.next()) {
                //将查询到的结果封装到对象中
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String sex = rs.getString("sex");
                User user = new User(id, name, sex);
                //将对象添加到集合中
                list.add(user);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

}
