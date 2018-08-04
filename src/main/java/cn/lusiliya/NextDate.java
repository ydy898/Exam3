package cn.lusiliya;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * Created by Lusiliya on 2018/8/4.
 */
public class NextDate {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入日期：");
        String str = null ;
        Date date = null;
        if(scanner.hasNext("^\\d{4}-\\d{1,2}-\\d{1,2}$")){ // 判断
            str = scanner.next("^\\d{4}-\\d{1,2}-\\d{1,2}$") ; //
            String[] dateArr = str.split("-");
            int[] numArr = {Integer.valueOf(dateArr[0]),Integer.valueOf(dateArr[1]),Integer.valueOf(dateArr[2])};
            if(numArr[1]<1||numArr[1]>12||numArr[2]<1||numArr[2]>31){
                System.out.println(numArr[0]);
                System.out.println(numArr[1]);
                System.out.println(numArr[2]);
                System.out.println("您输入的日期不存在!");
            }
            else{
                System.out.println("下一天为：" + nextDate(numArr));

            }
        }else{
            System.out.println("您输入的日期不存在") ;
        }
    }

    private static String nextDate(int[] dateArr) {
        String date = null;
        if(dateArr[2]<28){
            dateArr[2] = dateArr[2]+1;
        }else if(dateArr[2] == 29){
            if(dateArr[0]%400 == 0 || dateArr[0]%100 != 0&&dateArr[0]%4 == 0){
                if(dateArr[1] ==2) {
                    dateArr[1] = dateArr[1] + 1;
                    dateArr[2] = 1;
                }else {
                    dateArr[2] = dateArr[2] + 1;
                }
            }else{
                System.out.println("您输入的日期不存在");
                return null;
            }
        }else if(dateArr[2] == 31){
            if(dateArr[1] == 2||dateArr[1] == 4||dateArr[1] == 6||dateArr[1] == 9||dateArr[1] == 11){
                System.out.println("您输入的日期不存在");
                return null;
            }else{
                if(dateArr[1] !=12) {
                    dateArr[1] = dateArr[1] + 1;
                    dateArr[2] = 1;
                }else {
                    dateArr[0] = dateArr[0] + 1;
                    dateArr[1] = 1;
                    dateArr[2] = 1;
                }
            }
        } else if(dateArr[2] == 30) {
            if(dateArr[1] != 2){
                if (dateArr[1] == 4||dateArr[1] == 6||dateArr[1] == 9||dateArr[1] == 11){
                    dateArr[1] = dateArr[1] + 1;
                    dateArr[2] = 1;
                }else {
                    dateArr[2] = dateArr[2] + 1;
                }
            }else{
                System.out.println("您输入的日期不存在");
                return null;
            }
        } else {
            if(dateArr[1] != 2){
                dateArr[2] = dateArr[2] +1;
            }else{
                if(dateArr[0]%400 == 0 || dateArr[0]%100 != 0&&dateArr[0]%4 == 0){
                    dateArr[2] = dateArr[2] + 1;
                }else{
                    dateArr[1] = dateArr[1] + 1;
                    dateArr[2] = 1;
                }
            }
        }
        date = String.valueOf(dateArr[0])+"-"+String.valueOf(dateArr[1])+"-"+String.valueOf(dateArr[2]);
        return date;
    }
}
