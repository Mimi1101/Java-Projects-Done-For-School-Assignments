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
import java.lang.reflect.*;
import java.util.Random;
import java.io.File;

public class ABTestingTester {
  public static void main(String[] args) throws Exception {

    try {
      assert false;
      throw new Error("Assertions need to be enabled.");
    } catch(AssertionError ae) {}

    assert args.length == 1 : "You have to give the name of your class as argument. You should include the package name.";
    
    Class<?> c = null;
    try {
        c = Class.forName(args[0]);
    } catch(ClassNotFoundException ce) {
        System.out.println("Class not found: "+args[0]);

        var thisClass = ABTestingTester.class;

        // Find the directory that the class is stored in
        String testDir = thisClass.getResource(".").getFile();

        String pkg = thisClass.getPackage().getName();

        // Find classes in the current directory which implement
        // the ABTesting interface.
        for(File f : new File(testDir).listFiles()) {
            String name = f.getName();
            if(!name.endsWith(".class")) continue;
            name = name.substring(0,name.length()-".class".length());
            name = pkg + "." + name;
            Class<?> candidate = Class.forName(name);
            if(candidate == ABTesting.class) continue;
            if(candidate == thisClass) continue;
            if(ABTesting.class.isAssignableFrom(candidate)) {
                System.out.println("Did you mean: "+name);
            }
        }
        System.exit(0);
    }

    Constructor c1 = null;
    try {
      c1 = c.getDeclaredConstructor(new Class[]{});
    } catch(Exception ex) {}
    assert c1 != null : "Constructor 1 from the instructions isn't present.";
    assert Modifier.isPublic(c1.getModifiers()) : "Constructor 1 should be public";

    Constructor c2 = null;
    try {
      c2 = c.getDeclaredConstructor(new Class[]{Integer.TYPE,Integer.TYPE});
    } catch(Exception ex) {}
    assert c2 != null : "Constructor 2 from the instructions isn't present.";
    assert Modifier.isPrivate(c2.getModifiers()) : "Constructor 2 should be private";
    c2.setAccessible(true);

    String[] veggies = {"turnips","carrots","potatoes","lentils","cabbage",
        "pinto beans","cauliflower","broccoli","brussel sprouts","corn"};
    String[] failure = {"turned carnivorus","became radioactive","exploded",
        "became poisonous","became smelly","became mutinagenic"};

    String banner = "Plant Growth Experiments on Mars";
    System.out.print("+-");
    for(int i=0;i<banner.length();i++)
        System.out.print('-');
    System.out.println("-+");
    System.out.println("| "+banner+" |");
    System.out.print("+-");
    for(int i=0;i<banner.length();i++)
        System.out.print('-');
    System.out.println("-+");

    Random r = new Random();
    ABTesting ab0 = (ABTesting)c1.newInstance();
    ABTesting ab = (ABTesting)c1.newInstance();
    int na=0,nb=0;
    int nt = 7 + r.nextInt(5);
    for(int i=0;i<nt;i++) {
      int a = r.nextInt(veggies.length);
      int b = r.nextInt(veggies.length-1);
      if(b >= a) b ++;
      System.out.printf("%s vs. %s%n",veggies[a],veggies[b]);
      int fail = r.nextInt(failure.length);
      int whichFailed = r.nextInt(2)==0 ? a : b;
      System.out.printf("  --> the %s %s%n",veggies[whichFailed],failure[fail]);
      if(whichFailed == a) {
        ab.successForB();
        nb++;
      } else {
        ab.successForA();
        na++;
      }
      assert ab0.successesForAinThisTest() == 0: "Possible misuse of static fields";
      assert ab0.successesForBinThisTest() == 0: "Possible misuse of static fields";
      assert ab.successesForAinThisTest() == na:
        String.format("Wrong number of successes for A. Got %d, expected %d", ab.successesForAinThisTest(), na);
      assert ab.successesForBinThisTest() == nb:
        String.format("Wrong number of successes for B. Got %d, expected %d", ab.successesForBinThisTest(), nb);
      assert ab.totalSuccessesInThisTest() == na+nb:
        String.format("Wrong number of total successes. Got %d, expected %d", ab.totalSuccessesInThisTest(), na+nb);
    }

    int numInstances = 100+r.nextInt(100);
    for(int i=0;i<numInstances;i++) {
      int a = r.nextInt(20);
      int b = r.nextInt(20);
      ab = (ABTesting)c1.newInstance();
      assert ab.successesForAinThisTest() == 0 :
        "successesForAinThisTest() should be zero for a newly constructed object.";
      assert ab.successesForBinThisTest() == 0 :
        "successesForBinThisTest() should be zero for a newly constructed object.";
      for(int ia = 0; ia < a; ia++)
        ab.successForA();
      for(int ib = 0; ib < b; ib++)
        ab.successForB();
      assert ab.successesForAinThisTest() == a :
        "successesForAinThisTest() not working";
      assert ab.successesForBinThisTest() == b :
        "successesForBinThisTest() not working";
      assert ab.totalSuccessesInThisTest() == a+b :
        "totalSuccessesInThisTest() not working";
      assert ab.totalTests() == i+3 :
        String.format("totalTests() not working, got %d, expected %d.", ab.totalTests(), i+3);

      int na0 = 1 + r.nextInt(10);
      int nb0 = 1 + r.nextInt(10);
      ABTesting ab2 = (ABTesting)c2.newInstance(na0,nb0);
      assert ab2.successesForAinThisTest() == na0 : "Constructor 2 not working";
      assert ab2.successesForBinThisTest() == nb0 : "Constructor 2 not working";
    }
    System.out.println("All tests passed.");
  }
}