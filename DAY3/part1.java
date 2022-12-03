public static void main(String[] args) throws IOException {
	BufferedReader br = new BufferedReader(new FileReader("input.txt"));
	String line = br.readLine();
	int sum=0;
	while(line!=null) {
		int len = line.length();
		int half = len/2;
		char [] s1 = line.substring(0, half).toCharArray();
		char [] s2 = line.substring(half, len).toCharArray();
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		for(int i=0;i<half;i++) {
			set1.add(s1[i]);
			set2.add(s2[i]);
		}
		for(Character c : set1) {
			if(set2.contains(c)) {
				if(Character.isUpperCase(c)) {
					sum+=((c-'A')+27);
				} else {
					sum+=((c-'a')+1);
				}
			}
		}
		line=br.readLine();
	}
	System.out.prinln("SUM {}", sum);
}