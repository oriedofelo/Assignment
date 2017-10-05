package com.mathscontest;

import com.sun.org.apache.xerces.internal.util.IntStack;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Contest {

    private String name;
    private final int MAX_ENTRANTS;
    private final int NUMBER_OF_QUESTIONS;
    private final int MAX_SCHOOL_ENTRANTS;
    private Entry[] entries;
    private int count = 0;

    public Contest(String _name, int ME, int NoQ, int MSE) {
        name = _name;
        MAX_ENTRANTS = ME;
        NUMBER_OF_QUESTIONS = NoQ;
        MAX_SCHOOL_ENTRANTS = MSE;
        entries = new Entry[MAX_ENTRANTS];

    }

    public String getContestName() {
        return name;
    }

    public int getEntrantLimit() {
        return MAX_SCHOOL_ENTRANTS;
    }

    public int getNumberOfQuestions() {
        return NUMBER_OF_QUESTIONS;
    }

    public boolean capacityReached() {
        if (count >= MAX_ENTRANTS) {
            return true;
        } else {
            return false;
        }

    }

    public boolean checkSchools(School school) {
        int regCount = 0;
        for (Entry entry : entries) {
            if (entry != null) {
                if (school.getRegistrationID().equals(entry.getEntrant().getSchool().getRegistrationID())) {
                    entry.getEntrant().getSchool();
                    regCount++;
                }
            }
        }
        if (regCount >= MAX_SCHOOL_ENTRANTS) {
            return true;
        } else {
            return false;
        }

    }

    public void enterScores() {
        Scanner inp = new Scanner(System.in);
        int score = 0;
        for (int noq = 1; noq <= getNumberOfQuestions(); noq++) {
            System.out.println("Score for Question " + noq);
            for (int index = 0; index < MAX_ENTRANTS; index++) {
                Entry entry = entries[index];
                String name = entry.getEntrant().getName();
                System.out.println("Enter score for " + name);
                score = inp.nextInt();
                entry.setScore(score);
            }
        }
        System.out.println("Score entry complete");
    }

    public void viewContestScores() {
        System.out.println("============================"); // in for loop
        System.out.println("Maths Whiz! Championship Results");

        int[] scoreTotals = new int[MAX_ENTRANTS];

        for (int index = 0; index < entries.length; index++) {
            for (int index2 = index; index2 < MAX_ENTRANTS; index2++) {
                scoreTotals[index2] = entries[index].totalScore();
            }

        }
        sortResults(entries);
        for (int i = 0; i < entries.length; i++) {
            System.out.println("Total Score for : " + entries[i].getEntrant().getName() + " " + entries[i].totalScore());
        }

        System.out.println("First : " + entries[0].getEntrant().getName() + " from " + entries[0].getEntrant().getSchool().getName());
        System.out.println("Second : " + entries[1].getEntrant().getName() + " from " + entries[1].getEntrant().getSchool().getName());
        System.out.println("Third : " + entries[2].getEntrant().getName() + " from " + entries[2].getEntrant().getSchool().getName());

    }

    private void sortResults(Entry[] entries) {
        // sort the results from highest to lowest
        MergeSort mergeSort = new MergeSort(entries);
        mergeSort.sortEntry();

    }

    public void registerEntrant(Student s) {
        if (!capacityReached()) {
            // 1. check if the student is not already in the entries.// call checkStudent(..)
            // 2. check if the number of entries is not exceeded for the school// call chackSchools(...)
            if (!checkStudent(s)) {
                if (checkSchools(s.getSchool())) {
                    System.out.println("Unable to register " + s.getName() + ". School registration limit met.");
                } else {
                    entries[count] = new Entry(s, NUMBER_OF_QUESTIONS);
                    count = count + 1;
                    System.out.println("Successfully registered " + s.getName() + " representing " + s.getSchool().getName());
                }
            } else {
                System.out.println("Unable to register " + s.getName() + ". Duplicate registration.");
            }
        } else {
            System.out.println("Unable to register " + s.getName() + ". Contest registration limit met.");
        }
    }

    private boolean schoolLimitReached(School school) {
        // check to see if the number of schools does not exceed limit

        return false;
    }

    private boolean checkStudent(Student s) {
        for (Entry entry : entries) {
            if (entry != null) {
                if (entry.getEntrant().getName().equals(s.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

}
