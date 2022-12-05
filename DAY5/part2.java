import java.util.*;
import java.io.*;
import java.lang.*;

public class part2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();
		
		Map<Integer, Stack<Character>> map = new HashMap<>();
		Character [] a1 = new Character[]{'F', 'T', 'C', 'L', 'R', 'P', 'G', 'Q'};
		Stack<Character> s1 = new Stack<>();
		s1.addAll(Arrays.asList(a1));

		Character [] a2 = new Character[]{'N', 'Q', 'H', 'W', 'R', 'F', 'S', 'J'};
		Stack<Character> s2 = new Stack<>();
		s2.addAll(Arrays.asList(a2));

		Character [] a3 = new Character[]{'F', 'B', 'H', 'W', 'P', 'M', 'Q'};
		Stack<Character> s3 = new Stack<>();
		s3.addAll(Arrays.asList(a3));

		Character [] a4 = new Character[]{'V', 'S', 'T', 'D', 'F'};
		Stack<Character> s4 = new Stack<>();
		s4.addAll(Arrays.asList(a4));

		Character [] a5 = new Character[]{'Q', 'L', 'D', 'W', 'V', 'F', 'Z'};
		Stack<Character> s5 = new Stack<>();
		s5.addAll(Arrays.asList(a5));

		Character [] a6 = new Character[]{'Z', 'C', 'L', 'S'};
		Stack<Character> s6 = new Stack<>();
		s6.addAll(Arrays.asList(a6));

		Character [] a7 = new Character[]{'Z', 'B', 'M', 'V', 'D', 'F'};
		Stack<Character> s7 = new Stack<>();
		s7.addAll(Arrays.asList(a7));

		Character [] a8 = new Character[]{'T', 'J', 'B'};
		Stack<Character> s8 = new Stack<>();
		s8.addAll(Arrays.asList(a8));

		Character [] a9 = new Character[]{'Q', 'N', 'B', 'G', 'L', 'S', 'P', 'H'};
		Stack<Character> s9 = new Stack<>();
		s9.addAll(Arrays.asList(a9));

		map.put(1, s1);
		map.put(2, s2);
		map.put(3, s3);
		map.put(4, s4);
		map.put(5, s5);
		map.put(6, s6);
		map.put(7, s7);
		map.put(8, s8);
		map.put(9, s9);


		while(line!=null) {
			String [] s = line.split(" ");
			int no = Integer.parseInt(s[0]);
			int from = Integer.parseInt(s[1]);
			int to = Integer.parseInt(s[2]);
			List<Character> carr = new ArrayList<>();
			for(int i=1;i<=no;i++) {
				Character c = map.get(from).peek();
				carr.add(c);
				map.get(from).pop();
			}
			Collections.reverse(carr);
			map.get(to).addAll(carr);
			line=br.readLine();
		}
		String res = "";
		for(int i=1;i<=9;i++) {
			if(!map.get(i).empty())
				res+=(map.get(i).peek().toString());
		}
		System.out.println("result "+ res);
	}
}