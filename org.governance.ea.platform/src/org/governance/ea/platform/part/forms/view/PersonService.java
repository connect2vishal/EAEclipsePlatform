package org.governance.ea.platform.part.forms.view;

import java.util.ArrayList;
import java.util.List;

public class PersonService {

	private List<Person> personList;

	public List<Person> getPersons(int noOfPerson) {
		return personList;
		
//		personList = new ArrayList<Person>();
//		for(int i=0; i<noOfPerson; i++){
//			personList.add(new Person("name"+i, "Male", 30+i));
//		}
//		return personList;
	}

}
