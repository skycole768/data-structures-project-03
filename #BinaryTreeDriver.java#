import java.io.*;
import java.util.Scanner;

public class BinaryTreeDriver {


    static  BinarySearchTree<Integer>  intList = null;
    static  BinarySearchTree<Double> doubleList = null;
    static  BinarySearchTree<String> stringList = null;


    /**
 * Class that prompts user to enter commands that either change or show some state
 * of a BinarySearchTree objects, made up of int, string, or double values,
 * as specified by a given file.
 */

    public static void main(String args[]) {


        System.out.print("Enter list type (i - int, d - double, s - string): ");
        Scanner keyboard = new Scanner(System.in);
        String input = keyboard.nextLine();


        boolean isInt, isDouble, isString;
        isInt = false;
        isDouble = false;
        isString = false;

        if (input.equals("i")) {
            intList = new BinarySearchTree<Integer>();
            isInt = true;
        } else if (input.equals("d")) {
            isDouble = true;
            doubleList = new BinarySearchTree<Double>();
        } else {
            isString = true;
            stringList =  new BinarySearchTree<String>();
        }

        try {
            String fileName = args[0];
            File file = new File(fileName);

            Scanner fileReader = new Scanner(file);


            if(isInt) {

                int item = 0;

                while(fileReader.hasNextInt()) {

                    item = fileReader.nextInt();
                    intList.insert(item);
                }

            } else if(isDouble) {

                double item = 0;
                while(fileReader.hasNextDouble()) {
                    item = fileReader.nextDouble();
                    doubleList.insert(item);
                }
            } else {
                String item = null;
                while(fileReader.hasNext()) {
                    item = fileReader.next();
                    stringList.insert(item);
                }

            }

            fileReader.close();
        } catch (IOException | ArrayIndexOutOfBoundsException e) { //if file not found or some
                                                                   // other error
            System.out.println("File not found");
            return;
        }



        System.out.printf("Commands:%n(i) - Insert Item%n(d) - Delete Item");
        System.out.printf("%n(p) - Print Tree%n(r) - Retrieve Item%n");
        System.out.printf("(l) - Count Leaf Nodes%n(s) - Find Single Parents%n(c) - Find Cousins");
        System.out.printf("%n(q) - Quit program%n");

        boolean quit = false;
        boolean invalid = false;

        while(!quit) {

            if (!invalid) {
                System.out.println("");
                System.out.print("Enter a command: ");
            }

            input = keyboard.nextLine();

            switch(input) {
            case "i": // insert
                invalid = false;

                insert(isString, isDouble, isInt, keyboard);
                break;

             case "d": // delete
                 invalid = false;
                 delete(isString, isDouble, isInt, keyboard);
                 break;

             case "s": //single parent
                 invalid = false;
                 singleParent(isString, isDouble, isInt);
                 break;
             case "r": // retrieve
                 invalid = false;
                 search(isString, isDouble, isInt, keyboard);

                break;
             case "c": // printing cousins
                 printCousins(isString, isDouble, isInt, keyboard);
                 invalid = false;

                 break;
             case "p": // print
                 invalid = false;
                 print(isString, isDouble, isInt);
                 break;
             case "l": // leaf count
                invalid = false;
                 leafCount(isString, isDouble, isInt);
                 break;
             case "q": // quit
                 invalid = false;
                 System.out.println("Exiting the program...");
                 quit = true;
                 break;
             default: // invalid command
                invalid = true;
                System.out.print("Invalid command, try again: ");
                break;
            }

        }

        keyboard.close();
        System.exit(0);
    }

    // prints the cousins of the item specified by the user, in the bst object
    static void printCousins(boolean isString,boolean isDouble, boolean isInt, Scanner keyboard) {

        if(isString) {
            System.out.print("In-order: : ");
            stringList.inOrder();
            System.out.println("");

            System.out.print("Enter a string: ");
            String string1 = keyboard.next();

            System.out.print(string1);
            System.out.print(" cousins: ");
            stringList.getCousins(string1);



        } else if(isDouble) {
            System.out.print("In-order: ");
            doubleList.inOrder();
            System.out.println("");

            System.out.print("Enter a number: ");
            double num = keyboard.nextDouble();

            System.out.print(num);
            System.out.print(" cousins: ");
            doubleList.getCousins(num);


        } else {

                       System.out.print("In-order: ");
            intList.inOrder();
            System.out.println("");

            System.out.print("Enter a number: ");
            int num = keyboard.nextInt();

            System.out.print(num);
            System.out.print(" cousins: ");
            intList.getCousins(num);

        }

        keyboard.nextLine();


    }

    // prints the leaves(nodes without children), of the bst object
        static void leafCount(boolean isString,boolean isDouble, boolean isInt) {

        if(isString) {
            System.out.print("The number of leaf nodes are ");
            System.out.println(stringList.getNumLeafNodes());
        } else if(isDouble) {
       System.out.print("The number of leaf nodes are ");
            System.out.println(doubleList.getNumLeafNodes());

        } else {
       System.out.print("The number of leaf nodes are ");
            System.out.println(intList.getNumLeafNodes());

        }
    }
    //prints the single parents, nodes with only one children, inside the of the bst object
    static void singleParent(boolean isString,boolean isDouble, boolean isInt) {

        System.out.print("In-order: ");
        if(isString) {
            stringList.inOrder();
            System.out.println("");
            System.out.print("Single Parents: ");
            stringList.getSingleParent();
        } else if(isDouble) {
            doubleList.inOrder();
            System.out.println("");
            System.out.print("Single Parents: ");
            doubleList.getSingleParent();

        } else {
            intList.inOrder();
            System.out.println("");
            System.out.print("Single Parents: ");
            intList.getSingleParent();
        }
    }

    // prints the values of the nodes, inside of the bst, in order
     static void print(boolean isString,boolean isDouble, boolean isInt) {

        System.out.print("In-order: ");
        if(isString) {
            stringList.inOrder();
        } else if(isDouble) {
            doubleList.inOrder();
        } else {
            intList.inOrder();
        }
    }

    // searches for a node item inside the bst, as specified by the user
    static void search(boolean isString,boolean isDouble, boolean isInt, Scanner keyboard) {


        if (isString) {
            System.out.print("In-order: ");
            stringList.inOrder();
            System.out.println("");
            System.out.print("Enter a string to search: ");
            String input = keyboard.next();

            if(stringList.retrieve(input) == true) {
                System.out.println("Item is present in the tree");
            } else {
                System.out.println("Item is not present in the tree");
            }
        } else if (isDouble){
            System.out.print("In-order: ");
            doubleList.inOrder();
            System.out.println("");

              System.out.print("Enter a number to search: ");
            double input = keyboard.nextDouble();

            if(doubleList.retrieve(input) == true) {
                System.out.println("Item is present in the tree");
            } else {
                System.out.println("Item is not present in the tree");
            }
        } else {
            System.out.print("In-order: ");
            intList.inOrder();
            System.out.println("");
              System.out.print("Enter a number to search: ");
            int input = keyboard.nextInt();

               if(intList.retrieve(input) == true) {
              System.out.print("Item is present in the tree");
             } else {
               System.out.print("Item is not present in the tree");
             }

        }

        keyboard.nextLine();

    }

    // delete value, specified by user, from the bst
    static void delete(boolean isString,boolean isDouble, boolean isInt, Scanner keyboard) {
        if(isString) {
            System.out.print("In-order: ");
            stringList.inOrder();
            System.out.println("");

            System.out.print("Enter a string to delete: ");
            String string1 = keyboard.next();

             if(stringList.retrieve(string1) != true) {
                System.out.println("Item is not present in the tree");
                keyboard.nextLine();
                return;
            }
            stringList.delete(string1);
            System.out.print("In-order: ");
            stringList.inOrder();
            System.out.println("");


        } else if(isDouble) {
            System.out.print("In-order: ");
            doubleList.inOrder();
            System.out.println("");

            System.out.print("Enter a number to delete: ");
            Double num  = keyboard.nextDouble();

             if(doubleList.retrieve(num) != true) {
                System.out.println("The number is not present in the tree");
                keyboard.nextLine();
                return;
            }
            doubleList.delete(num);
            System.out.print("In-order: ");
            doubleList.inOrder();
            System.out.println("");
        } else {

                    System.out.print("In-order: ");
            intList.inOrder();
            System.out.println("");

            System.out.print("Enter a number to delete: ");
            int num = keyboard.nextInt();

              if(intList.retrieve(num) != true) {
                System.out.println("The number is not present in the tree");
                keyboard.nextLine();
                return;
            }
            intList.delete(num);
            System.out.print("In-order: ");
            intList.inOrder();
            System.out.println("");

}
        keyboard.nextLine();

    }

    // inserts value, specified by user, from the bst
    static void insert (boolean isString, boolean isDouble, boolean isInt, Scanner keyboard) {

        if(isString) {
                       System.out.print("In-order: : ");
            stringList.inOrder();
            System.out.println("");

            System.out.print("Enter a string to insert: ");
            String string1 = keyboard.next();

            stringList.insert(string1);

            System.out.print("In-order: ");
            stringList.inOrder();
            System.out.println("");


        } else if(isDouble) {
            System.out.print("In-order: ");
            doubleList.inOrder();
            System.out.println("");

            System.out.print("Enter a number to insert: ");
            double num = keyboard.nextDouble();

            doubleList.insert(num);
            System.out.print("In-order: ");
            doubleList.inOrder();
            System.out.println("");


        } else {

                       System.out.print("In-order: ");
            intList.inOrder();
            System.out.println("");

            System.out.print("Enter a number to insert: ");
            int num = keyboard.nextInt();

            intList.insert(num);
            System.out.print("In-order: ");
            intList.inOrder();
            System.out.println("");

        }

        keyboard.nextLine();


    }
 }
