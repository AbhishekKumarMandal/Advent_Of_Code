import java.util.*;
import java.io.*;
public class part1 {
	public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	String line = br.readLine();

		while(line != null) {
			int i=0;
			int len = line.length();
			char [] arr = line.toCharArray();
			while(i<=(len-4)) {
				Set<Character> s = new HashSet<>();
				s.add(arr[i]);
				s.add(arr[i+1]);
				s.add(arr[i+2]);
				s.add(arr[i+3]);
				if(s.size()==4) {
					System.out.println("found at "+ (i+4));
					break;
				}
				i++;
			}
			line=br.readLine();
		}
	}
}