package basic.file;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileCopy {

	public static void main(String[] args) throws IOException {
		File src = new File("C:\\Windows\\explorer.exe");
		File dest = new File("C:\\Temp\\my_expl.exe");
		
		BufferedInputStream bis = new BufferedInputStream(new FileInputStream(src));
		BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(dest));
		
		int c;
		
		while((c = bis.read()) != -1) {
			bos.write((char)c);
		}
		System.out.println("복사 완료!");
		bos.close();
		bis.close();
	}

}
