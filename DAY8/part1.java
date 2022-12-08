import java.util.*;
import java.io.*;
public class part1 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();
		List<List<Integer>> matrix = new ArrayList<>();
		while(line!=null) {
			char [] arr = line.toCharArray();
			List<Integer> row = new ArrayList<>();
			for(char c:arr) {
				row.add(Integer.parseInt(String.valueOf(c)));
			}
			matrix.add(row);
			line=br.readLine();
		}
		int row = matrix.size();
		int col = matrix.get(0).size();
		int sum=(row*2)+(col*2)-4;
		for(int i=1;i<row-1;i++) {
			for(int j=1;j<col-1;j++) {
				int val=matrix.get(i).get(j);
				if(val!=0) {
					int max;
					max = findMax(i, 0, j-1, matrix, 0); //left
					if (max<val) {
						++sum;
						continue;
					}
					max=findMax(i, j+1, col-1, matrix, 0); // right
					if (max<val) {
						++sum;
						continue;
					}
					max=findMax(j, 0, i-1, matrix, 1); // top
					if (max<val) {
						++sum;
						continue;
					}
					max=findMax(j, i+1, row-1, matrix, 1); // down
					if (max<val) {
						++sum;
					}
				}
			}
		}
		System.out.println("SUM "+ sum);
	}

	static int findMax(int f, int s, int e, List<List<Integer>> matrix, int fix) {
		int max=-1;
		if(fix==0) { //row fixed
			for(int i=s;i<=e;i++){
				if(max < matrix.get(f).get(i))
					max=matrix.get(f).get(i);
			}
		}
		else if(fix==1) { // col fixed
			for(int i=s; i<=e;i++){
				if(max < matrix.get(i).get(f))
					max=matrix.get(i).get(f);
			}
		}
		return max;
	}
}