package basic.file;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FileWriterEx {

	public static void main(String[] args) throws IOException {
		InputStreamReader isr = new InputStreamReader(System.in);
		FileWriter fw = new FileWriter("C:\\Temp\\my.txt");
		int c = 0;
		while((c = isr.read()) != -1) {
			fw.write(c);
		}
		fw.close();
		isr.close();
	}

}
