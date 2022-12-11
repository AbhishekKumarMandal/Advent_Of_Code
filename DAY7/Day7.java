import java.util.*;
import java.io.*;
public class Day7 {
	static class Node {
		String name;
		int size;
		List<Node> children;
		Node parent;
		Node() {
			this.size=0;
			this.children = new ArrayList<>();
			this.parent=null;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("input.txt"));
		String line = br.readLine();
		Stack<Node> dirStack = new Stack<>();
		Node startNode = null;
		while(line!=null) {
			String [] s = line.split(" ");
			if(s[0].equals("$")) {
				if(s[1].equals("cd")) {
					if(!s[2].equals("..")) {
						if(dirStack.empty()) {
							Node node = new Node();
							node.name = s[2];
							dirStack.push(node);
							startNode=node;
						} else {
							Node parentNode = dirStack.peek();
							List<Node> children = parentNode.children;
							boolean found=false;
							for(Node node : children) {
								if(node.name.equals(s[2])) {
									//node.parent=parentNode;
									dirStack.push(node);
									found=true;
									break;
								}
							}
							if(!found) {
								Node node = new Node();
								node.name = s[2];
								node.parent=parentNode;
								parentNode.children.add(node);
								dirStack.push(node);
							}
						}
					} else {
						dirStack.pop();
					}
				}
				else if(s[1].equals("ls")) {
					Node parentNode = dirStack.peek();
					line = br.readLine();
					while(line!=null) {
						s = line.split(" ");
						String nam;
						if(!s[0].equals("$")) {
							nam = s[1];
							boolean found=false;
							for(Node child : parentNode.children) {
								if(child.name.equals(nam)) {
									found=true;
									break;
								}
							}
							if(!found) {
								Node node = new Node();
								node.name = nam;
								node.parent=parentNode;
								if(!s[0].equals("dir"))
									node.size=Integer.parseInt(s[0]);
								parentNode.children.add(node);
							}
							line = br.readLine();
						}
						else {
							break;
						}
					}
					continue;
				}
			}
			line=br.readLine();
		}
		// inorder traversal function;
		int finalSum=0, total=0;
		int[] arr = new int[]{finalSum};
		if(startNode!=null) {
			total = inOrder(startNode, arr);
			System.out.println("PART1 total disk used " + total + " sum of directories having size<=100000 " + arr[0]);

			// inorder() must be executed once before executing part2.
			int spaceRequiredForUpdate = 30000000 - (70000000 - total);
			System.out.println("Space required for update " + spaceRequiredForUpdate);
			int[] arr1 = new int[1];
			arr1[0] = Integer.MAX_VALUE;
			inorderTraverse(startNode, spaceRequiredForUpdate, arr1);
			System.out.println("PART2 Extra space to be deleted "+ arr1[0]);
		}
	}

	static int inOrder(Node head, int[] arr) {
		if (!head.children.isEmpty()) {
			for (Node child : head.children) {
				head.size += inOrder(child, arr);
			}
			if(head.size<=100000) {
				//int prev = arr[0];
				arr[0] += head.size;
				//System.out.println("Dir "+head.name+" size "+ head.size+" prev sum "+prev+" new sum "+arr[0]);
			}
		}

		return head.size;
	}

	static void inorderTraverse(Node head, int spaceRequiredForUpdate, int[] arr) {
		if(!head.children.isEmpty()) {
			if(head.size>spaceRequiredForUpdate) {
				if(arr[0]> head.size)
					arr[0] = head.size;
			}
			for(Node child : head.children) {
				inorderTraverse(child, spaceRequiredForUpdate, arr);
			}
		}
	}
}