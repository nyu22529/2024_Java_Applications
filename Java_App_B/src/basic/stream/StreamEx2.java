package basic.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class StreamEx2 {

	public static void main(String[] args) {
		List<Person> persons = Arrays.asList(
				new Person("홍길동", 20, 1),
				new Person("홍길자", 29, 2),
				new Person("홍길순", 26, 2),
				new Person("홍길석", 27, 1)
				);
		
		System.out.println(persons);
		
		System.out.println("여성 목록1 : ");
		for(Person person : persons) {
			if(person.getGender() == 2) {
				System.out.println(person);
			}
		}
		
		System.out.println("여성 목록2 : ");
		/*
		 * List<Person> fList = persons.stream() .filter((person) -> person.getGender()
		 * == 2) .collect((Collectors.toList()));
		 * 
		 * fList.forEach(System.out::println);
		 */
		persons.stream()
				.filter((person) -> person.getGender() == 2)
				.collect(Collectors.toList())
				.forEach(System.out::println);
		
		System.out.println("젊음 : ");
		List<Person> ageList = persons.stream()
				.sorted(Comparator.comparing(Person::getAge))
				.collect(Collectors.toList());
		
		ageList.forEach(System.out::println);
		
		System.out.println("늙음 : ");
		Optional<Person> oldPerson = persons.stream()
				.max(Comparator.comparing(Person::getAge));
		System.out.println(oldPerson);
		System.out.println(oldPerson.get());
		System.out.println(oldPerson.get().getAge());
		
		System.out.println("남자 / 여자 리스트 출력 : ");
		Map<Integer, List<Person>> group = persons.stream()
				.collect(Collectors.groupingBy(Person::getGender));
		
		group.forEach((gender, pList) -> {
			System.out.println(gender);
			pList.forEach(System.out::println);
		});
	}

}
