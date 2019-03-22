package dao.DO;

import java.sql.Blob;
import java.sql.Date;

public class StudentTable {
    private String xuehao;
    private String xingming;
    private String zhuanyeming;
    private Integer xingbie;
    private Date chushengshijian;
    private Integer zhongxuefen;
    private Blob zhaopian;
    private Integer age;

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



    public void setAge(int age) {
        this.age = age;
    }

    public Integer getXingbie() {
        return xingbie;
    }

    public void setXingbie(Integer xingbie) {
        this.xingbie = xingbie;
    }

    public Integer getZhongxuefen() {
        return zhongxuefen;
    }

    public void setZhongxuefen(Integer zhongxuefen) {
        this.zhongxuefen = zhongxuefen;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setZhongxuefen(int zhongxuefen) {
        this.zhongxuefen = zhongxuefen;
    }
}
