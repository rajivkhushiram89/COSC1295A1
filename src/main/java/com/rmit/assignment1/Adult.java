package com.rmit.assignment1;

import java.util.ArrayList;


public class Adult extends Person{

	public Mininet mininet;
	public ArrayList<Dependent> children;
	

	public Adult(String name, int age) {
		super(name, age);
		this.children = new ArrayList<Dependent>();
	}
	
	@Override
	public void display() {
		// TODO Auto-generated method stub
		System.out.println("Adult User Profile");
		System.out.println("Name: " + getName());
		System.out.println("Age: " + getAge());
		System.out.println("Picture path: " + getPicture());
		System.out.print("Children = ");
		for (Dependent instance1: children){
			System.out.print( instance1.getName()+ ", ");
		}
		System.out.println("");

		System.out.print("Friends =  ");
		for (Person instance1: friends){
			System.out.print( instance1.getName()+ ", ");
		}
		System.out.println("");
		System.out.println("=============");
	}

	
	@Override
	public ArrayList<Dependent> getChildren() {
		return children;
	}

	public void setChildren(ArrayList<Dependent> children) {
		this.children = children;
	}
	
	public void  addChildren(Dependent adult) {
		this.children.add(adult);
		
	}

	@Override
	public ArrayList<Adult> getParents() {
		// TODO Auto-generated method stub
		return super.getParents();
	}
	
	

}
	

