package com.abbaskareem;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        LinkedList<String> placesToVisit = new LinkedList<>();
        addInOrder(placesToVisit, "Sydney");
        addInOrder(placesToVisit, "Melbourne");
        addInOrder(placesToVisit, "Brisbane");
        addInOrder(placesToVisit, "Perth");
        addInOrder(placesToVisit, "Canberra");
        addInOrder(placesToVisit, "Adelaide");
        addInOrder(placesToVisit, "Darwin");
        printList(placesToVisit);
        addInOrder(placesToVisit, "Alice Spring");
        addInOrder(placesToVisit, "Darwin");

        printList(placesToVisit);
        visit(placesToVisit);

//        placesToVisit.add("Sydney");
//        placesToVisit.add("Melbourne");
//        placesToVisit.add("Brisbane");
//        placesToVisit.add("Perth");
//        placesToVisit.add("Canberra");
//        placesToVisit.add("Adelaide");
//        placesToVisit.add("Darwin");
//
//        addInOrder(placesToVisit, "");
//        printList(placesToVisit);
//
//        placesToVisit.add(1, "Alice Spring");
//        printList(placesToVisit);
//
//        placesToVisit.remove(4);
//        printList(placesToVisit);

    }

    private static void printList(LinkedList<String> linkedList) {
        Iterator<String> i = linkedList.iterator();
        while (i.hasNext())
            System.out.println(i.next());
//        System.out.println("================================");
    }

    private static boolean addInOrder(LinkedList<String> linkedList, String newCity) {
        ListIterator<String> stringListIterator = linkedList.listIterator();
        while (stringListIterator.hasNext()) {
            int comparison = stringListIterator.next().compareTo(newCity);
            if (comparison == 0) {
                System.out.println(newCity + "is already included as ");
            } else if (comparison > 0) {
//                new city should appear before this one
                stringListIterator.previous(); //Because above we use .next() . we need to go back one position to add newCity
                stringListIterator.add(newCity);
                return true;
            } else if (comparison < 0) {

            }
        }
        stringListIterator.add(newCity);
        return true;
    }

    private static void visit(LinkedList<String> cities) {
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = false;
        ListIterator<String> listIterator = cities.listIterator();
        if (cities.isEmpty()) {
            System.out.println("No city in the itinerary");
            return;
        } else {
            System.out.println("Now visting " + listIterator.next());
            printMenu();
        }
        while (!quit) {
            int action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    System.out.println("Holiday is over");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward) {
                        if (listIterator.hasNext())
                            listIterator.next();
                        goingForward = true;
                    }
                    if (listIterator.hasNext()) {
                        System.out.println("Now visting " + listIterator.next());
                    } else {
                        System.out.println("Reached the end of the list");
                        goingForward = false;
                    }
                    break;

                case 2:
                    if (goingForward) {
                        if (listIterator.hasPrevious()) {
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()) {
                        System.out.println("Now Visitng previous " + listIterator.previous());
                    } else {
                        System.out.println("We at the star of the list");
                        goingForward = true;
                    }
                    break;
                case 3:
                    printMenu();
                    break;
            }
        }

    }

    private static void printMenu() {
        System.out.println("Available actions:\n press");
        System.out.println("0 - to quit\n" +
                "1 - go to next city\n" +
                "2 - go to previous city\n" +
                "3 - to print menu");
    }


}
