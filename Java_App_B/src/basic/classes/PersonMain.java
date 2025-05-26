package basic.classes;

public class PersonMain {

	public static void main(String[] args) {
		
		Name name = new Name("홍", "길동");
		Address address = new Address("인천 미추홀구", "인하로 100");
		
		Person person = new Person(name, 10, address);
		System.out.println(person);
		
		/*
		 * Name name2 = person.getName(); String firstName = name2.getFirstName();
		 */
		String firstName = person.getName().getFirstName();
		
		System.out.println(firstName);
		
		person.getName().setFirstName("김");
		System.out.println(person);
		
		person.getAddr().setDetail("인하로 200");
		System.out.println(person);
	}

}