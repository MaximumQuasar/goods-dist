package assignment;

import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.FileOutputStream;
public class resource{
	public InputStreamReader InputFile() throws IOException{
		return new InputStreamReader(this.getClass().getClassLoader().getResourceAsStream("input.txt"));
	}
	
	public PrintWriter OutputFile() throws IOException{
		return  new PrintWriter(new FileOutputStream("output.txt"), true);
	}
}