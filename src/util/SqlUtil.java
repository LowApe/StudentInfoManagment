package util;

import dao.DO.ClassTable;
import dao.DO.GradeTable;
import dao.DO.ParmCon;
import dao.DO.StudentTable;



public class SqlUtil {
    public static int parmCount=1;
    public static StringBuilder getUpdateSQL(Object object){

        StringBuilder sql=new StringBuilder();
        if(object instanceof StudentTable){
            sql.append("update "+ ParmCon.STUDETNT_TABLE+" set ");
            StudentTable s= (StudentTable) object;
            if(s.getAge()!=null){
                sql.append(ParmCon.StudentParm.AGE+"=?,");
                parmCount++;
            }

            if(s.getXingming()!=null){
                sql.append(ParmCon.StudentParm.XINGMING+"=?,");
                parmCount++;
            }

            if(s.getZhaopian()!=null){
                sql.append(ParmCon.StudentParm.ZHAOPIAN+"=?,");
                parmCount++;
            }

            if(s.getZhongxuefen()!=null){
                sql.append(ParmCon.StudentParm.ZONGXUEFEN+"=?,");
                parmCount++;
            }

            if(s.getZhuanyeming()!=null){
                sql.append(ParmCon.StudentParm.ZHUANYEMING+"=?,");
                parmCount++;
            }
        }
        //todo: kc 的 update sql
        if(object instanceof ClassTable){

        }
        // todo: xs_kc 的 update sql
        if(object instanceof GradeTable){

        }
        sql.deleteCharAt(sql.length()-1);
        sql.append(" where "+ParmCon.StudentParm.XUEHAO+"=?;");
        return sql;
    }

    public static StringBuilder getInsertSQL(Object object){
        StringBuilder sql=new StringBuilder();
        if(object instanceof StudentTable){
            //插入不同字段;
            sql.append("insert into "+ ParmCon.STUDETNT_TABLE+" values(");
            StudentTable s= (StudentTable) object;
            sql.append(s.getXuehao()+",");
            sql.append("'"+s.getXingming()+"'"+",");
            sql.append("'"+s.getZhuanyeming()+"'"+",");
            sql.append(s.getXingbie()+",");
            sql.append("'"+s.getChushengshijian()+"'"+",");
            sql.append(s.getZhongxuefen()+",");
            sql.append(42+",");
            sql.append("NULL"+",");
            sql.append(s.getAge()+") ");
        }

        //todo: kc 的 update sql
        if(object instanceof ClassTable){

        }
        // todo: xs_kc 的 update sql
        if(object instanceof GradeTable){

        }
        System.out.println(sql);
        return sql;
    }

    public static class TestSqlUtil{
        public static void main(String[] args) {
            StudentTable studentTable = new StudentTable();
            studentTable.setAge(123);
            studentTable.setXingming("tom");
            System.out.println(getUpdateSQL(studentTable).toString());
        }
    }
}
