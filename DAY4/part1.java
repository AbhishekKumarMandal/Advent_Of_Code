public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	String line = br.readLine();
	int sum=0;
	while(line!=null) {
		String [] arr = line.split(",");
		String s1=arr[0];
		String s2=arr[1];
		String [] arr1 = s1.split("-");
		String [] arr2 = s2.split("-");
		int start1 = Integer.parseInt(arr1[0]);
		int end1 = Integer.parseInt(arr1[1]);
		int start2 = Integer.parseInt(arr2[0]);
		int end2 = Integer.parseInt(arr2[1]);

		if(start2>=start1 && end2<=end1) {
			++sum;
		} else if(start1>=start2 && end1<=end2) {
			++sum;
		}

		line=br.readLine();
	}
	System.out.println("SUM "+ sum);
}