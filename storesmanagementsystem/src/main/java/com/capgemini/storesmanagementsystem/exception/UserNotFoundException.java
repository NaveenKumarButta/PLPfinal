package com.capgemini.storesmanagementsystem.exception;

public class UserNotFoundException extends RuntimeException{
		   String str1="";
		  
		   public UserNotFoundException(String str2){
			super();
			   str1=str2;
			
		   }
		   public UserNotFoundException(){
			   super();
		   }
		   
		   
		   public String getMessage(){ 
			return "Admin Not found";
		   }
		

		   
		}


