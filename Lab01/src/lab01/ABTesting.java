/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab01;

/**
 *
 * @author mimic
 */
/**
 * This interface is part of a tool
 * to do A/B testing for the biology
 * division of our Martian colony.
 *
 * Note: This class should have two
 * constructors. The first constructor
 * should be public. The second should
 * be private.
 *
 * Constructor 1: A default constructor,
 * which initializes the number of successes
 * for A and B to zero. This should count
 * as a new test (and should affect the
 * output of totalTests() below).
 *
 * Constructor 2: This constructor takes
 * two arguments. The first is the number
 * of successes for A, the second is the number
 * of successes for B. It is called by the
 * system when it's reading an old ABTesting
 * session from disk, and so this constructor
 * should <em>not</em> increase the count
 * reported by totalTests().
 */
public interface ABTesting {

  /**
   * Call this method when one of the
   * experiments in group A does better.
   */
  void successForA();

  /**
   * Call this method when one of the
   * experiments in group B does better.
   */
  void successForB();

  /**
   * The total number of ABTesting
   * objects created.
   */
  int totalTests();

  /**
   * The total number of successes
   * provided for this ABTesting
   * object.
   */
  int totalSuccessesInThisTest();

  /**
   * The total number of successes for
   * A in this test.
   */
  int successesForAinThisTest();

  /**
   * The total number of successes for
   * A in this test.
   */
  int successesForBinThisTest();
}