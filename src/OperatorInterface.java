import Service.InfoTips;
import dao.Control;

import java.util.Scanner;

public class OperatorInterface {
    public static void main(String[] args) {
        // 程序运行就访问数据库,将数据进行填充
        Control control = new Control();
        //选择操作界面
        boolean flag = false;
        do {
            InfoTips.showInfo();
            flag = false; //判断是否重写输入
            Scanner scanner = new Scanner(System.in);
            switch (scanner.nextInt()) {
                case 1:
                    //查询学生表
                    break;
                case 2:
                    break;
                case 3:
                    break;
                case 4:
                    break;
                default:
                    System.out.println("输入错误,请重写输入");
                    flag = true;
            }
        } while (flag);
    }
}
