record Input(int[] nums1, int m, int[] nums2, int n) {}

void main() {
    Input[] inputs = {
        new Input(new int[] {1, 2, 3, 0, 0, 0}, 3, new int[] {2, 5, 6}, 3),
        new Input(new int[] {1}, 1, new int[] {}, 0),
        new Input(new int[] {0}, 0, new int[] {1}, 1),
    };

    for (Input i : inputs) {
        merge(i.nums1, i.m, i.nums2, i.n);
        System.out.printf("The result: %s\n", Arrays.toString(i.nums1));
    }
}

// 他の回答を見てから書いたもの
void merge(int[] nums1, int m, int[] nums2, int n) {
    int k = m + n - 1;
    int i1 = m - 1;
    int i2 = n - 1;

    // num2 をコピー完了したらもうループしなくてよい
    // num1 はすでに sort 済みなのでそれ以上チェックする意味がない
    while(0 <= i2) {
        if (i1 < 0 || nums1[i1] < nums2[i2]) {
            // i1 < 0 は nums1 をコピーしきったときを意味する
            // nums2 の残りをコピーしてしまう
            nums1[k] = nums2[i2--];
        } else {
            nums1[k] = nums1[i1--];
        }
        k--;
    };
}

// O(m + n)
void merge3(int[] nums1, int m, int[] nums2, int n) {
    int k = m + n - 1;
    int i1 = m - 1;
    int i2 = n - 1;

    while(0 <= k) {
        if (i1 < 0) {
            nums1[k] = nums2[i2--];
        } else if (i2 < 0) {
            nums1[k] = nums1[i1--];
        } else if (nums1[i1] < nums2[i2]) {
            nums1[k] = nums2[i2--];
        } else {
            nums1[k] = nums1[i1--];
        }
        k--;
    };
}

// O(m) + O(m + n)
void merge2(int[] answer, int m, int[] nums2, int n) {
    int[] nums1 = Arrays.copyOf(answer, m);

    int k = 0;
    int i1 = 0;
    int i2 = 0;
    while(k < m + n) {
        if (i1 == m) {
            answer[k] = nums2[i2++];
        } else if (i2 == n) {
            answer[k] = nums1[i1++];
        } else if (nums1[i1] < nums2[i2]) {
            answer[k] = nums1[i1++];
        } else {
            answer[k] = nums2[i2++];
        }

        k++;
    }
}

// O(n) + O((m + n)log(m + n))
void merge1(int[] nums1, int m, int[] nums2, int n) {
    for (int i = 0; i < n; i++) {
        nums1[m + i] = nums2[i];
    }

    Arrays.sort(nums1);
}
