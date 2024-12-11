package com.dev.lpa;

import java.util.*;

public class ArrayListChallenge {
    public static void main(String[] args) {
        ArrayList<String> groceryList = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("""
                    Available actions:
                    0 - to shut down;
                    1 - to add item(s);
                    2 - to remove item(s);
                    """);
            String input = scan.nextLine();
            if (input.equals("0")) {
                if (groceryList.isEmpty()) {
                    System.out.println("Empty list");
                    break;
                }
                groceryList.sort(Comparator.naturalOrder());
                System.out.println(groceryList);
                break;
            }
            if (input.equals("1")) {
                System.out.println("please list your items separated in comma");
                String input1 = scan.nextLine();
                String[] addItems = input1.split(",");
                for (String s : addItems) {
                    if (groceryList.contains(s.trim())) {
                        System.out.println(s+" already on the list");
                        continue;
                    }
                    groceryList.add(s.trim());
                    groceryList.sort(Comparator.naturalOrder());
                }
                System.out.println();
                System.out.println(groceryList);
            }
            if (input.equals("2")) {
                if (groceryList.isEmpty()) {
                    System.out.println("Grocery List is already empty");
                    break;
                }
                System.out.println("Please list items to be removed");
                String input2 = scan.nextLine();
                String[] removeItems = input2.split(",");
                for(String s: removeItems){
                    if(s.trim().equalsIgnoreCase("all")){
                        groceryList.clear();
                        System.out.println("Grocery List cleared");
                        break;
                    }

                    if (!(groceryList.contains(s.trim()))) {
                        System.out.println(s + " doesn't exist");
                    } else {
                        groceryList.remove(s.trim());
                        groceryList.sort(Comparator.naturalOrder());
                    }
                    System.out.println();
                    System.out.println(groceryList);
                }

            }

        }
    }
}
