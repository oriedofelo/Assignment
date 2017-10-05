package com.mathscontest;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ContestAdmin {

    public static void main(String[] args) {
        Contest contest = null;

        contest = startup(contest);
        while (true) {
            int option = displayMenu();
            switch (option) {
                case 1:
                    contest.enterScores();
                    break;
                case 2:
                    contest.viewContestScores();
                    break;
                case 3:
                    displayCredits();
                    break;
                case 4:
                    exit();
                    break;
                default:
                    break;
            }
        }

    }

    public static Contest startup(Contest contest) {
        int numOfQuestions = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("============================"); // in for loop
        System.out.println("Initailizing Contest Adminintration System....");
        do {
            System.out.println("How many questions required (minimum of 1: )");
            numOfQuestions = input.nextInt();

        } while (numOfQuestions < 1);

        System.out.println("---Initalizing championship...");
        contest = new Contest("Maths Wiz!", 8, numOfQuestions, 2);
        System.out.println("Successfully created contest "
                + contest.getContestName() + " Championship");

        System.out.println("---Registering participating schools .....");

        School s1 = new School("Australian College Ballarat", "S1");
        School s2 = new School("Graduate Business School", "S2");
        School s3 = new School("Kerry Moore School of Ballet", "S3");
        School s4 = new School("St Patrick's College", "S4");
        School s5 = new School("Mike Mike", "S5");

        System.out.println("---Creating student records .....");

        Student st1 = new Student("John 1", s1);
        Student st2 = new Student("Mike 2", s1);
        Student st11 = new Student("Mike 2", s1);
        Student st3 = new Student("Mike 3", s4);
        Student st4 = new Student("Sandra 4", s2);
        Student st5 = new Student("Juan 5", s2);
        Student st6 = new Student("Daniel 6", s3);
        Student st7 = new Student("Chris 7", s3);
        Student st8 = new Student("Muvalek 8", s4);
        Student st9 = new Student("Alham 0", s5);
        Student st10 = new Student("Trevah 10", s5);
        System.out.println("---Registering students in the contest .....");

        contest.registerEntrant(st1);
        contest.registerEntrant(st2);
        contest.registerEntrant(st11);
        contest.registerEntrant(st3);
        contest.registerEntrant(st4);
        contest.registerEntrant(st5);
        contest.registerEntrant(st6);
        contest.registerEntrant(st7);
        contest.registerEntrant(st8);
        contest.registerEntrant(st9);
        contest.registerEntrant(st10);

        System.out.println(" Initialization complete.........");
        return contest;
    }

    private static int displayMenu() {
        Scanner input = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("============================");
            System.out.println("Maths Whiz! Championship Administration");
            System.out.println("============================");
            System.out.println("Please select an option below:\n1. Enter Results\n2.Display Results\n3. View Program Credits\n4. Exit program");
            option = input.nextInt();
        } while (option > 4 || option < 1);

        return option;
    }

    private static void displayCredits() {
        System.out.println("============================");
        System.out.println("Program Credits");
        System.out.println("This program wad developed by:\n\tMike Mike, student ID 300000\nfor ITECH1000 Programming 1 Semester 2 2017");
        System.out.println("============================");

    }

    private static void exit() {
        // message do you want to exit
        System.out.println("Thanks for using the Matchs Whiz| Championship Administration System");
        System.exit(0);
    }

}
