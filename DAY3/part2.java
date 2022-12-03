public static void main(String[] args) throws IOException {
	List<String> lines = Files.readAllLines(Paths.get("input.txt"), StandardCharsets.UTF_8);
	int len = lines.size();
	int sum=0;
	for(int i=0;i<len;i+=3) {
		char [] s1=lines.get(i).toCharArray();
		char [] s2=lines.get(i+1).toCharArray();
		char [] s3=lines.get(i+2).toCharArray();
		Set<Character> set1 = new HashSet<>();
		Set<Character> set2 = new HashSet<>();
		Set<Character> set3 = new HashSet<>();
		for(char c : s1)
			set1.add(c);
		for(char c : s2)
			set2.add(c);
		for(char c : s3)
			set3.add(c);
		for(char c : set1) {
			if(set2.contains(c) && set3.contains(c)) {
				if(Character.isUpperCase(c)) {
					sum+=((c-'A')+27);
				} else {
					sum+=((c-'a')+1);
				}
			}
		}
	}
	System.out.println("SUM {}", sum);
}