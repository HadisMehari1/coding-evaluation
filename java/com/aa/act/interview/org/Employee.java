package com.aa.act.interview.org;

import java.math.BigDecimal;

public class Employee {

	private int identifier;
	private Name name;
	private static int employeeId = 1;

	public Employee(int identifier, Name name) {
		if(name == null)
			throw new IllegalArgumentException("name cannot be null");
		if(identifier <= 0){
			this.identifier = employeeId++;
		}
		else{
			this.identifier = identifier;
		}
		this.name = name;
	}
	
	public int getIdentifier() {
		return identifier;
	}
	
	public Name getName() {
		return name;
	}

	@Override
	public String toString() {
		return name.toString() + ": " + identifier;
	}
}
