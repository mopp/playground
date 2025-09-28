public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

void main() {
}

// 回答を見たやつ
// 配列ではないので詰める必要はなかった...
public void deleteNode(ListNode node) {
    node.val = node.next.val;
    node.next = node.next.next;
}

public void deleteNode(ListNode node) {
    while (true) {
        node.val = node.next.val;

        // 削除した分の node を参照不可にする
        if (node.next.next == null) {
            node.next = null;
            break;
        }

        node = node.next;
    }
}
