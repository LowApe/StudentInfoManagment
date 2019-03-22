package dao.DO;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ParmCon {
    private static Properties properties =new Properties();
    static {
        InputStream is=ParmCon.class.getClassLoader().getResourceAsStream("db.properties");
        try {
            properties.load(is);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static final String DRIVER = properties.getProperty("driver");
    public static final String URL = properties.getProperty("url");
    public static final String USERNAME = properties.getProperty("username");
    public static final String PASSWORD = properties.getProperty("password");

    /**
     * 学生表字段信息
     */
    public static class StudentParm{
        public static final String XUEHAO="学号";
        public static final String XINGMING="姓名";
        public static final String ZHUANYEMING="专业名";
        public static final String XINGBIE="性别";
        public static final String CHUSHENGSHIJIAN="出生时间";
        public static final String ZONGXUEFEN="总学分";
        public static final String ZHAOPIAN="照片";
        public static final String BEIZHU="备注";
        public static final String AGE="age";
    }

    public static class GradeParm{
        public static final String XUEHAO="学号";
        public static final String KECHENGHAO="课程号";
        public static final String CHENGJI="成绩";
        public static final String XUEFEn="学分";
    }
}
