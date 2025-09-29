void main() {
    System.out.printf("%s\n", letterCombinations("23"));
    System.out.printf("%s\n", letterCombinations("2"));
    System.out.printf("%s\n", letterCombinations(""));
}

// 回答を見たあとに書いたもの
private static final Map<Character, String> KEYPAD = new HashMap<>() {{
    put('2', "abc");
    put('3', "def");
    put('4', "ghi");
    put('5', "jkl");
    put('6', "mno");
    put('7', "pqrs");
    put('8', "tuv");
    put('9', "wxyz");
}};

List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();

    if (0 < digits.length()) {
        backtrack(result, new StringBuilder(), digits, 0);
    }

    return result;
}

void backtrack(List<String> result, StringBuilder current, String digits, int index) {
    if (index == digits.length()) {
        result.add(current.toString());
        return;
    }

    String letters = KEYPAD.get(digits.charAt(index));
    for (char ch : letters.toCharArray()) {
        current.append(ch);
        backtrack(result, current, digits, index + 1);
        current.deleteCharAt(current.length() - 1);
    }
}

Map<String, String[]> LETTERS_BY_NUMBER = new HashMap<>() {{
    put("2", new String[]{"a", "b", "c"});
    put("3", new String[]{"d", "e", "f"});
    put("4", new String[]{"g", "h", "i"});
    put("5", new String[]{"j", "k", "l"});
    put("6", new String[]{"m", "n", "o"});
    put("7", new String[]{"p", "q", "r", "s"});
    put("8", new String[]{"t", "u", "v"});
    put("9", new String[]{"w", "x", "y", "z"});
}};

List<String> letterCombinations2(String digits) {
    Deque<String> queue = new LinkedList<>();

    if (1 <= digits.length()) {
        var digit = digits.substring(0, 1);
        var letters = LETTERS_BY_NUMBER.get(digit);
        for (var l : letters) {
            queue.addLast(new String(l));
        }
    }

    for (int k = 1; k < digits.length(); k++) {
        var digit = digits.substring(k, k + 1);
        var letters = LETTERS_BY_NUMBER.get(digit);

        var length = queue.size();
        for (int i = 0; i < length; i++) {
            String s = queue.removeFirst();
            for (var l : letters) {
                queue.addLast(s.concat(new String(l)));
            }
        }
    }

    return new ArrayList(queue);
}
