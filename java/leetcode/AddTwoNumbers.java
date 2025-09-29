public class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 先頭への参照を持つだけの番兵的な存在
        ListNode head = new ListNode();
        ListNode tail = head;

        int carry = 0;
        while (l1 != null || l2 != null) {
            var x = 0;
            if (l1 != null) {
                x = l1.val;
                l1 = l1.next;
            }

            var y = 0;
            if (l2 != null) {
                y = l2.val;
                l2 = l2.next;
            }

            // digit = sum % 10;
            // carry = sum / 10;
            // 乗算、剰余算の方が遅いような気もする
            // 現代だと気にしなくていいレベルな気もする
            var digit = x + y + carry;
            if (10 <= digit) {
                digit -= 10;
                carry = 1;
            } else {
                carry = 0;
            }

            tail.next = new ListNode(digit, null);
            tail = tail.next;
        }

        if (carry != 0) {
            tail.next = new ListNode(carry, null);
        }

        // 先頭は無意味なノードなので捨てる
        // ただし、参照不可にしてGC 可能にしておく
        var r = head.next;
        head.next = null;

        return r;
    }
}
