package DataStructure;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

/**
 * http://blog.csdn.net/fightforyourdream/article/details/18332799
 * */
public class Trie {
  TrieNode root;

  public Trie() {
	 root = new TrieNode((char) 0);
  }

  public void printTree() {
	 Queue<TrieNode> stack = new LinkedList<>();
	 stack.add(root);
	 while (!stack.isEmpty()) {
		TrieNode cur = stack.poll();
		// System.out.println("adsf");
		System.out.println(cur.letter);
		Map<Character, TrieNode> children = cur.children;
		if (children != null) {
		  for (TrieNode tn : children.values()) {
			 stack.add(tn);
		  }
		}
	 }
  }

  public void insert(String word) {
	 if (word == null || word.length() == 0) {
		return;
	 }
	 TrieNode cur = root;
	 for (int i = 0; i < word.length(); i++) {
		if (cur.children == null) {
		  cur.children = new HashMap<>();
		}
		Map<Character, TrieNode> children = cur.children;
		char c = word.charAt(i);
		if (!children.containsKey(c)) {
		  TrieNode tn = new TrieNode(c);
		  children.put(c, tn);
		}
		cur = children.get(c);
	 }
	 cur.isEnd = true;
  }

  public boolean contains(String word) {
	 TrieNode cur = root;
	 for (int i = 0; i < word.length(); i++) {
		char c = word.charAt(i);
		Map<Character, TrieNode> children = cur.children;
		if (children == null || !children.containsKey(c)) {
		  return false;
		}
		cur = children.get(c);
	 }
	 return cur.isEnd;
  }

  class TrieNode {
	 char letter;
	 Map<Character, TrieNode> children;
	 boolean isEnd = false;
	 
	 int occurency; // increment when node is visited

	 public TrieNode(char let) {
		letter = let;
	 }
  }

  
  /**Problem specific: find the minimum prefix represent word in a word dictionay 
   * 
   * */
  public String findMinPrefix(String word) {
	 StringBuilder sb = new StringBuilder();
	 TrieNode cur = root;
	 
	 for (int i = 0; i < word.length(); i++) {
		Map<Character, TrieNode> children = cur.children;
		char c = word.charAt(i);
		if (children == null || !children.containsKey(c)) {
		  return sb.toString();
		}
		cur = children.get(c);
		sb.append(c);
		if (cur.occurency == 1) {
		  return sb.toString();
		}
	 }
	 return sb.toString();
  }
	 
  public static void main(String[] args) {
	 String s = "ilovecode";
	 String s1 = "catcatdog";
	 Trie tree = new Trie();
	 tree.insert(s);
	 tree.insert(s1);
	 tree.printTree();
  }

}