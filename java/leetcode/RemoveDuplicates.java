void main() {
    int[] nums = {0,0,1,1,1,2,2,3,3,4}; // Input array
    // int[] nums = {0,0}; // Input array

    int k = removeDuplicates(nums); // Calls your implementation

    System.out.printf("k = %d\n", k);
    for (int i = 0; i < k; i++) {
        System.out.printf("%d,", nums[i]);
    }
}

int removeDuplicates(int[] nums) {
    int k = 0;

    for (int i = 1; i < nums.length; i++) {
        if (nums[k] != nums[i]) {
            nums[k + 1] = nums[i];
            k++;
        }
    }

    return k;
}

int removeDuplicates_first_accepted(int[] nums) {
    int len = nums.length;
    int i = 0;

    while (i < len - 1) {
        if (nums[i] == nums[i + 1]) {
            for (int j = i; j < len - 1; j++) {
                nums[j] = nums[j + 1];
            }
            len -= 1;
        } else {
            i++;
        }
    }

    return len;
}
