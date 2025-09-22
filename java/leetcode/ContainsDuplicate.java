record Input(int[] nums) {}

void main() {
    Input[] inputs = {
        new Input(new int[] {1, 2, 3, 1}),
        new Input(new int[] {1, 2, 3, 4}),
        new Input(new int[] {1,1,1,3,3,4,3,2,4,2}),
    };

    for (Input i : inputs) {
        var r = containsDuplicate(i.nums);
        System.out.printf("r = %s\n", r);
    }
}

boolean containsDuplicate2(int[] nums) {
    int n = nums.length;

    java.util.Arrays.sort(nums);

    for (int i = 1; i < n; i++) {
        if (nums[i - 1] == nums[i]) {
            return true;
        }
    }

    return false;
}

boolean containsDuplicate(int[] nums) {
    int n = nums.length;
    Set<Integer> found = new HashSet<Integer>();

    for (int num : nums) {
        if (found.contains(num)) {
            return true;
        }

        found.add(num);
    }

    return false;
}
