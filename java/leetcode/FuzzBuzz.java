record Input(int[] nums) {}

void main() {
    System.out.printf("answer = %s\n", fizzBuzz(3));
    System.out.printf("answer = %s\n", fizzBuzz(5));
    System.out.printf("answer = %s\n", fizzBuzz(15));
}

List<String> fizzBuzz(int n) {
    var answer = new ArrayList(n - 1);

    for (int i = 1; i <= n; i++) {
        if (i % 15 == 0) {
            answer.add("FizzBuzz");
        } else if (i % 5 == 0) {
            answer.add("Buzz");
        } else if (i % 3 == 0) {
            answer.add("Fizz");
        } else {
            answer.add(String.valueOf(i));
        }
    }

    return answer;
}

List<String> fizzBuzz2(int n) {
    return IntStream
        .range(1, n + 1)
        .mapToObj(i -> {
            if (i % 15 == 0) {
                return "FizzBuzz";
            } else if (i % 5 == 0) {
                return "Buzz";
            } else if (i % 3 == 0) {
                return "Fizz";
            } else {
                return String.valueOf(i);
            }
        })
        .collect(Collectors.toList());
}
