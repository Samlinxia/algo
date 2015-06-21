package google;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import data_structure.Trie;

/**
 * http://www.weibo.com/p/1001603769565157971455?feed_filter=1#1415151878988
 * */
public class ShortedPrefix {

  /**
   * Problem specific: find the minimum prefix represent word in a word
   * dictionary
   * 
   * */
  public Map<String, String> findMinPrefix(List<String> words) {
	 Map<String, String> res = new HashMap<>();
	 Trie tree = new Trie();
	 for (String s : words) {
		tree.insert(s);
	 }

	 for (String s : words) {
		String prefix = tree.findMinPrefix(s);
		res.put(prefix, s);
	 }
	 return res;
  }

}
