package com.dsa.entity;

public class LinkedList {

    Node head;
    Node tail;

    public LinkedList() {
        this.head = null;
    }

    public boolean checkRecord(int rollNo) {
        Node temp = head;
        while (temp != null) {
            if (temp.data.rollNo == rollNo) {
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /*
     * public void createRecord(String name, int rollNo, String course, int marks) {
     * if (checkRecord(rollNo)) {
     * System.out.println("Record with Roll No. " + rollNo + " already exists!");
     * } else {
     * Student student = new Student(name, rollNo, course, marks);
     * Node newNode = new Node(student);
     * if (head == null) {
     * head = newNode;
     * } else {
     * Node temp = head;
     * while (temp.next != null) {
     * temp = temp.next;
     * }
     * temp.next = newNode;
     * }
     * System.out.println("Record created successfully!");
     * System.out.println("Student Record:");
     * System.out.println(
     * "-----------------------------------------------------------");
     * System.out.printf("| %-15s | %-8s | %-15s | %-8s |\n", "Name", "Roll No",
     * "Course", "Marks");
     * System.out.println(
     * "-----------------------------------------------------------");
     * System.out.printf("| %-15s | %-8d | %-15s | %-8d |\n", newNode.data.name,
     * newNode.data.rollNo, newNode.data.course, newNode.data.marks);
     * System.out.println(
     * "-----------------------------------------------------------");
     * }
     * }
     */

    /*
     * void createRecord(String name, int rollNo, String course, int marks) {
     * 
     * if (checkRecord(rollNo)) {
     * System.out.println("Record with Roll No. " + rollNo + " already exists!");}
     * else {
     * Student student = new Student(name, rollNo, course, marks);
     * Node newNode = new Node(student);
     * 
     * if (head == null) {
     * head =newNode;
     * tail = newNode;
     * // newNode.next=null;
     * } else {
     * tail.next = newNode;
     * tail = newNode;
     * }
     * System.out.println("Record added successfully!");
     * System.out.println("Student Record:");
     * System.out.println(
     * "-----------------------------------------------------------");
     * System.out.printf("| %-15s | %-8s | %-15s | %-8s |\n", "Name", "Roll No",
     * "Course", "Marks");
     * System.out.println(
     * "-----------------------------------------------------------");
     * System.out.printf("| %-15s | %-8d | %-15s | %-8d |\n", newNode.data.name,
     * newNode.data.rollNo, newNode.data.course, newNode.data.marks);
     * System.out.println(
     * "-----------------------------------------------------------");
     * }}
     */

    public void createRecord(String name, int rollNo, String course, int marks) {

        if (checkRecord(rollNo)) {
            System.out.println("Record with Roll No. " + rollNo + " already exists!");
        } else {
            Student student = new Student(name, rollNo, course, marks);
            Node newNode = new Node(student);

            if (head == null || rollNo < head.data.rollNo) {
                newNode.next = head;
                head = newNode;
            } else {
                Node temp = head;
                while (temp.next != null && rollNo > temp.next.data.rollNo) {
                    temp = temp.next;
                }
                newNode.next = temp.next;
                temp.next = newNode;
            }
            // System.out.println("-----------------------------------------------------------");
            System.out.println("\nRecord added successfully!");
            System.out.println();
            System.out.println("Student Record:");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("| %-15s | %-8s | %-15s | %-8s |\n", "Name", "Roll No", "Course", "Marks");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("| %-15s | %-8d | %-15s | %-8d |\n", newNode.data.name, newNode.data.rollNo,
                    newNode.data.course, newNode.data.marks);
            System.out.println("-----------------------------------------------------------");

        }
    }

    public void searchRecordByRollNO(int rollNo) {
        Node temp = head;
        boolean found = false;
        while (temp != null) {
            if (temp.data.rollNo == rollNo) {
                // System.out.println("-----------------------------------------------------------");
                System.out.println("\nStudent Record Found");
                // System.out.println("Student Record:");
                System.out.println("\n-----------------------------------------------------------");
                System.out.printf("| %-15s | %-8s | %-15s | %-8s |\n", "Name", "Roll No", "Course", "Marks");
                System.out.println("-----------------------------------------------------------");
                System.out.printf("| %-15s | %-8d | %-15s | %-8d |\n", temp.data.name, temp.data.rollNo,
                        temp.data.course, temp.data.marks);
                System.out.println("-----------------------------------------------------------");
                found = true;

            }
            temp = temp.next;
        }
        if (!found) {
            System.out.println("\nRecord with Roll No. " + rollNo + " not found!" + "\nPlease Enter Valid Record !!");
        }
    }

    public void searchRecordByName(String name) {
        if (head == null) {
            System.out.println("Record list is empty!");
        } else {
            Node temp = head;
            boolean found = false;
            while (temp != null) {
                if (temp.data.name.equalsIgnoreCase(name)) {
                    // System.out.println("-----------------------------------------------------------");
                    System.out.println("\nStudent Record Found");
                    System.out.println("-----------------------------------------------------------");
                    System.out.printf("| %-15s | %-8s | %-15s | %-8s |\n", "Name", "Roll No", "Course", "Marks");
                    System.out.println("-----------------------------------------------------------");
                    System.out.printf("| %-15s | %-8d | %-15s | %-8d |\n", temp.data.name, temp.data.rollNo,
                            temp.data.course, temp.data.marks);
                    System.out.println("-----------------------------------------------------------");
                    found = true;

                }
                temp = temp.next;
            }
            if (!found) {
                System.out.println("\nNo record found with name: " + name + "\nPlease Enter Record First!!");
            }
        }
    }

    public int deleteRecord(int rollNo) {
        if (head == null) {
            System.out.println("List is empty!");
            return -1;
        } else {
            Node temp = head;
            Node prev = null;
            while (temp != null) {
                if (temp.data.rollNo == rollNo) {
                    if (prev == null) {
                        head = temp.next;
                    } else {
                        prev.next = temp.next;
                    }
                    System.out.println("\nRecord with " + rollNo + " is deleted successfully!");
                    return 0;
                }
                prev = temp;
                temp = temp.next;
            }
            System.out.println("\nRecord with Roll No. " + rollNo + " not found!");
            return -1;
        }
    }

    public void showRecord() {
        if (head == null) {
            System.out.println("List is empty!");
        } else {
            System.out.println("-----------------------------------------------------------");
            System.out.println("Student Records:");
            System.out.println("-----------------------------------------------------------");
            System.out.printf("| %-15s | %-8s | %-15s | %-8s |\n", "Name", "Roll No", "Course", "Marks");
            System.out.println("-----------------------------------------------------------");
            Node temp = head;
            while (temp != null) {
                System.out.printf("| %-15s | %-8d | %-15s | %-8d |\n", temp.data.name, temp.data.rollNo,
                        temp.data.course, temp.data.marks);
                System.out.println("-----------------------------------------------------------");
                temp = temp.next;
            }
        }
    }
}
