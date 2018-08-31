package com.hh.spring4.x.section11_transaction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author HaoHao
 * @Description: JDBC 对事务的支持
 * @date 2018/8/31下午11:02
 */
public class JDBC {

    static void testTransaction() throws SQLException {
        Connection conn = null;

        try {
            // 获取数据库连接
            conn = DriverManager.getConnection("url");
            // 设置事务隔离级别
            conn.setTransactionIsolation(Connection.TRANSACTION_REPEATABLE_READ);

            Statement stmt = conn.createStatement();

            int rows = stmt.executeUpdate("update sql ");

            rows = stmt.executeUpdate("update SQL ");

            // 提交事务
            conn.commit();
        } catch (SQLException e) {
            assert conn != null;
            // 回滚事务
            conn.rollback();
            e.printStackTrace();
        }
    }
}
