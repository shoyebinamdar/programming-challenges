package codility;

import static org.junit.Assert.*;

import org.junit.Test;

public class WordMachineTest {

  @Test
  public void prcessorTest_1() {
    WordMachine wordMachine = new WordMachine();

    assertEquals(7, wordMachine.processor("13 7 20 DUP - +"));
  }

  @Test
  public void prcessorTest_2() {
    WordMachine wordMachine = new WordMachine();

    assertEquals(-1, wordMachine.processor("13 20 12 7 - +"));
  }

  @Test
  public void prcessorTest_3() {
    WordMachine wordMachine = new WordMachine();

    assertEquals(25, wordMachine.processor("13 20 7 12 - +"));
  }

  @Test
  public void prcessorTest_4() {
    WordMachine wordMachine = new WordMachine();

    assertEquals(-1, wordMachine.processor("12 POP DUP"));
  }

  @Test
  public void prcessorTest_5() {
    WordMachine wordMachine = new WordMachine();

    assertEquals(-1, wordMachine.processor("12 +"));
  }
}
