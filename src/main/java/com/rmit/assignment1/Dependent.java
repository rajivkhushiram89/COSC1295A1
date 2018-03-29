package com.rmit.assignment1;

import java.util.ArrayList;



/*
 * 
 * 
 * 
 * 
 * Author Name: Geoffrey Tirop 
 * 
 */

public class Dependent extends Person {

	private Adult fatherObj;
	private Adult motherObj;
	public ArrayList<Adult> parents;
	
	public Dependent(String name, int age, Adult dad, Adult mom) {
		super(name, age);
		this.fatherObj = dad;
		this.motherObj = mom;
		dad.addChildren(this);
		mom.addChildren(this);
		this.parents = new ArrayList<Adult>();
		parents.add(dad);
		parents.add(mom);
		if (age < 3 ){		
		}else {
			friends = new ArrayList<Person>();
		}	
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Depedent User Profile");
		System.out.println("");
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Picture path: " + getPicture());
		System.out.println("Father: " + fatherObj.getName() );
		System.out.println("Mother: " + motherObj.getName() );;
		System.out.print("Friends =  ");
		for (Person instance1: friends){
			System.out.print( instance1.getName()+ ", ");
		}
		System.out.println("");
		System.out.println("====================");

	}

	public Adult getFatherObj() {
		return fatherObj;
	}
	public void setFatherObj(Adult fatherObj) {
		this.fatherObj = fatherObj;
	}


	public Adult getMotherObj() {
		return motherObj;
	}
	public void setMotherObj(Adult motherObj) {
		this.motherObj = motherObj;
	}
	
	@Override
	public ArrayList<Adult> getParents() {
		// TODO Auto-generated method stub
		return parents;
	}
	


}
	
	
