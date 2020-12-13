package assignment;

import java.util.Collections;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import assignment.*;

public class start{
	public static void main(String arg[]){	
		resource res=new resource();
		
		try(BufferedReader in=new BufferedReader(res.InputFile())){
			int n=Integer.parseInt(in.readLine().split(": ")[1]);

			String line="";
			int count=0;
			ArrayList<Item> itemsList=new ArrayList<Item>();
			while((line=in.readLine())!=null){
				if(count>2){
					itemsList.add(itemParser.parse(line.trim()));
				}
				count++;
			}
			Collections.sort(itemsList);
			proc process=new proc(itemsList,res);
			process.run(n);
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}

}