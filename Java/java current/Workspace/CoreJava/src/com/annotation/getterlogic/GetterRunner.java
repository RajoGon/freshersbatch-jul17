package com.annotation.getterlogic;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.annotation.getter.Getter;
import com.annotation.student.Student;

public class GetterRunner {
	
	public static void main(String[] args){
		String methodname;
		String initial;
		char initialfieldname;
		String ending;
		Object methodreturn;
		Object variabletype;
		Student runner = new Student();
        Method[] methods = runner.getClass().getMethods();
        
        for (Method method : methods) {
        	Getter annos = method.getAnnotation(Getter.class);
            if (annos != null) {
                try {               	
                	methodname=method.getName();
                	initial = methodname.substring(0,3);
                	initialfieldname = methodname.charAt(3);
                	ending = methodname.substring(3,methodname.length());
                	ending = ending.toLowerCase();
                	if( initial.equals("get") &&  Character.isUpperCase(initialfieldname)){
                		
                		try{
	                		Field field = runner.getClass().getField(ending);
	                    	field.setAccessible(true);
	                    	variabletype=field.getType().getName();
	                    	methodreturn = method.getReturnType().getName();
	                    	if(variabletype==methodreturn){
	                    		System.out.println("Valid method "+methodname);
	                    	}else{
	                    		System.out.println("Invalid method "+methodname);
	                    	}
	                		
                		} catch (Exception e){
                			 e.printStackTrace();
                		}
                		
                	}else{
                		System.out.println("Invalid mthod "+methodname);
                	}
                	               	               	               	                                	               	                           	
                    //method.invoke(runner);
                } catch (Exception e) {
                    e.printStackTrace();
                	
                }
            }
        }
	}

}
