package com.rmit.assignment1;
/*
 *
 *Author Name: Geoffrey Tirop
 *
 *
 */
import java.util.ArrayList;

public abstract class Person {

	private String name;
	private String status;
	private int age;
	private String picture;

	protected ArrayList<Person> friends;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
		this.friends = new ArrayList<Person>();
	}
	public void display() {
	}
	public ArrayList<Person> returnListofFriends() {
		return friends;
	}
	public void addFriends(Person potentialFriend) {
		if (areTheyFriendsss(this, potentialFriend) && (!(areTheyFamily(this, potentialFriend)))) {
			System.out.println("Do Nothing");
		} else {

			int ageGap = Math.abs((this.getAge()) - (potentialFriend.getAge()));

			if (((this.getAge() < 16) && potentialFriend.getAge() > 16)
					|| ((this.getAge() > 16) && potentialFriend.getAge() < 16)) {
				System.out.println("Cannot be Friends due to age limit of 2 years old");

			} else if ((((this.getAge() <= 2) || potentialFriend.getAge() <= 2))) {

			} else if ((((this.getAge() <= 16) && ageGap >= 3) || (potentialFriend.getAge() <= 16) && ageGap >= 3)) {

			} else {
				this.friends.add(potentialFriend);
				System.out.println("Friend Added");
			}
		}
	}
	public void addFriendsSilent(Person potentialFriend) {
		if (areTheyFriendsss(this, potentialFriend) && (!(areTheyFamily(this, potentialFriend)))) {
			System.out.println("Do Nothing");
		} else {

			int ageGap = Math.abs((this.getAge()) - (potentialFriend.getAge()));

			if (((this.getAge() < 16) && potentialFriend.getAge() > 16)
					|| ((this.getAge() > 16) && potentialFriend.getAge() < 16)) {
				System.out.println("Cannot be Friends due to age limit of 2 years old");

			} else if ((((this.getAge() <= 2) || potentialFriend.getAge() <= 2))) {

			} else if ((((this.getAge() <= 16) && ageGap >= 3) || (potentialFriend.getAge() <= 16) && ageGap >= 3)) {

			} else {
				this.friends.add(potentialFriend);
				//System.out.println("Friend Added");
			}
		}
	}

	public void setFriends(ArrayList<Person> friends) {
		this.friends = friends;
	}

	public boolean areTheyFriendsss(Person person, Person user2) {
		int booleanControl = 0;
		ArrayList<Person> user1Friends = new ArrayList<>();
		user1Friends = person.getFriends();
		for (Person instance : user1Friends) {
			if ((user2.getName()).equals(instance.getName())) {
				System.out.println("They are friends");
				booleanControl = 1;
			}
		}
		if (booleanControl == 1) {
			return true;
		} else {
			return false;
		}
	}
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public ArrayList<Person> getFriends() {
		return this.friends;
	}

	public ArrayList<Dependent> getChildren() {
		return null;
	}
	public ArrayList<Adult> getParents() {
		return null;
		
	}
	
	private static boolean areTheyFamily(Person user1, Person user2) {
		// TODO Auto-generated method stub
		int booleanControl = 0;	
		ArrayList<Dependent> user1Child =new ArrayList<>();
		 ArrayList<Adult> user2Parents = new ArrayList<>();
		 ArrayList<Dependent> user2Child =new ArrayList<>();
		 ArrayList<Adult> user1Parents = new ArrayList<>();
		 user1Child = user1.getChildren();
		 user2Parents = user2.getParents();
		 user2Child = user2.getChildren();
		 user1Parents = user1.getParents();	 
		 for (Person instance1: user1Child){
			 for (Person instance2: user2Parents){
				 	if((instance1.getName()).equals((instance2).getName())){
				 		booleanControl=1;
				 	}
			 }
		 }	 
		  for (Person instance1: user2Child){
			 for (Person instance2: user1Parents){
				 	if((instance1.getName()).equals((instance2).getName())){
				 		booleanControl=1;
				 	}
			 }
		 }
		 if (booleanControl==1){
			 System.out.println("They Are Familly");
				return true;
			}
			else {
				 System.out.println("They Are Not Familly");

				return false;
			}	
	}


}
