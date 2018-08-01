package com.how2java.tmall.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class TestTmall {
    public static void main(String args[]) {
        //分类测试数据
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/tmall_ssm?useUnicode=true&characterEncoding=utf-8",
                "root", "admin");
             Statement s = connection.createStatement()) {
            for (int i = 0; i < 10; i++) {
                String sqlFormat = "insert into category values(null,'分类%d')";
                String sql = String.format(sqlFormat, i);
                s.execute(sql);
                System.out.println("成功创建分类" + i);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
