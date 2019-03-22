package dao;

import com.mysql.jdbc.PreparedStatement;
import dao.DO.ParmCon;
import dao.DO.StudentTable;
import dao.util.ConnectJDBC;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


/**
 * control 类 中有很多内部类实现控制
 */
public  class Control {
    private List<StudentTable> list = new ArrayList<>();
    private Connection connection = null;
    private PreparedStatement statement = null;
    private ResultSet resultSet = null;
    private String sql = "select * from xs";

    public Control() {
        connection = ConnectJDBC.getConnection();
        try {
            PreparedStatement statement = (PreparedStatement) connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
            this.list = new DealResultSet().dealReasult(resultSet);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }


    private class DealResultSet {
        public List<StudentTable> dealReasult(ResultSet resultSet) {
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
                    studentTable.setZhaopian(resultSet.getBlob(ParmCon.StudentParm.ZHAOPIAN));
                    studentTable.setAge(resultSet.getInt(ParmCon.StudentParm.AGE));
                    list.add(studentTable);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return list;
        }
    }

    private  class Update {
        public  void update() {

        }


    }

    private  class Query {
        public  void query() {

        }
    }

    private  class Insert {
        public  void insert() {

        }
    }

    private  class Add {
        public  void add() {
            for (StudentTable s :
                    list) {
                System.out.println(s.getAge());
            }
        }
    }

    public  void selected(int num) {
        switch (num){
            case 1:
                new Add().add();
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
        }
    }

    public static class TestControl {
        public static void main(String[] args) {
            Control control = new Control();
        }
    }
}
