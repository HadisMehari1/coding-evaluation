package com.aa.act.interview.org;

import java.util.Collection;
import java.util.Optional;

public abstract class Organization {

	private Position root;
	
	public Organization() {

		root = createOrganization();
	}
	
	protected abstract Position createOrganization();
	
	/**
	 * hire the given person as an employee in the position that has that title
	 * 
	 * @param person
	 * @param title
	 * @return the newly filled position or empty if no position has that title
	 */
	public Optional<Position> hire(Name person, String title) {
		Position position = findPositionByTitle( title, root);
		if (position != null) {
			Optional<Employee> emp = Optional.of(new Employee(000, person));
			position.setEmployee(emp);
			return Optional.of(position);
		}
		return Optional.empty();

	}

	private Position findPositionByTitle( String title, Position position) {
		if (position.getTitle().equals(title)) {
			return position;
		} else {
			Collection<Position> directReports = position.getDirectReports();
			for (Position directReport : directReports) {
				Position positionFound = findPositionByTitle( title, directReport);
				if (positionFound != null) {
					return positionFound;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return printOrganization(root, "");
	}
	
	private String printOrganization(Position pos, String prefix) {
		StringBuffer sb = new StringBuffer(prefix + "+-" + pos.toString() + "\n");
		for(Position p : pos.getDirectReports()) {
			sb.append(printOrganization(p, prefix + "\t"));
		}
		return sb.toString();
	}
}
