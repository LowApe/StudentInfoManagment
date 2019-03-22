package dao.DO;

import java.sql.Blob;
import java.sql.Date;

public class StudentTable {
    private String xuehao;
    private String xingming;
    private String zhuanyeming;
    private int xingbie;
    private Date chushengshijian;
    private int zhongxuefen;
    private Blob zhaopian;
    private int age;

    public String getXuehao() {
        return xuehao;
    }

    public void setXuehao(String xuehao) {
        this.xuehao = xuehao;
    }

    public String getXingming() {
        return xingming;
    }

    public void setXingming(String xingming) {
        this.xingming = xingming;
    }

    public String getZhuanyeming() {
        return zhuanyeming;
    }

    public void setZhuanyeming(String zhuanyeming) {
        this.zhuanyeming = zhuanyeming;
    }

    public int getXingbie() {
        return xingbie;
    }

    public void setXingbie(int xingbie) {
        this.xingbie = xingbie;
    }

    public Date getChushengshijian() {
        return chushengshijian;
    }

    public void setChushengshijian(Date chushengshijian) {
        this.chushengshijian = chushengshijian;
    }

    public Blob getZhaopian() {
        return zhaopian;
    }

    public void setZhaopian(Blob zhaopian) {
        this.zhaopian = zhaopian;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getZhongxuefen() {
        return zhongxuefen;
    }

    public void setZhongxuefen(int zhongxuefen) {
        this.zhongxuefen = zhongxuefen;
    }
}
