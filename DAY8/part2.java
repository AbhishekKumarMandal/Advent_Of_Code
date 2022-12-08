import java.util.*;
import java.io.*;

public class part2 {
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
		int max=Integer.MIN_VALUE;
		for(int i=1;i<row-1;i++) {
			for(int j=1;j<col-1;j++) {
				int val=matrix.get(i).get(j);
				int prod=1,res;
				res=sceneLength(i, j-1, 0, matrix, 0, val, true); //left
				prod*=res;

				res=sceneLength(i, j+1, col-1, matrix, 0, val, false); // right
				prod*=res;

				res=sceneLength(j, i-1, 0, matrix, 1, val, true); // top
				prod*=res;

				res=sceneLength(j, i+1, row-1, matrix, 1, val, false); // down
				prod*=res;

				if (prod>max) {
					max=prod;
				}
			}
		}
		System.out.println("SUM "+ max);
	}


	static int sceneLength(int f, int s, int e, List<List<Integer>> matrix, int fix, int val, boolean rev) {
		int sum=0;
		if(fix==0) { //row fixed
			if (!rev) {
				for (int i = s; i <= e; i++) {
					if (matrix.get(f).get(i)>=val) {
						++sum;
						break;
					} else {
						++sum;
					}
				}
			} else {
				for (int i = s; i >= e; i--) {
					if (matrix.get(f).get(i)>=val) {
						++sum;
						break;
					} else  {
						++sum;
					}
				}
			}
		}
		else if(fix==1) { // col fixed
			if (!rev) {
				for (int i = s; i <= e; i++) {
					if (matrix.get(i).get(f)>=val) {
						++sum;
						break;
					} else
						++sum;
				}
			}
			else {
				for (int i = s; i >= e; i--) {
					if (matrix.get(i).get(f)>=val) {
						++sum;
						break;
					} else
						++sum;
				}
			}
		}
		return sum;
	}
}
