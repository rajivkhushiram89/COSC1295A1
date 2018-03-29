package com.rmit.assignment1;

import java.util.ArrayList;
import java.util.Scanner;
 


/*
 * 
 * Author name: Rajiv Khushiram
 * 
 */


public class Mininet {
	public static ArrayList<Person> allusers;
	public static ArrayList<Adult> parentUsers;
	public static ArrayList<Dependent> childUsers;
	static Scanner scanner = new Scanner(System.in);
	static int x = 0;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new InMemory1();
		start();	
	}
	
	public static void start() {
		int selection = 0;

		while (x == 0)  {
			displayMenu();
			selection = scanner.nextInt();
			switch (selection) {
			case 1:
				x = 1;
				listall();
				x = 0;
				break;
			case 2:
				x = 1;
				int y = 0;
				Person selectedUser = null;
				System.out.println("Enter Person Name:");
				String nameUser = scanner.next();
				for (Person userVar : allusers) {
					if (nameUser.toString().equals(userVar.getName())) {
						selectedUser = userVar;
						selectedUser.display();
						y= 1;
					}else {	
						x=0;
					}
				}
				if (y==1){
					System.out.println("Profile Found!");
					x=0;
				}else {
					System.out.println("No Such User Found");
					x=0;
				}
				break;
			case 3:
				x = 1;			
				areTheyFriends();
				x=0;
				break;
			case 4:
				x = 1;
				System.out.println("Insert New User Name:");
				String insertUserName = scanner.next();
				System.out.println("Insert Age of User:");
				int insertUserAge = scanner.nextInt();

				if (insertUserAge > 16) {

					// Adult Constructor
					Adult newUser = new Adult(insertUserName, insertUserAge);
					allusers.add(newUser);
					parentUsers.add(newUser);
					x = 0;
				} else {
					// Child Construtor
					System.out.println("Insert Father Name");
					String motherName = scanner.next();
					if (parentExits(motherName)) {
						Adult parent11Obj = returnedParent(motherName);
						System.out.println("Enter mother Name");
						String fatherName = scanner.next();
						if ((parentExits(fatherName) && (!(fatherName.equals(motherName))))) {
							Adult parent2Obj = returnedParent(fatherName);
							Dependent addedDep = new Dependent(insertUserName, insertUserAge, parent11Obj,
									parent2Obj);
							allusers.add(addedDep);
							childUsers.add(addedDep);
							x = 0;
						} else {
							// S
							System.out.println("Something failed");
							x = 0;
						}
					} else {
						System.out.println("No Such Parent Exits");
						x = 0;
					}
				}
				break;
			case 5:
				x=1;
				System.out.println("Enter Name of First User:");
				String insertUserName1 = scanner.next();
				System.out.println("Insert Name of Second of User:");
				String insertUsername2 = scanner.next();
				Person user11 = returnedUser(insertUserName1);
				Person user22 = returnedUser(insertUsername2);	
				
				user11.addFriends(user22);
				x=0;		
				break;
			case 9:
				System.exit(0);
				break;
			default:
				System.out.println("Please enter a valid selection.");		
			}
		}
	
	}
	private static boolean areTheyFriends(Person user1, Person user2){		
		int booleanControl = 0;
		ArrayList<Person> user1Friends =new ArrayList<>();		 
			 user1Friends = user1.getFriends();
			 for (Person instance: user1Friends){
					if((user2.getName()).equals(instance.getName())){
						System.out.println("They are friends");
						booleanControl = 1;
					}
					else {
					}
				}		
		 if (booleanControl==1){
				return true;
			}
			else {
				return false;
			}	
	}
	public static void displayMenu(){
		System.out.println("Please Make a selection:");
		System.out.println("[1] List All Profiles");
		System.out.println("[2] Select a profile by Name");
		System.out.println("[3] Are these 2 Persons friends?");
		System.out.println("[4] Add a Profile");
		System.out.println("[5] Connect two Persons");
		System.out.println("[9] Quit");
		System.out.println("Selection: ");
	}
	public static void listall(){
		for (Person userVar : allusers) {
			userVar.display();
		}
	}
	
	private static Person returnedUser(String nameofUser) {
		Person user1 = null;
		for (Person userVar : allusers) {
			if (nameofUser.toString().equals(userVar.getName())) {
				user1 = userVar;
			}
		}
		return user1;
	}
	
	public static void areTheyFriends(){
		System.out.println("Insert First User name:");
		String insertedFName= scanner.next();
		System.out.println("Insert Second User name:");
		String insertedSName = scanner.next();
		Person person1 = returnedUser(insertedFName);
		Person person2 = returnedUser(insertedSName);
	
		if(areTheyFriends(person1, person2)){
			System.out.println("They are direct Friends");					
		}else{
			System.out.println("They are Not direct Friends");					
		}	
	}
	private static boolean parentExits(String parent) {
		for (Adult userVar : parentUsers) {
			if (parent.toString().equals(userVar.getName())) {
				return true;
			}
		}
		return false;
	}
	private static Adult returnedParent(String nameOfParent) {
		Adult parent1 = null;
		for (Adult userVar : parentUsers) {
			if (nameOfParent.toString().equals(userVar.getName())) {
				parent1 = userVar;
			}
		}
		return parent1;
	}
	
	
	

}
