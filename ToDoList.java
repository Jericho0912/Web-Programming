import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.io.FileWriter;
import java.io.PrintWriter;

public class ToDoList {

    static ArrayList<String> objToDo = new ArrayList<String>();
    static Scanner objMain = new Scanner(System.in);  // for the menu
    static Scanner objItem = new Scanner(System.in);  // for the to-do
    static Scanner objNum = new Scanner(System.in);   // for the item number
    static PrintWriter objDocument;
    static int intItemCounter;
    static int intItemNum;
    static String strItem;
    static String strFile;

    public static void main(String[] args) {

        String strMenu;
        char strOption;
        int intSentinel = 1;
        int intOption;  // getting the ASCII value of strOption

        while (intSentinel > 0) {

            dispMenu();

            strMenu = objMain.next();
            strOption = Character.toLowerCase(strMenu.charAt(0));
            intOption = strOption;  // convert to ASCII

            if (!(strOption == 'x')) {
              
                /* check if the user pressed the keys between a to c or e */
                if ((intOption > 96 && intOption < 100) || intOption == 101) {
                    listItem();  // limit redundancy
                }  // if ((intOption > 96 && intOption < 100) || intOption == 101)
                
                switch (strOption) {
                    case 'a':
                        addItem();
                        break;
                    case 'b':
                        modItem();
                        break;
                    case 'c':
                        remItem();
                        break;
                    case 'd':
                        listItem();
                        break;
                    case 'e':
                        saveList();
                        break;
                    default:
                        System.out.println("\n\nChoice not available! Please try again..");
                }  // switch (strOption)
            } else {
                intSentinel = 0;
                System.out.println("\n\nbye..");
            }  // if (!(strOption == 'x'))

        }  // while (intSentinel > 0)

    }  // public static void main(String[] args)

    public static void dispMenu() {
        System.out.println("\n\nTo-Do List App");
        System.out.println("--------------");
        System.out.println("A. New");
        System.out.println("B. Modify");
        System.out.println("C. Remove");
        System.out.println("D. List");
        System.out.println("E. Save");
        System.out.println("X. Exit");
        System.out.print("\n\nChoose your option [Press A-E or X to quit]: ");
    }  // public static void dispMenu()

    public static void listItem() {
        System.out.println("\n");
        intItemCounter = 0;
        for (String strList : objToDo) {
            intItemCounter++;
            System.out.println(intItemCounter + ". " + strList);
        }  // for (String strList : objToDo)
    }  // public static void listItem()

    public static void addItem() {
        System.out.println("\n\nAdd Item");
        System.out.println("--------");
        System.out.print("\nPlease enter what to do? ");
        strItem = objItem.nextLine();
        objToDo.add(strItem);
    }  // public static void addItem()

    public static void modItem() {
        System.out.println("\n\nModify Item");
        System.out.println("----------");
        System.out.print("\nPress what item to modify: ");
        intItemNum = objNum.nextInt();          
        if (intItemNum <= objToDo.size()) {
            System.out.print("\nPlease enter what to do? ");      
            strItem = objItem.nextLine();
            objToDo.set(intItemNum - 1, strItem);
        }  // if (intItemNum <= objToDo.size())
    } // public static void modItem()

    public static void remItem() {
        System.out.println("\n\nRemove Item");
        System.out.println("------------");
        System.out.print("\nPress what item to remove: ");
        intItemNum = objNum.nextInt();          
        if (intItemNum <= objToDo.size()) {
            objToDo.remove(intItemNum - 1);
        }  // if (intItemNum <= objToDo.size())       
    }  // public static void remItem()

    public static void saveList() {
        System.out.println("\n\nSave To-Do List");
        System.out.println("---------------");
        System.out.print("\nEnter filename to save list: ");
        strFile = objItem.nextLine();  // reuse objItem
        /* additional validation optional */
        try {
            objDocument = new PrintWriter(new FileWriter(strFile));

            objDocument.println("To-Do List");
            objDocument.println("----------");
            intItemCounter = 0;
            for (String strTemp : objToDo) {
                intItemCounter++;
                objDocument.println(intItemCounter + ". " + strTemp);
            }  // for (String strList : objToDo)
            
            System.out.println("To-Do Listing saved to " + strFile + "..");
        } catch (Exception objEx) {
            System.out.println("Problem writing to " + strFile + " !");
            System.out.println(objEx);
        } finally {
            try {
                objDocument.close();
            } catch (Exception objEx) {
                System.out.println(objEx);
            }  // try
        }  // try
    }  // public static void saveList()

}  // public class ToDoList
