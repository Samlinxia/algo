class LinkedListRotate {
	public ListNode rotateRight(ListNode head, int n) {
        if (head == null || n <= 0) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int size = 1;
        while (head.next != null) {
            size++;
        }
        ListNode end = head;
        int step = size - (n % size);
        head = dummy;
        for (int i = 0; i < step; i++) {
            head = head.next;
        }
        end.next = dummy.next;
        dummy.next = head.next;
        head.next = null;
        return dummy.next;
    }
}