public class ListNode {
    int val;
    ListNode next;

    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    ListNode() {}
}

void main() {
}

ListNode removeNthFromEnd(ListNode head, int n) {
    var fast = head;
    var slow = head;
    int len = 1;

    // 終端からn個前を削除したいので
    // fast がn個辿ってから追いかける
    while (fast.next != null) {
        fast = fast.next;
        if (n < len++) {
            slow = slow.next;
        }
    }

    if (len == n) {
        // head が削除対象のとき
        return head.next;
    }

    slow.next = slow.next.next;
    return head;
}

ListNode removeNthFromEnd(ListNode head, int n) {
    int len = 0;
    var node = head;
    do {
        len++;
        node = node.next;
    } while (node != null);

    if (len == 1) {
        return null;
    }

    if (len == n) {
        // head が削除対象のとき
        return head.next;
    } else {
        len = len - n - 1;
        node = head;
        while(0 < len--) {
            node = node.next;
        }

        node.next = node.next.next;
    }

    return head;
}
