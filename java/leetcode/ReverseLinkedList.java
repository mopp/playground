class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

void main() {
    int[] nums = {0,0,1,1,1,2,2,3,3,4}; // Input array
    // int[] nums = {0,0}; // Input array

    int k = reverseList(nums); // Calls your implementation

    System.out.printf("k = %d\n", k);
    for (int i = 0; i < k; i++) {
        System.out.printf("%d,", nums[i]);
    }
}

// 先頭の要素を控えて、次の要素がそれを参照するように入れ替えていく
ListNode reverseList(ListNode head) {
    ListNode p = null;

    while (head != null) {
        var t = head.next;
        head.next = p;

        p = head;
        head = t;
    }

    return p;
}

ListNode reverseList(ListNode head) {
    if (head == null) {
        return null;
    }

    ListNode n = new ListNode(head.val, null);
    head = head.next;

    while (head != null) {
        n = new ListNode(head.val, n);
        head = head.next;
    }

    return n;
}
