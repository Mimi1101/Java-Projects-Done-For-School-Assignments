/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dendrologist;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Comparator;
import java.util.Scanner;
import java.util.ArrayList;

/**
 * A testbed for an augmented implementation of an AVL tree
 *
 * @author William Duncan, Bibhushita Baral
 * @see AVLTreeAPI  <pre>
 * Date: 10/18/2022
 * Course: CSC 3102
 * Programming Project # 2
 * Instructor: Dr. Duncan
 * </pre>
 */
public class Dendrologist {

    public static void main(String[] args) throws FileNotFoundException {
        String usage = "Dendrologist <order-code> <command-file>\n";
        usage += "  <order-code>:\n";
        usage += "  0 ordered by increasing string length, primary key, and reverse lexicographical order, secondary key\n";
        usage += "  -1 for reverse lexicographical order\n";
        usage += "  1 for lexicographical order\n";
        usage += "  -2 ordered by decreasing string\n";
        usage += "  2 ordered by increasing string\n";
        usage += "  -3 ordered by decreasing string length, primary key, and reverse lexicographical order, secondary key\n";
        usage += "  3 ordered by increasing string length, primary key, and lexicographical order, secondary key\n";
        if (args.length != 2) {
            System.out.println(usage);
            throw new IllegalArgumentException("There should be 2 command line arguments.");
        }

        File stringFile = new File(args[1]);
        Scanner inFile = new Scanner(stringFile);
        int node = Integer.valueOf(args[0]);
        Comparator<String> comparer = null;

        switch (node) {

            case 0:
                comparer = (String1, String2) -> {
                    if (String1.length() < String2.length()) {
                        return -1;
                    }
                    if (String1.length() > String2.length()) {
                        return 1;
                    }
                    if (String1.length() == String2.length()) {
                        if (String1.compareTo(String2) < 0) {
                            return 1;
                        }
                        if (String1.compareTo(String2) > 0) {
                            return -1;
                        }
                    }
                    return 0;
                };
                break;
            case -3:
                comparer = (String1, String2) -> {
                    if (String1.length() < String2.length()) {
                        return 1;
                    }
                    if (String1.length() > String2.length()) {
                        return -1;
                    }
                    if (String1.length() == String2.length()) {
                        if (String1.compareTo(String2) < 0) {
                            return 1;
                        }
                        if (String1.compareTo(String2) > 0) {
                            return -1;
                        }
                    }
                    return 0;
                };
                break;
            case -2:
                comparer = (String1, String2) -> {
                    if (String1.length() < String2.length()) {
                        return 1;
                    }
                    if (String1.length() > String2.length()) {
                        return -1;
                    }
                    return 0;
                };
            case -1:
                comparer = (String1, String2) -> {
                    if (String1.compareTo(String2) < 0) {
                        return 1;
                    }
                    if (String1.compareTo(String2) > 0) {
                        return -1;
                    }
                    return 0;
                };
                break;
            case 1:
                comparer = (String1, String2) -> {
                    return String1.compareTo(String2);
                };
                break;
            case 2:
                comparer = (String1, String2) -> {
                    if (String1.length() < String2.length()) {
                        return -1;
                    }
                    if (String1.length() > String2.length()) {
                        return 1;
                    }
                    return 0;
                };
                break;

            case 3:
                comparer = (String1, String2) -> {
                    if (String1.length() < String2.length()) {
                        return -1;
                    }
                    if (String1.length() > String2.length()) {
                        return 1;
                    }
                    if (String1.length() == String2.length()) {
                        return String1.compareTo(String2);
                    }
                    return 0;
                };
                break;

        }
        AVLTree<String> tree = new AVLTree(comparer);
        String one = "";
        String two = "";
        while(inFile.hasNextLine()) {
             if (inFile.hasNext()) {
                one= inFile.next();
            }
              if (one.equals("stats")) {
                System.out.println("Stats: size = " + tree.size() + ", height = " + tree.height() + ", #full-nodes = "
                         + tree.fullCount() + ", fibonacci? = " + tree.isFibonacci());
            }
              if (one.equals("insert")) {
                 if (inFile.hasNextLine()) {
                     two = inFile.next();
                 }
                 tree.insert(two);
                 System.out.println("Inserted:" + two);
                 two = "";
                 one = "";
             }
              if(one.equals("delete")){
                 if(inFile.hasNextLine()){
                     two = inFile.next();
                 }
                 tree.remove(two);
                 System.out.println("Deleted: " + two);
                 two = "";
                 one = "";
             }
               if (one.equals("paths")) {
                ArrayList list = tree.genPaths();
                System.out.println("#Root-To-Leaf-Paths: " + list.size());
                for (int j = 0; j < tree.genPaths().size(); j++) {
                    System.out.println(tree.genPaths().get(j));
                }
            }
                if (one.equals("traverse")) {
                System.out.println("In-Order Traversal: ");
                tree.traverse((f)-> {
                    System.out.println(f);
                    return f;
                });
               
        }
        
    }

    }
}
