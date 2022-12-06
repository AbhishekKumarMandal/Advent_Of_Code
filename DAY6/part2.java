import java.util.*;
import java.io.*;

public class part2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();

		while(line != null) {
			int i=0;
			int len = line.length();
			while(i<=(len-14)) {
				String substr = line.substring(i, i+14);
				char [] arr = substr.toCharArray();
				Set<Character> s = new HashSet<>();
				for(Character c : arr) {
					s.add(c);
				}
				if(s.size()==14) {
					System.out.println("found at "+ (i+14));
					break;
				}
				i++;
			}
			line=br.readLine();
		}
	}
}