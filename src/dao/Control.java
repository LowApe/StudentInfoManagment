package dao;

import com.mysql.jdbc.PreparedStatement;
import dao.DO.ParmCon;
import dao.DO.StudentTable;
import util.ConnectJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * control 类 中有很多内部类实现控制
 */
public class Control {
    private List<StudentTable> list = new ArrayList<>();
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;


    public Control() {

    }


    private class DealResultSet {
        public List<StudentTable> ResultSet(ResultSet resultSet,String sql) {
            try {
                statement = (PreparedStatement) connection.prepareStatement(sql);
                resultSet = statement.executeQuery();

                while (resultSet.next()) {
                    StudentTable studentTable = new StudentTable();
                    studentTable.setXuehao(resultSet.getString(ParmCon.StudentParm.XUEHAO));
                    studentTable.setXingming(resultSet.getString(ParmCon.StudentParm.XINGMING));
                    studentTable.setZhuanyeming(resultSet.getString(ParmCon.StudentParm.ZHUANYEMING));
                    studentTable.setXingbie(resultSet.getInt(ParmCon.StudentParm.XINGBIE));
                    studentTable.setChushengshijian(resultSet.getDate(ParmCon.StudentParm.CHUSHENGSHIJIAN));
                    studentTable.setZhongxuefen(resultSet.getInt(ParmCon.StudentParm.ZONGXUEFEN));
                    studentTable.setZhaopian(resultSet.getBytes(ParmCon.StudentParm.ZHAOPIAN));
                    studentTable.setAge(resultSet.getInt(ParmCon.StudentParm.AGE));
                    list.add(studentTable);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {

            }
            return list;
        }
    }

    private class Update {
        // todo:需要传入list进行,还有这个实体类,这个实体类拥有插入的数据
        public void update(String sql, Object... obj) {

            connection = ConnectJDBC.getConnection();

            int result = -1;
            try {
                PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
                for (int i = 0; i < obj.length; i++) {
                    statement.setObject(i+1, obj[i]);
                }
                result = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //todo:关闭这个连接
            }

            if (result == 1) {
                System.out.println("跟新成功");
            } else {
                System.out.println("跟新失败");
            }
        }


    }

    private class Query {
        public void query(String sql) {
            connection = ConnectJDBC.getConnection();
            try {
                PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
                resultSet = statement.executeQuery();
                list = new DealResultSet().ResultSet(resultSet,sql);
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //todo:关闭这个连接
            }
            // todo:这个地方将数据格式化
            for (StudentTable s :
                    list) {
                System.out.println(s.getAge());
            }
        }
    }

    private class Insert {
        public void insert(String sql) {
            connection = ConnectJDBC.getConnection();

            int result = -1;
            try {
                System.out.println(sql);
                PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
                result = statement.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                //todo:关闭这个连接
            }

            if (result == 1) {
                System.out.println("跟新成功");
            } else {
                //todo:插入前先搜索主键是否唯一
                System.out.println("跟新失败");
            }
        }
    }

    private class Add {
        public void add() {

        }
    }

    public void selected(int num, String sql, Object... objects) {
        switch (num) {
            case 1:
                new Query().query(sql);
                break;
            case 2:
                break;
            case 3:
                new Update().update(sql, objects);
                break;
            case 4:
                new Insert().insert(sql);
                break;
            case 5:

                break;
        }
    }


    public static class TestControl {
        public static void main(String[] args) {
            Control control = new Control();
        }
    }
}
