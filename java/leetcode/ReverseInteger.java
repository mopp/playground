void main() {
    for (var i : new int[] {123, -123, 120, 1534236469}) {
        System.out.println("reverse(" + i + ") = " + reverse(i));
    }
}

// 回答を見てから書いたもの
// int のみでやる方法
// CPU に Overflow flag あるので、こういうのは自前で書かないのが一番だと思う
// https://en.wikipedia.org/wiki/FLAGS_register
int reverse(int x) {
    int a = 0;

    while (x != 0) {
        // 0~9 の範囲しか取らない
        // 剰余なので常に符号が維持される
        var lastDigit = x % 10;

        // MAX_VALUE = 2147483647
        // 214748364 < a || (214748364 == a && 7 < lastDigit)
        if (Integer.MAX_VALUE / 10 < a || (Integer.MAX_VALUE / 10 == a && 7 < lastDigit)) {
            return 0;
        }
        // MIN_VALUE = -2147483648
        // -214748364 > a || (-214748364 == a && -8 > lastDigit)
        if (Integer.MIN_VALUE / 10 > a || (Integer.MIN_VALUE / 10 == a && -8 > lastDigit)) {
            return 0;
        }

        a = (a * 10) + lastDigit;
        x /= 10;
    }

    return a;
}

int reverse2(int x) {
    long a = 0;

    while (x != 0) {
        a = (a * 10) + (x % 10);

        x /= 10;
    }

    if (a <= Integer.MIN_VALUE || Integer.MAX_VALUE <= a) {
        return 0;
    }

    return (int)a;
}
