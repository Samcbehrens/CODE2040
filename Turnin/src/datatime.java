
public class datatime {

	
public static void main(String args[]){
	//put initial time here
	String initStringtime="";
	
	//put interval time here
	int interval=0;
	
	String DatevsTime[]=initStringtime.split("T");
	String dateArray[]=DatevsTime[0].split("-");
	
	
	
	//Splits into {year,month,day,overalltime}
	//have to split overall time to hours and seconds 
	
	String year=dateArray[0];
	Integer intYear=Integer.parseInt(year);
	
	String month=dateArray[1];
	Integer intMonth=Integer.parseInt(month);
	
	String day=dateArray[2];
	Integer intDay=Integer.parseInt(day);
	
	String timeArray[]=DatevsTime[1].split(":");
	
	String hour=timeArray[0];
	Integer intHour=Integer.parseInt(hour);
	 
	String minute=timeArray[1];
	Integer intMinute=Integer.parseInt(minute);
	
	String getRidofmill[] = null;
	
	if(timeArray[2].contains("+")){
		getRidofmill=timeArray[1].split("+");
	}
	else if (timeArray[2].contains("Z")){
		getRidofmill=timeArray[1].split("Z");
	}
	else if (timeArray[2].contains("-")){
		getRidofmill=timeArray[1].split("-");
	}

	String seconds=getRidofmill[0];
	Integer intSecond=Integer.parseInt(seconds);
	
	
	//convert interval into year, moth, days,hours,minutes,seconds 
	
	float intervalDays=(((interval/60)/60)/24);//minutes,hours,days 
	float monthstoAdd=intervalDays%30;
	float daystoAdd=intervalDays-(30*monthstoAdd);
	float hourstoAdd=(intervalDays%1)*24;
	float minutestoAdd=(hourstoAdd%1)*60;
	float secondstoAdd=(minutestoAdd%1)*60;
	
	intMonth=(int) (intMonth+monthstoAdd);
	//if months equal more than one year
	if(intMonth>=12){
		intYear=intYear+1;
		intMonth=intMonth%12;
	}
	
	intDay=(int) (intDay+daystoAdd);
	//deal with month with different days 
	//30 9,4,6,11 
	//28 2
	//31 1,3,5,7,8,10,12
	
	if((intMonth==9 ||intMonth==4 ||intMonth==6 ||intMonth==11 )&& intDay>=30){
		intMonth=intMonth+1;
		intDay=intDay%30;
	}
	else if((intMonth==2) && intDay>=28){
		intMonth=intMonth+1;
		intDay=intDay%28;
	}
	else if(intDay>=31){
		intMonth=intMonth+1;
		intDay=intDay%31;
	}
	
	intHour=(int) (intHour+hourstoAdd);
	if(intHour>=24){
		intDay=intDay+1;
		intHour=intHour%24;
	}
	
	intMinute=(int) (intMinute+minutestoAdd);
	if(intMinute>=60){
		intHour=intHour+1;
		intMinute=intMinute%60;
	}
	
	intSecond= (int) (intSecond+secondstoAdd);
	if (intSecond>=60){
		intMinute=intMinute+1;
		intSecond=intSecond%60;
	}
	
	String finalOutput=""+intYear+"-";
	
	if(intMonth<10){
		finalOutput=finalOutput+0;
	}
	
	finalOutput=finalOutput+intMonth+"-";
	
	if(intDay<10){
		finalOutput=finalOutput+0;
	}
	finalOutput=finalOutput+intDay+"T";
	
	if(intHour<10){
		finalOutput=finalOutput+0;
	}
	finalOutput=finalOutput+intHour+":";
	
	if(intMinute<10){
		finalOutput=finalOutput+0;
	}
	finalOutput=finalOutput+intMinute+":";
	
	if(intSecond<10){
		finalOutput=finalOutput+0;
	}
	finalOutput=finalOutput+intSecond+":";
	
	if (timeArray[2].contains("Z")){
		finalOutput=finalOutput+intSecond+"Z";
	}
	else{
		finalOutput=finalOutput+"+"+getRidofmill[1];
	}
	
	System.out.println(finalOutput);
}
}