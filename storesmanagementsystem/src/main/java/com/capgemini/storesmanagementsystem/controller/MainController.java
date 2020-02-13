package com.capgemini.storesmanagementsystem.controller;

import java.util.Scanner;

import org.apache.log4j.Logger;

import com.capgemini.storesmanagementsystem.exception.UserNotFoundException;
import com.capgemini.storesmanagementsystem.service.AdminServiceImpl;


public class MainController {

	static Logger log = Logger.getLogger("store");

	public static void main(String[] args) {
		
	   

		AdminServiceImpl service = new AdminServiceImpl();
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		log.info("===================================");
		log.info("Welcome To Store Management System");
		log.info("Enter Your Choice:");
		log.info("Press 1.Admin");
		log.info("Press 2.Manufacturer");
		log.info("Press 3.Dealer");
		log.info("Press 4.Exit");
		log.info("===================================");

		int count = 0;
		do {
			
			log.info("+=+=+=+=+=+=+=+=+=+=+=+=");
			log.info("Enter Your Choice:");
			log.info("+=+=+=+=+=+=+=+=+=+=+=+=");
			

			choice = sc.nextInt();

			switch (choice) {
			case 1:
                
				if (count < 1) {
					count++;
					while(true) {
					log.info("Enter your id");
					String id=sc.next();
					log.info("Enter Your Username:");
					String name = sc.next();
					log.info("Enter Your Password:");
					String password = sc.next();
					
					boolean b=service.passwordValidate(password);
					if(b) {
						service.loginAdmin(name, password, id);
						log.info("successFully Login");
						break;
					}else {
						try{
							throw new UserNotFoundException("User Not Found");
						}
						catch(Exception exp){
							log.info(exp);
						}
					   
					}
				}
			}

				AdminController admin = new AdminController();
				admin.adminTask();

				break;
				
			case 2:

			ManufacturerController manufacturer = new ManufacturerController();
				manufacturer.manufactureTask();
				break;

			case 3:

				DealerController dealer = new DealerController();
				dealer.dealerTask();
				break;

			}
		} while (choice != 3);

		log.trace("ThankYou for using our Services!!!");
		sc.close();
		
	}
}

