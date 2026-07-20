package task340;

import java.util.ArrayList;
import java.util.Scanner;

public class ScoreManagementSystem {
    //initialize required variables
    ArrayList<Integer> scores = new ArrayList<Integer>();
    ArrayList<Integer> scoresSorted;
    ArrayList<Integer> scoresSortedReversed;

    int total;
    float average;
    int highestScore;
    int lowestScore;

    int passCount;
    int failCount;
    int excellentCount;
    int lowCount;

    Integer score;
    int index;
    int repeat;

    //initialize scanner to read input
    Scanner in = new Scanner(System.in);

    void main() {
        //add 15 student scores
        scores.add(83);
        scores.add(67);
        scores.add(100);
        scores.add(78);
        scores.add(99);
        scores.add(96);
        scores.add(14);
        scores.add(81);
        scores.add(35);
        scores.add(68);
        scores.add(54);
        scores.add(88);
        scores.add(95);
        scores.add(0);
        scores.add(71);

        //call functions
        displayScoreInformation();

        scoreStatistics();

        scoreClassification();

        searchScore();

        updateArray();

        //remove a score by name
        System.out.println("\n----- Remove Score by name -----");
        System.out.print("Enter Score: ");
        score = in.nextInt();
        removeScore(score);

        //remove a Score by index
        System.out.println("\n----- Remove Score by index -----");
        System.out.print("Enter index: ");
        index = in.nextInt();
        removeScore(index);

        sortAndReverse();
    }

    public void displayScoreInformation() {
        System.out.println("\n----- Display Score Information -----");
        System.out.println("Total number of Scores: " + scores.size());

        //display each score with its index
        System.out.println("\nScores -----");
        for (int i = 0; i < scores.size(); i++) {
            System.out.println("Score " + i + ": " + scores.get(i));//print number
        }
    }

    public void scoreStatistics() {
        System.out.println("\n----- Display Score Statistics -----");
        //set total to 0 as a start
        total = 0;

        //assume largest and smallest are the first element on the list
        highestScore = scores.get(0);
        lowestScore = scores.get(0);

        //loop through numbers to update above variables
        for (int i = 0; i < scores.size(); i++) {
            total += scores.get(i);
            if (scores.get(i) > highestScore) highestScore = scores.get(i);
            else if (scores.get(i) < lowestScore) lowestScore = scores.get(i);
        }

        //calculate average
        average = (float) total / scores.size();
        //display header and information
        System.out.println("Total scores: " + total);
        System.out.println("Average: " + average);
        System.out.println("Highest Score: " + highestScore);
        System.out.println("Lowest Score: " + lowestScore);
    }

    //function to classify scores
    public void scoreClassification() {
        System.out.println("\n----- Display Score Classification -----");
        //set counts to 0
        passCount = 0;
        failCount = 0;
        excellentCount = 0;
        lowCount = 0;

        //loop to update counts
        for (int score : scores) {
            //pass fail counts update
            if (score >= 60) passCount++;
            else failCount++;

            //excellent low counts uppdate
            if (score >= 90) excellentCount++;
            else if (score < 50) lowCount++;
        }

        //display results
        System.out.println("Number of students who passed: " + passCount);
        System.out.println("Number of students who failed: " + failCount);
        System.out.println("Number of students with excellent grades : " + excellentCount);
        System.out.println("Number of students with low grades : " + lowCount);
    }

    //function to search score
    public void searchScore() {
        System.out.println("\n----- Search System -----");

        //ask user for input
        System.out.print("Enter a score: ");
        score = in.nextInt();

        //check if number exists
        index = scores.indexOf(score);
        if (index != -1) {
            System.out.println("First index: " + index);
            //how many times it repeated
            for (int i = 0; i < scores.size(); i++) {
                if (scores.get(i).equals(score)) {
                    repeat++;
                }
            }

            //display result
            System.out.println("Occurrences: " + repeat);

        } else {
            System.out.println("Score not found!");
        }
    }

    //function to update score
    public void updateArray() {
        System.out.println("\n----- Update Score System -----");

        //ask user for input
        System.out.print("Enter an index number: ");
        index = in.nextInt();
        System.out.print("Enter the new value: ");
        score = in.nextInt();

        //update value
        if (index < scores.size()) {
            scores.set(index, score);
            System.out.println("updated list: " + scores.toString());
        } else {
            System.out.println("Index out of range");
        }

    }

    //function to remove a score
    //by name
    public void removeScore(Integer num) {
        if (scores.contains(num)) {
            scores.remove(num);
            System.out.println("Updated list: " + scores.toString());
        } else {
            System.out.println("Score not found");
        }
    }

    //by index
    public void removeScore(int position) {
        if (position < scores.size()) {
            scores.remove(position);
            System.out.println("Updated list: " + scores.toString());
        } else {
            System.out.println("Index out of range");
        }
    }

    //sorting and reversing an array
    public void sortAndReverse() {
        System.out.println("\n----- Sorting and Reversing -----");
        //sorting
        scoresSorted = new ArrayList<Integer>(scores); //copied numbers to this new array
        for (int i = 0; i < scoresSorted.size(); i++) {
            for (int j = i + 1; j < scoresSorted.size(); j++) {
                //compare and swap if smaller
                if (scoresSorted.get(i) > scoresSorted.get(j)) {
                    //swap
                    score = scoresSorted.get(i);
                    scoresSorted.set(i, scoresSorted.get(j));
                    scoresSorted.set(j, score);
                }
            }
        }

        //Reversing
        scoresSortedReversed = new ArrayList<Integer>();
        //loop numbers from last to first and add to reversedlist
        for (int i = scoresSorted.size() - 1; i >= 0; i--) {
            scoresSortedReversed.add(scoresSorted.get(i));
        }

        //display results
        System.out.println("original: " + score.toString());
        System.out.println("Sorted: " + scoresSorted.toString());
        System.out.println("Sorted and reversed: " + scoresSortedReversed.toString());
    }
}
