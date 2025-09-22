record Input(int k, int[] nums) {}

void main() {
    Input[] inputs = {
        new Input(3, new int[] {1,2,3,4,5,6,7}),
        new Input(2, new int[] {-1,-100,3,99}),
        new Input(2, new int[] {-1}),
        new Input(7, new int[] {1,2}),
    };

    for (Input i : inputs) {
        rotate(i.nums, i.k);
        System.out.printf("num = %s\n", Arrays.toString(i.nums));
    }
}

void rotate(int[] nums, int k) {
    int n = nums.length;
    k = k % n;

    reverse(nums, 0, n - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, n - 1);
}

void reverse(int[] nums, int start, int end) {
    while(start < end) {
        int t = nums[start];
        nums[start] = nums[end];
        nums[end] = t;

        start++;
        end--;
    }
}

void rotate_first_accepted(int[] nums, int k) {
    int n = nums.length;

    k = k % n;

    int[] arr = new int[k];

    for (int i = 0; i < k; i++) {
        arr[i] = nums[n - k + i];
    }

    for (int i = n - 1; k <= i; i--) {
        nums[i] = nums[i - k];
    }

    for (int i = 0; i < k; i++) {
        nums[i] = arr[i];
    }
}
