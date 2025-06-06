package basic.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) {
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream("C:\\Windows\\system.ini");
			System.out.println("정상");
		} catch (FileNotFoundException e) {
			System.out.println("해당 파일을 찾지 못했습니다.");
		} finally {
			try {
				if(fileInputStream != null)
					fileInputStream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
