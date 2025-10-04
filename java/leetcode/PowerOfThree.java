void main() {
    long a = 3;
    int j = 1;
    while (a <= Integer.MAX_VALUE) {
        j++;
        a *= 3;
        System.out.println("3^" + j + " = " + a);
    }


    for (var i : new int[]{
        27,
        0,
        -1,
        1,
        19684, // false
        45,     // false
        -3,
        2147483647,
        81,
        243
    }) {
        System.out.println("isPowerOfThree(" + i + ") = " + isPowerOfThree(i));
    }
}

// log 計算の方がループよりもコスト高そうだがどうなんだろう
boolean isPowerOfThree(int n) {
    if (n == 0) {
        reutrn false;
    }

    // n = 3^x
    // x = log3(n)
    // Math に任意の対数の log は無いので
    // 底の変換公式により
    // x = log3(n) = loge(n) / loge(3)
    var x = Math.log(n) / Math.log(3);

    // 小数部が0ならOK で判定しようとしたが浮動小数点の都合上
    // log3(243) = 5 だが 4.999999 となってしまう
    // return (x - Math.floor(x)) < 1e-10;

    // n を再現できるか、で判定する
    return Math.pow(3, Math.round(x)) == n;
}

// 回答を見てから書いたもの
boolean isPowerOfThree3(int n) {
    if (n <= 0) {
        return false;
    }

    while (1 < n) {
        if (n % 3 == 0) {
            n /= 3;
        } else {
            return false;
        }
    }

    return true;
}

boolean isPowerOfThree2(int n) {
    // int の範囲の3の累乗を事前に計算しておく
    var nums = new int[]{
        1,
        3,
        9,
        27,
        81,
        243,
        729,
        2187,
        6561,
        19683,
        59049,
        177147,
        531441,
        1594323,
        4782969,
        14348907,
        43046721,
        129140163,
        387420489,
        1162261467
    };

    for (var i : nums) {
        if (i == n) {
            return true;
        }
    }

    return false;
}
