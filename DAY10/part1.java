import java.util.*;
import java.io.*;

public class part1 {
	public static void main(String [] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();
		int s=1, x=1;
		Map<Integer, Integer> map = new HashMap<>();
		while(line!=null) {
			String [] commands = line.split(" ");
			if(commands[0].equals("noop")) {
				map.put(s,x);
				++s;
			}
			else if(commands[0].equals("addx")) {
				for(int i=1;i<=2;i++) {
					map.put(s,x);
					++s;
				}
				int num = Integer.parseInt(commands[1]);
				x+=num;
			}
			line = br.readLine();
		}
		int finalSum=0;
		for(int i=20;i<=220;i+=40) {
			if(map.containsKey(i)) {
				finalSum += (i * map.get(i));
				System.out.println(i+" "+ map.get(i)+" "+finalSum);
			}
		}
		System.out.println("SUM "+ finalSum);
	}
}