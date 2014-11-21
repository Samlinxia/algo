public class LRUCache {
    private int capacity = 0;
    private int len = 0;
    private Map<Integer, DoubleLinkedListNode> map = null;
    private DoubleLinkedListNode head = null;
    private DoubleLinkedListNode tail = null;
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<Integer, DoubleLinkedListNode>();
        head = new DoubleLinkedListNode();
        tail = new DoubleLinkedListNode();
        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if (len == 0 || !map.containsKey(key)) {
            return -1;
        }
        DoubleLinkedListNode res = map.get(key);
        // move res to head of list
        if (head.next != res) {
            extractMiddle(res);
            insertHead(res);
        }
        return res.val;    
    }
    
    public void set(int key, int value) {
        DoubleLinkedListNode res = null;
        if (map.containsKey(key)) { //move to head of list
            res = map.get(key);
            res.val = value;
            extractMiddle(res);
            insertHead(res);
        } else { //create new node & insert to head
            res = new DoubleLinkedListNode(key, value);
            map.put(key, res);
            insertHead(res);
            len++;
        }
        if (len > capacity) {
            invalidateTail();
            len--;
        }
    }
    
    private void insertHead(DoubleLinkedListNode node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    
    private void invalidateTail() {
        DoubleLinkedListNode lastNode = tail.prev;
        map.remove(lastNode.key);
        tail.prev = lastNode.prev;
        tail.prev.next = tail;
        //lastNode.next = null;
        //lastNode.prev = null;
    }
    
    private void extractMiddle(DoubleLinkedListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    public class DoubleLinkedListNode {
        int key;
        int val;
        DoubleLinkedListNode prev;
        DoubleLinkedListNode next;
        public DoubleLinkedListNode (int k, int v) {
            key = k;
            val = v;
        }
        public DoubleLinkedListNode () {
            
        }
        //double time;
    }
}