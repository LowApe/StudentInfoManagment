package Service;

public class InfoTips {
    public static void showInfo(){
        System.out.println("============================");
        System.out.println("请按照操作的标号输入:");
        System.out.println("1.查询");
        System.out.println("2.删除");
        System.out.println("3.修改");
        System.out.println("4.增加");
        System.out.println("5.退出");
        System.out.println("============================");
    }

    public static void enterInfo(int num){

    }

    /**
     * 测试类
     */
    public static class TestInfoTips{
        public static void main(String[] args) {
            showInfo();
        }
    }
}
