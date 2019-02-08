package randomout;

public class Output {
  private static final int DEFAULT_DELAY = 100;

  private static final char[] chars = new char[] {
      'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
      'x', 'y', 'z'
  };

  public static void main(String[] args) {
    int c = 0;
    while (!Thread.interrupted()) {
      int lineLength = (int) random(10, 200);
      StringBuilder out = new StringBuilder(lineLength);
      for (int i = 0; i < lineLength; i++) {
        out.append(chars[c]);
      }
      out.append(System.lineSeparator());
      System.out.print(out.toString());
      c = (c + 1) % chars.length;
      sleep(getDelay(args));
    }
  }

  private static void sleep(int delay) {
    try {
      Thread.sleep(delay);
    } catch (InterruptedException e) {
    }
  }

  private static int getDelay(String[] args) {
    try {
      if (args.length == 1) {
        return Integer.parseInt(args[0]);
      } else if (args.length == 2) {
        int minDelay = Integer.parseInt(args[0]);
        int maxDelay = Integer.parseInt(args[1]);
        return (int) Math.abs(random(minDelay, maxDelay));
      } else {
        return DEFAULT_DELAY;
      }
    } catch (NumberFormatException e) {
      System.out.println("Argument(s) was/were not integer. Using default delay.");
      return DEFAULT_DELAY;
    }
  }

  public static <N extends Number> double random(N min, N max) {
    return (Math.random() * ((max.doubleValue() - min.doubleValue()) + 1)) + min.doubleValue();
  }

}
