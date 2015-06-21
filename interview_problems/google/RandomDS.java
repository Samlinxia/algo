package google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**Implement a data structure that add, remove, query 
 * and getRandom time is all O(1)
 * 
 * */
public class RandomDS <V>{
  Map<V, Integer> map = new HashMap<>();
  List<V> list = new ArrayList<>();
  
  public RandomDS() {
  
  }
  
  public void add(V val) {
	 list.add(val);
	 map.put(val, list.size() - 1);
  }

  public void delete(V val) {
	 int index = map.get(val);
	 Collections.swap(list, index, list.size() - 1);
	 list.remove(list.size() - 1);
	 map.remove(val);
  }
  
  public boolean contains(V val) {
	 return map.containsKey(val);
  }
  
  public V getRandom() {
	 int index = (int) (Math.random() * list.size());
	 return list.get(index);
  }
}
