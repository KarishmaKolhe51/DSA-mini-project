package com.dsa.entity;

import java.util.Scanner;

public class StudentRecordManagementSystem {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList list = new LinkedList();

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Insert Student record");
            System.out.println("2. Delete student record");
            System.out.println("3. Show all student record");
            System.out.println("4. Search student record by RollNo");
            System.out.println("5. Search student record by Name");
            System.out.println("6. Exit");

            System.out.print("\nEnter your choice: ");
            String choice = scanner.next();

            switch (choice) {
                case "1":

                    System.out.print("Enter Name: ");
                    String name = scanner.next();

                    System.out.print("Enter Roll No.: ");
                    int rollNo = scanner.nextInt();
                    System.out.print("Enter Course: ");
                    String course = scanner.next();
                    System.out.print("Enter Marks: ");
                    int marks = scanner.nextInt();
                    list.createRecord(name, rollNo, course, marks);
                    break;

                case "2":
                    System.out.print("Enter Roll No. to delete record: ");
                    int rollNoToDelete = scanner.nextInt();
                    list.deleteRecord(rollNoToDelete);
                    break;

                case "3":
                    list.showRecord();
                    break;

                case "4":
                    System.out.print("Enter Roll No to search record: ");
                    int rollNoToSearch = scanner.nextInt();
                    list.searchRecordByRollNO(rollNoToSearch);
                    break;
                case "5":
                    System.out.print("Enter Name to search record: ");
                    String nameToSearch = scanner.next();
                    list.searchRecordByName(nameToSearch);
                    break;

                case "6":
                    System.out.println("Exiting program...");
                    System.exit(0);

                default:
                    System.out.println("\nInvalid choice!");
                    break;
            }
        }
    }
}
