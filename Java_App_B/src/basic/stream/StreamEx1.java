package basic.stream;

import java.util.stream.Stream;

public class StreamEx1 {

	public static void main(String[] args) {
		// 1. 컬렉션 객체로 부터 스트림을 생성
		String[] strArr = {"aa", "bb", "cc", "dd"};
		Stream<String> strStream = Stream.of(strArr);
		
		
		// 2. 스트림 객체에 대한 중간 연산
		//strStream.sorted();
		//strStream.filter(null);
		
		// 3. 스트림 최종 연산
		strStream.forEach(System.out::println);
		
		strStream = Stream.of(strArr);
		long cnt = strStream.count();
		System.out.println(cnt);
		
	}

}
