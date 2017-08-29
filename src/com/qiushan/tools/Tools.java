package com.qiushan.tools;

import java.util.Calendar;

public class Tools {
   public static String[] getDate(){
    	boolean flag =false;
		Calendar c = Calendar.getInstance();
		int year=c.get(Calendar.YEAR);
		int month = c.get(Calendar.MONTH);
		int count=0;
		if((year%4==0&&year%100!=0)||year%400==0){
			flag=true;
		}else{
			flag =false;
		}
		switch (month) {
		case 0:
			count=31;	
			break;
		case 1:
			if(flag){
				count =29;
			}else{
				count=28;
			}
			break;
		case 2:
			count=31;
			break;
		case 3:
			count =30;
			break;
		case 4:
			count=31;
			break;
		case 5:
			count=30;
			break;
		case 6:
			count=31;
			break;
		case 7:
			count=31;
			break;
		case 8:
			count = 30;
			break;
		case 9:
			count=31;
			break;
		case 10:
			count = 30;
			break;
		case 11:
			count = 31;
			break;
		default:
			System.out.println("ÔÂ·Ý´íÎó");
			break;
		}
		int dayOfMonth = c.get(Calendar.DAY_OF_MONTH);
		System.out.println(dayOfMonth);
		String[] w = new String[30];
		int trueMonth=month+1;
		dayOfMonth=10;
		for(int i=0;i<30;i++){
			w[i]=year+"-"+trueMonth+"-"+dayOfMonth;
			dayOfMonth++;
			if(dayOfMonth>count){
				dayOfMonth=1;
				trueMonth=trueMonth+1;
			}
		}
		for(int i=0;i<30;i++){
			System.out.print(w[i]+"  ");
		}
		return w;
    }
}
