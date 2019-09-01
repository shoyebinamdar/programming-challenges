package codility;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Pattern;

public class WordMachine {
  public static final int MAX = 0xFFFFF;
  public static final int MIN = 0;
  private final Stack<Integer> stack = new Stack<>();
  private static final Pattern NUMERIC = Pattern.compile("\\d+");
  private static final Map<String, Runnable> operations = new HashMap<>();
  {
      operations.put("DUP", this::dup);
      operations.put("POP", this::pop);
      operations.put("+", this::add);
      operations.put("-", this::sub);
  }

  public int processor(String words) {
    try {
        Arrays.stream(words.split(" ")).forEach(this::applyCommand);
        return pop();
    } catch (IllegalArgumentException e) {
        return -1;
    }
  }

  private void applyCommand(String command) {
      if (NUMERIC.matcher(command).matches())
          push(Integer.valueOf(command));
      else
          operations.get(command).run();
  }

  private void push(Integer value) {
      isValidNumber(value);
      stack.push(value);
  }

  private Integer pop() {
    return stack.pop();
  }

  private void dup() {
    hasElements(1);
    push(stack.peek());
  }

  private void add() {
      hasElements(2);
      push(stack.pop() + stack.pop());
  }

  private void sub() {
      hasElements(2);
      push(stack.pop() - stack.pop());
  }

  private void hasElements(int i) {
    if (stack.size() < i) {
      throw new IllegalArgumentException("Too few elements available");
    }
  }

  private void isValidNumber(Integer value) {
    if (value < MIN || value > MAX) {
      throw new IllegalArgumentException("Input underflow/overflow");
    }
  }
}
