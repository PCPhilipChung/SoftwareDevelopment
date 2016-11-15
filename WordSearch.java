import java.util.Scanner;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;

public class WordSearch {

	public WordSearch(String filename){
		BufferedReader in = null;
		PrintWriter out = null;
		try{
			System.out.println("Loading file...");
			in = new BufferedReader(new FileReader(new File(filename)));
			out = new PrintWriter(new FileWriter(new File("file1")));
			
			int count = 0;
			String s = null;
			String[] word = null;
			Scanner scan = new Scanner(System.in);
			String line = null;
	
			//Count lines
			while((s = in.readLine())!=null){
				System.out.println(s);
				if(s!=null){
					line = s;
					count++;
				}
			}
			in = new BufferedReader(new FileReader(new File(filename)));
			
			word = (line!=null) ? line.split(" ") : null;
			
			System.out.println("Enter your word : ");
			line = scan.nextLine();
			
			count = 0;
			
			char delimiter;
			out.println("Your Result: ");
			for(int i = 0; i < word.length;i++){
				delimiter = word[i].charAt(word[i].length()-1);
				/*if(word[i].substring(word[i].length()-1).equals(",")){
					word[i] = word[i].replace(",", "");
				}
				*/
				//Remove any non alphanumeric
				if(!Character.isLetter(delimiter)){
					word[i] = word[i].replace(delimiter, ' ');
					word[i] = word[i].trim();
				}
				//Takes all strings
				if(word[i].toUpperCase().equals(line.toUpperCase())){
					count++;
					out.println(word[i]);
				}
				
			//	System.out.println(word[i].substring(word[i].length()-1));
			}
			System.out.println("Found: " + count);
			if(out!=null){
				out.close();
			}
			if(in!=null){
				in.close();
			}
			
		}catch(IOException e){
			System.out.println(e);
		}
		
		
	
	}
	public static void main(String[]args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter file destination");
		
		String file = in.nextLine();
		WordSearch s = new WordSearch(file);
		in.close();
	
	}
}
