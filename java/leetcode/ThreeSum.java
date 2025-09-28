record Input(int[] nums) {};

void main() {
    var inputs = new Input[] {
        new Input(new int[]{-1,0,1,2,-1,-4}),
        new Input(new int[]{0, 0, 0}),
    };

    for (var i : inputs) {
        var r = threeSum(i.nums);
        System.out.printf("%s\n", r);
    }

}

// Time Limit Exceeded してしまう
// NlogN + N * N * N よりは小さいはず
// 3000要素で全部値の違うパターンで落ちる
List<List<Integer>> threeSum(int[] nums) {
    Set<List<Integer>> triplets = new HashSet<>();

    Arrays.sort(nums);
    System.out.printf("%s\n", Arrays.toString(nums));

    var length = nums.length;
    for (int i = 0; i < length; i++) {
        Integer x = nums[i];

        for (int j = i + 1; j < length; j++) {
            if (j == i) {
                continue;
            }
            Integer y = nums[j];

            for (int k = j + 1; k < length; k++) {
                if (k == i || k == j) {
                    continue;
                }

                Integer z = nums[k];

                if (x + y + z == 0) {
                    triplets.add(Arrays.asList(new Integer[] { x, y, z }));
                    // これ以降の z は現在よりも大きいものしかないので見る必要がない
                    break;
                }
            }
        }
    }

    return new ArrayList(triplets);
}
