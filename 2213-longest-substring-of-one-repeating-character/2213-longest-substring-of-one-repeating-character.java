class Solution {
    static class Node {
        int max, prefix, suffix;
        char leftChar, rightChar;
        int len;

        Node(char c) {
            this.max = 1;
            this.prefix = 1;
            this.suffix = 1;
            this.leftChar = c;
            this.rightChar = c;
            this.len = 1;
        }

        Node() {}
    }

    Node[] seg;

    public Node merge(Node left, Node right) {
        Node res = new Node();
        res.len = left.len + right.len;
        res.leftChar = left.leftChar;
        res.rightChar = right.rightChar;

        res.max = Math.max(left.max, right.max);
        res.prefix = left.prefix;
        res.suffix = right.suffix;

        if (left.rightChar == right.leftChar) {
            res.max = Math.max(res.max, left.suffix + right.prefix);

            if (left.prefix == left.len) {
                res.prefix = left.len + right.prefix;
            }
            if (right.suffix == right.len) {
                res.suffix = right.len + left.suffix;
            }
        }

        return res;
    }

    public void build(int idx, int l, int r, String s) {
        if (l == r) {
            seg[idx] = new Node(s.charAt(l));
            return;
        }
        int mid = l + (r - l) / 2;
        build(2 * idx + 1, l, mid, s);
        build(2 * idx + 2, mid + 1, r, s);
        seg[idx] = merge(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    public void update(int idx, int l, int r, int pos, char val) {
        if (l == r) {
            seg[idx] = new Node(val);
            return;
        }
        int mid = l + (r - l) / 2;
        if (pos <= mid) {
            update(2 * idx + 1, l, mid, pos, val);
        } else {
            update(2 * idx + 2, mid + 1, r, pos, val);
        }
        seg[idx] = merge(seg[2 * idx + 1], seg[2 * idx + 2]);
    }

    public int getMaxConsecutive() {
        return seg[0].max;
    }

    public int[] longestRepeating(String s, String queryCharacters, int[] queryIndices) {
        int n = s.length();
        seg = new Node[4 * n];
        build(0, 0, n - 1, s);

        int[] ans = new int[queryIndices.length];
        for (int i = 0; i < queryIndices.length; i++) {
            int pos = queryIndices[i];
            char val = queryCharacters.charAt(i);
            update(0, 0, n - 1, pos, val);
            ans[i] = getMaxConsecutive();
        }
        return ans;
    }
}