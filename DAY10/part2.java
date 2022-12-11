import java.util.*;
import java.io.*;
public class part2 {
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

		for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
			System.out.println(entry.getKey()+" "+entry.getValue());
		}

		for(int i=0;i<6;i++) {
			for(int j=1;j<=40;j++) {
				int index = (40*i)+j;
				int sprite = map.get(index);
				if((j-1)==sprite || (j-1)==(sprite-1) || (j-1)==(sprite+1))
					System.out.print("#");
				else
					System.out.print(".");
			}
			System.out.println();
		}
	}
}