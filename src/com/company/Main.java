package com.company;

import java.util.Scanner;

class Runner{
    public static void main(String[] args) {

        /////////////////////////////////////////////////////
        // As per Question 7
        // Add a main method that tests your methods using a linked list of Characters. Prompt for String input,
        // then take the String apart and put it back together as a linked list.
        String s;
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        s = sc.nextLine();
        System.out.println("You entered String :"+ s);

        LinkedListWithNode strList = new LinkedListWithNode();

        for (int i = 0; i < s.length(); i++){
            //System.out.println(s.charAt(i));
            strList.add(s.charAt(i));

        }
        System.out.println("Your converted string into linked list is: ");
        System.out.println(strList);

        LinkedListWithNode rStrList = strList.ListReverse();
        System.out.println("Reverse the aarray!");
        System.out.println(rStrList);

        /////////////////////////////////////////////////
        // Test cases for LinkedListWith Node Below
        LinkedListWithNode list = new LinkedListWithNode();
        String data;
        for (int x = 0; x < 8; x++) {
            data = "" + x;
            list.add(data);
        }

        System.out.println("Original list:");
        System.out.println(list);

        //Reverse the list
        LinkedListWithNode rList = list.ListReverse();
        System.out.println("Reverse list: ");
        System.out.println(rList);

        // Clone list
        try {

            LinkedListWithNode cList = rList.clone();
            System.out.println("Cloning list: ");
            System.out.println(cList);

        }
        catch (CloneNotSupportedException e){
            System.out.println("Cloning exception occcurred.");
        }

        // List part
        LinkedListWithNode tempList =  list.listPart(2,5);
        System.out.println("Executing List Part :");
        System.out.println(tempList);

        // List search
        //LinkedListWithNode tempList1 =  rList.listPart(0,4);
        System.out.println("Executing Search :");
        System.out.println(rList.listSearch("4"));


        int index = ((int) (Math.random() * 10)) % list.size() + 1;
        /// Print total items in list
        System.out.println("Count of items in list " + list.size());
        System.out.println("Getting item at index " + index);
        System.out.println(list.get(index) + " retrieved");
        System.out.println("Removing item at index 4");
        list.remove(4);
        System.out.println("Revised list:");
        System.out.println(list);
        System.out.println("Removing first item:");
        list.remove(1);
        System.out.println("Revised list:");
        System.out.println(list);
        /// Print total items in list
        System.out.println("Count of items in list " + list.size());
        System.out.println("Removing last item");
        list.remove(list.size());
        System.out.println("Revised list:");
        System.out.println(list);
        index = ((int) (Math.random() * 1000)) % list.size() + 1;
        System.out.println("Adding new item at position " + index);
        list.add("" + ((int) (Math.random() * 1000)) % list.size(), index);
        System.out.println("Revised list:");
        System.out.println(list);





    }
}
