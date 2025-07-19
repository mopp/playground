//! XOR linked list
//! See https://ja.wikipedia.org/wiki/XOR%E9%80%A3%E7%B5%90%E3%83%AA%E3%82%B9%E3%83%88

const std = @import("std");

const Node = struct {
    link: usize,
    val: usize,
};

const Listener = *const fn (val: usize) void;
const XorLinkedList = struct {
    // It's link always has 0 ^ next_node_addr.
    // 0 is sentinel.
    head: ?*Node = null,
    len: usize = 0,

    pub fn init() XorLinkedList {
        return XorLinkedList{};
    }

    pub fn length(self: *XorLinkedList) usize {
        return self.len;
    }

    // Push the given Node at the head.
    pub fn push(self: *XorLinkedList, new: *Node) void {
        if (self.head == null) {
            self.head = new;
            self.len += 1;
        } else {
            const old_head = self.head.?;

            // new -> old_head
            new.link = 0 ^ @intFromPtr(old_head);

            // The head.link has 0 ^ next_addr
            const next_addr = 0 ^ old_head.link;
            old_head.link = @intFromPtr(new) ^ next_addr;

            self.head = new;
            self.len += 1;
        }
    }

    // Traverse from the head to the tail.
    pub fn traverse(self: *XorLinkedList, fnListener: Listener) void {
        if (self.len == 0) {
            return;
        }

        var prev_addr: usize = 0;
        var curr: *Node = self.head.?;
        while (true) {
            fnListener(curr.val);

            const next_addr = curr.link ^ prev_addr;
            if (next_addr == 0) {
                break;
            }

            prev_addr = @intFromPtr(curr);
            curr = @ptrFromInt(next_addr);
        }
    }
};

const expect = std.testing.expect;
test XorLinkedList {
    // Initialize
    var nodes: [32]Node = undefined;
    for (&nodes, 0..) |*node, i| {
        node.link = 0;
        node.val = 100 + i;
    }

    var list = XorLinkedList.init();
    list.push(&nodes[0]);
    list.push(&nodes[1]);
    list.push(&nodes[2]);
    try expect(list.length() == 3);

    const printer = struct {
        fn print(v: usize) void {
            std.debug.print("value = {}\n", .{v});
        }
    };

    list.traverse(printer.print);
}
