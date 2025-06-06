package basic.file;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileInputStreamEx {

	public static void main(String[] args) throws IOException {
		FileInputStream fileInputStream = null;
		/*
		 * try { fileInputStream = new FileInputStream("C:\\Windows\\system.ini");
		 * 
		 * fileInputStream.read();
		 * 
		 * 
		 * } catch (FileNotFoundException e) { System.out.println("해당 파일을 찾지 못했습니다."); }
		 * catch (IOException e) { System.err.println("파일 입출력시 오류 발생");
		 * e.printStackTrace(); } finally { try { if(fileInputStream != null)
		 * fileInputStream.close(); } catch (IOException e) { e.printStackTrace(); } }
		 */
		fileInputStream = new FileInputStream("C:\\Windows\\system.ini");
		
		int i;
		while((i = fileInputStream.read()) != -1) { // -1 : EOF(end of file)
			System.out.print((char)i);
		}
	}

}
