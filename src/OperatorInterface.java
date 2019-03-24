import Service.InfoTips;
import dao.Control;
import dao.DO.StudentTable;
import util.SqlUtil;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class OperatorInterface {
    public static void main(String[] args) {
        // 程序运行就访问数据库,将数据进行填充
        Control control = new Control();
        //选择操作界面
        boolean flag = true;

        do {
            InfoTips.showInfo();

            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    //查询学生表
                    String querySql="select * from xs";
                    control.selected(1,querySql);
                    continue;
                case 2:
                    //删除
                    continue;
                case 3:
                    //修改
                    StudentTable studentTable=new StudentTable();
                    //todo:将修改的信息抽取出来
                    studentTable.setXuehao("81242");
                    studentTable.setAge(1);
                    List<String> list=new ArrayList();
                    list.add(studentTable.getAge().toString());
                    list.add(studentTable.getXuehao());
                    StringBuilder sql= SqlUtil.getUpdateSQL(studentTable);
                    //调用dao操作
                    control.selected(3,sql.toString(),list.toArray());
                    continue;
                case 4:
                    //增加
                    StudentTable studentTable1=new StudentTable();
                    studentTable1.setXuehao("1111");
                    studentTable1.setXingming("hello");
                    studentTable1.setZhuanyeming("计算机");
                    studentTable1.setXingbie(1);
                    studentTable1.setChushengshijian(Date.valueOf("2019-1-1"));
                    studentTable1.setZhongxuefen(123);
                    byte[] bytes = new byte[1024];
                    studentTable1.setZhaopian(bytes);
                    studentTable1.setBeizhu(" ");
                    studentTable1.setAge(199);
                    String insertSql=SqlUtil.getInsertSQL(studentTable1).toString();
                    control.selected(4,insertSql);
                    continue;
                case 5:
                    //退出
                    flag=false;
                    break;
                default:
                    System.out.println("输入错误,请重写输入");

            }
            //todo:优化一下出数据结果后给一个提示继续操作,还是退出
        } while (flag);
    }
}
