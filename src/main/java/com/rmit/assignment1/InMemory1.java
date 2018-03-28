package com.rmit.assignment1;

import java.util.ArrayList;

public class InMemory1 {
	
	public InMemory1() {
		
		Adult Adult1 = new Adult("John", 30);
		Adult Adult2 = new Adult("Jane", 21);
		Dependent dependent1 = new Dependent("Jack", 6, Adult1, Adult2);
		
		Adult Adult3 = new Adult("Kohn", 66);
		Adult Adult4 = new Adult("Kane", 62);
		Dependent dependent2 = new Dependent("Kack", 4, Adult3, Adult4);
		
		Adult Adult5 = new Adult("Toni",  51);
		Adult Adult6 = new Adult("Uli",  28);
		
		Dependent dependent3 = new Dependent("Rachel", 4, Adult5, Adult6);
		
		Adult1.addFriendsSilent(Adult3);
		Adult1.addFriendsSilent(Adult4);
		Adult2.addFriendsSilent(Adult3);
		Adult2.addFriendsSilent(Adult4);
		Adult3.addFriendsSilent(Adult1);
		Adult3.addFriendsSilent(Adult2);
		Adult4.addFriendsSilent(Adult1);
		Adult4.addFriendsSilent(Adult2);
		
		dependent1.addFriendsSilent(dependent2);
		dependent2.addFriendsSilent(dependent1);
		dependent2.addFriendsSilent(dependent3);
		dependent3.addFriendsSilent(dependent2);	
		Mininet.allusers = new ArrayList<Person>();
		Mininet.parentUsers = new ArrayList<Adult>();
		Mininet.childUsers = new ArrayList<Dependent>();
		Mininet.allusers.add(Adult1);
		Mininet.allusers.add(Adult2);
		Mininet.allusers.add(Adult3);
		Mininet.allusers.add(Adult4);
		Mininet.allusers.add(Adult5);
		Mininet.allusers.add(Adult6);
		Mininet.allusers.add(dependent1);
		Mininet.allusers.add(dependent2);
		Mininet.allusers.add(dependent3);

		Mininet.parentUsers.add(Adult1);
		Mininet.parentUsers.add(Adult2);
		Mininet.parentUsers.add(Adult3);
		Mininet.parentUsers.add(Adult4);
		Mininet.parentUsers.add(Adult5);
		Mininet.parentUsers.add(Adult6);

		Mininet.childUsers.add(dependent1);
		Mininet.childUsers.add(dependent2);
		Mininet.childUsers.add(dependent3);
		
	}

	
}
