record Input(char[] s) {}

void main() {
    Input[] inputs = {
        new Input(new char[] {'h','e','l','l','o'}),
        new Input(new char[] {'H','a','n','n','a','h'}),
        new Input(new char[] {'A',' ','m','a','n',',',' ','a',' ','p','l','a','n',',',' ','a',' ','c','a','n','a','l',':',' ','P','a','n','a','m','a'}),
    };

    for (var i : inputs) {
        System.out.printf("%s\n", Arrays.toString(i.s));
        reverseString(i.s);
        System.out.printf("%s\n", Arrays.toString(i.s));
    }
}

// NOTE: 回答を見てから書いたもの
void reverseString(char[] s) {
    int left = 0;
    int right = s.length - 1;

    while (left < right) {
        // Swap
        char t = s[left];
        s[left] = s[right];
        s[right] = t;

        left++;
        right--;
    }
}

void reverseString2(char[] s) {
    int n = s.length - 1;
    int p = s.length / 2;

    for (int i = 0; i < p; i++) {
        // swap
        char t = s[i];
        s[i] = s[n - i];
        s[n - i] = t;
    }
}
