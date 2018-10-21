package com.pun;

import java.lang.reflect.Array;
import java.util.*;

public class Main {

    public static void main(String[] args) {

        // Challenge links are given above each function.

    }

    //https://www.hackerrank.com/challenges/drawing-book/problem
    static int pageCount(int n, int p) {
        int startingPage = 1;
        int turnCounter = 0;

        if (p == 1 || p == n) {
            return 0;
        } else if (p % 2 == 0) {
            turnCounter = p / 2;
        } else {
            turnCounter = (p-1) / 2;
        }

        if (p > n / 2) {
            return (n/2) - turnCounter;
        } else {
            return turnCounter;
        }
    }

    static void bonAppetit(List<Integer> bill, int k, int b) {
        int sum = 0;

        for (Integer i: bill) {
            sum += i;
        }

        int annaLoad = (sum - bill.get(k)) / 2 ;

        if (b == annaLoad) {
            System.out.println("Bon Appetit");
        } else {
            System.out.println(b - annaLoad);
        }
    }

    //https://www.hackerrank.com/challenges/day-of-the-programmer/problem
    static String dayOfProgrammer(int year) {
        int mergeYear = 1918;

        if (year > mergeYear) {
            if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0) ) {
                return "12.09." + year;
            } else {
                return "13.09." + year;
            }
        } else if (year == mergeYear) {

            return "26.09.1918";

        } else {
            if (year % 4 == 0) {
                return "12.09." + year;
            } else {
                return "13.09." + year;
            }
        }

    }

    //https://www.hackerrank.com/challenges/migratory-birds/problem
    static class Bird implements Comparable<Bird> {
        int type;
        int seenAmount;

        public Bird(int type, int seenAmount) {
            this.type = type;
            this.seenAmount = seenAmount;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getSeenAmount() {
            return seenAmount;
        }

        public void setSeenAmount(int seenAmount) {
            this.seenAmount = seenAmount;
        }

        @Override
        public int compareTo(Bird o) {
            return Integer.compare(this.seenAmount, o.seenAmount);
        }
    }

    static int migratoryBirds(List<Integer> arr) {
        Bird typeOne = new Bird(1,0);
        Bird typeTwo = new Bird(2,0);
        Bird typeThree = new Bird(3,0);
        Bird typeFour = new Bird(4,0);
        Bird typeFive = new Bird(5,0);

        Bird[] birdArray = {typeOne, typeTwo, typeThree, typeFour, typeFive};

        int maxAmount = 0;
        Bird birdWithMaxAmount = null;

        for (int i = 0; i < arr.size(); i++) {
            int amount;
            if (arr.get(i) == 1) {
                amount = typeOne.getSeenAmount();
                typeOne.setSeenAmount(amount + 1);
            } else if (arr.get(i) == 2) {
                amount = typeTwo.getSeenAmount();
                typeTwo.setSeenAmount(amount + 1);

            } else if (arr.get(i) == 3) {
                amount = typeThree.getSeenAmount();
                typeThree.setSeenAmount(amount + 1);

            } else if (arr.get(i) == 4) {
                amount = typeFour.getSeenAmount();
                typeFour.setSeenAmount(amount + 1);

            } else if (arr.get(i) == 5) {
                amount = typeFive.getSeenAmount();
                typeFive.setSeenAmount(amount + 1);

            }
        }

        for (int i = 0; i < birdArray.length; i++) {
            if (birdArray[i].getSeenAmount() > maxAmount) {
                maxAmount = birdArray[i].getSeenAmount();
                birdWithMaxAmount = birdArray[i];
            }
        }

        return birdWithMaxAmount.getType();

    }

    // https://www.hackerrank.com/challenges/divisible-sum-pairs/problem
    static int divisibleSumPairs(int n, int k, int[] ar) {
        Arrays.sort(ar);
        int intendedPairCount = 0;

        for (int i = 0; i < ar.length; i++) {
            for (int j = i+1; j < ar.length; j++) {
                if ((ar[i] + ar[j]) % k == 0) {
                    intendedPairCount++;

                }
            }
        }

        return intendedPairCount;

    }


    // https://www.hackerrank.com/challenges/the-birthday-bar/problem
    static int birthday(List<Integer> s, int d, int m) {
        int possibleWays = 0;

        for (int i = 0; i < s.size(); i++) {
            int sum = 0;

            if ((i + m) >= s.size()) {
                break;
            }

            for (int j = i; j < i + m; j++) {
                sum += s.get(j);
            }

            if (sum == d) {
                possibleWays++;
            }
        }

        return possibleWays;

    }

    // https://www.hackerrank.com/challenges/breaking-best-and-worst-records/problem
    static int[] breakingRecords(int[] scores) {
        int minBreakAmount = 0;
        int maxBreakAmount = 0;
        int minNumber = 0;
        int maxNumber = 0;

        for (int i = 0; i < scores.length; i++) {
            if (i == 0) {
                minNumber = scores[i];
                maxNumber = scores[i];
            } else {
                if (maxNumber < scores[i]) {
                    maxBreakAmount++;
                    maxNumber = scores[i];
                }

                if (minNumber > scores[i]) {
                    minBreakAmount++;
                    minNumber = scores[i];
                }
            }
        }

        return new int[]{maxBreakAmount, minBreakAmount};

    }

    // https://www.hackerrank.com/challenges/between-two-sets/problem
    static int getTotalX(int[] a, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        int count = 0;
        int module = 0;

        for (int i = a[a.length - 1]; i <= b[0]; i++) {
            System.out.println(i);

            for (int j = 0; j < a.length; j++) {
                module += i % a[j];
            }

            for (int k = 0; k < b.length; k++) {
                module += b[k] % i;
            }

            System.out.println(module);

            if (module == 0) {
                count++;
            }

            module = 0;
        }

        return count;

    }

    // https://www.hackerrank.com/challenges/kangaroo/problem
    static String kangaroo(int x1, int v1, int x2, int v2) {
        String returnValue = "NO";
        while (true) {
            if (x1 > x2) {
                break;
            }

            if (x1 == x2) {
                returnValue = "YES";
            }
            x1 += v1;
            x2 += v2;
        }

        return returnValue;

    }

    // https://www.hackerrank.com/challenges/apple-and-orange/problem
    static void countApplesAndOranges(int s, int t, int a, int b, int[] apples, int[] oranges) {
        int homeLength = t - s;
        int appleAmount = 0;
        int orangeAmount = 0;

        for (int i = 0; i < apples.length; i++) {
            if (s <= (a + apples[i]) && (a + apples[i]) <= t) {
                appleAmount++;
            }
        }

        for (int i = 0; i < oranges.length; i++) {
            if (s <= (b + oranges[i]) && (b + oranges[i]) <= t) {
                orangeAmount++;
            }
        }

        System.out.println(appleAmount);
        System.out.println(orangeAmount);


    }

    // https://www.hackerrank.com/challenges/grading/problem
    static int[] gradingStudents(int[] grades) {
        for (int i = 0; i < grades.length; i++) {
            if (grades[i] > 37 && grades[i] % 5 > 2) {
                int diff = 5 - (grades[i] % 5);
                grades[i] = grades[i] + diff;
            }
        }

        return grades;

    }

    // https://www.hackerrank.com/challenges/maximizing-xor/problem
    static int maximizingXor(int l, int r) {
        int maxValue = 0;

        for (int i = l; i < r; i++) {
            if (maxValue < (i ^ i+1)) {
                maxValue = i ^ i+1;
            }
        }

        return maxValue;
    }

    // https://www.hackerrank.com/challenges/lonely-integer/problem
    public static int lonelyInteger(int [] array) {
        int val = 0;
        for (int num : array) {
            val = val ^ num; // ^ is XOR operator
            System.out.println(val);
        }
        return val;
    }

    // https://www.hackerrank.com/challenges/pmix/problem
    static String pmix(String s, int k) {
        char[] initialChars = s.toCharArray();
        char previousFirstChar = ' ';


        for (int j = 0; j < k; j++) {
            previousFirstChar = initialChars[0];
            for (int i = 0; i < s.length(); i++) {
                if (i == s.length()-1) {
                    if (initialChars[i] == 'A' && previousFirstChar == 'A') {
                        initialChars[i] = 'A';
                    } else if (initialChars[i] == 'A' && previousFirstChar == 'B') {
                        initialChars[i] = 'B';
                    } else if (initialChars[i] == 'A' && previousFirstChar == 'C') {
                        initialChars[i] = 'C';
                    } else if (initialChars[i] == 'A' && previousFirstChar == 'D') {
                        initialChars[i] = 'D';
                    } else if (initialChars[i] == 'B' && previousFirstChar == 'A') {
                        initialChars[i] = 'B';
                    } else if (initialChars[i] == 'B' && previousFirstChar == 'B') {
                        initialChars[i] = 'A';
                    } else if (initialChars[i] == 'B' && previousFirstChar == 'C') {
                        initialChars[i] = 'D';
                    } else if (initialChars[i] == 'B' && previousFirstChar == 'D') {
                        initialChars[i] = 'C';
                    } else if (initialChars[i] == 'C' && previousFirstChar == 'A') {
                        initialChars[i] = 'C';
                    } else if (initialChars[i] == 'C' && previousFirstChar == 'B') {
                        initialChars[i] = 'D';
                    } else if (initialChars[i] == 'C' && previousFirstChar == 'C') {
                        initialChars[i] = 'A';
                    } else if (initialChars[i] == 'C' && previousFirstChar == 'D') {
                        initialChars[i] = 'B';
                    } else if (initialChars[i] == 'D' && previousFirstChar == 'A') {
                        initialChars[i] = 'D';
                    } else if (initialChars[i] == 'D' && previousFirstChar == 'B') {
                        initialChars[i] = 'C';
                    } else if (initialChars[i] == 'D' && previousFirstChar == 'C') {
                        initialChars[i] = 'B';
                    } else if (initialChars[i] == 'D' && previousFirstChar == 'D') {
                        initialChars[i] = 'A';
                    }

                } else {
                    if (initialChars[i] == 'A' && initialChars[i+1] == 'A') {
                        initialChars[i] = 'A';
                    } else if (initialChars[i] == 'A' && initialChars[i+1] == 'B') {
                        initialChars[i] = 'B';
                    } else if (initialChars[i] == 'A' && initialChars[i+1] == 'C') {
                        initialChars[i] = 'C';
                    } else if (initialChars[i] == 'A' && initialChars[i+1] == 'D') {
                        initialChars[i] = 'D';
                    } else if (initialChars[i] == 'B' && initialChars[i+1] == 'A') {
                        initialChars[i] = 'B';
                    } else if (initialChars[i] == 'B' && initialChars[i+1] == 'B') {
                        initialChars[i] = 'A';
                    } else if (initialChars[i] == 'B' && initialChars[i+1] == 'C') {
                        initialChars[i] = 'D';
                    } else if (initialChars[i] == 'B' && initialChars[i+1] == 'D') {
                        initialChars[i] = 'C';
                    } else if (initialChars[i] == 'C' && initialChars[i+1] == 'A') {
                        initialChars[i] = 'C';
                    } else if (initialChars[i] == 'C' && initialChars[i+1] == 'B') {
                        initialChars[i] = 'D';
                    } else if (initialChars[i] == 'C' && initialChars[i+1] == 'C') {
                        initialChars[i] = 'A';
                    } else if (initialChars[i] == 'C' && initialChars[i+1] == 'D') {
                        initialChars[i] = 'B';
                    } else if (initialChars[i] == 'D' && initialChars[i+1] == 'A') {
                        initialChars[i] = 'D';
                    } else if (initialChars[i] == 'D' && initialChars[i+1] == 'B') {
                        initialChars[i] = 'C';
                    } else if (initialChars[i] == 'D' && initialChars[i+1] == 'C') {
                        initialChars[i] = 'B';
                    } else if (initialChars[i] == 'D' && initialChars[i+1] == 'D') {
                        initialChars[i] = 'A';
                    }
                }
            }
        }

        return new String(initialChars);

    }

    // https://www.hackerrank.com/challenges/staircase/problem
    static void staircase(int n) {
        for (int i = 1; i <= n; i++) {
            String printString = "";
            char[] repeat = new char[i];
            char[] blanks = new char[n-i];
            Arrays.fill(repeat, '#');
            Arrays.fill(blanks, ' ');
            printString += new String(blanks);
            printString += new String(repeat);
            System.out.printf(printString);
            System.out.println();
        }
    }

    // https://www.hackerrank.com/challenges/plus-minus/problem
    static void plusMinus(int[] arr) {
        int positiveCount = 0;
        int negativeCount = 0;
        int zeroCount = 0;

        double positiveRatio = 0;
        double negativeRatio = 0;
        double zeroRatio = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                positiveCount++;
            } else if (arr[i] < 0) {
                negativeCount++;
            } else {
                zeroCount++;
            }
        }

        positiveRatio = (double)positiveCount / arr.length;
        System.out.println(positiveRatio);

        negativeRatio = (double)negativeCount / arr.length;
        System.out.println(negativeRatio);

        zeroRatio = (double)zeroCount / arr.length;
        System.out.println(zeroRatio);
    }


    // https://www.hackerrank.com/challenges/diagonal-difference/problem
    static int diagonalDifference(int[][] arr) {
        int length = arr.length - 1;
        int leftSum = 0;
        int rightSum = 0;

        for (int i = 0; i < arr.length; i++) {
            leftSum += arr[i][i];
            rightSum += arr[length][i];
            length--;
        }

        return Math.abs(leftSum-rightSum);

    }

    static void minimumBribes(int[] q) {

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < q.length; i++) {
            map.put(i, q[i]);
        }

        int[] sorted = q;

        Arrays.sort(sorted);

        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i] != q[i]) {
                if (sorted[i] == q[i+3]) {
                    System.out.println("Too chaotic");
                }
            }
        }


    }

    // https://www.hackerrank.com/challenges/repeated-string/problem
    static long repeatedString(String s, long n) {
        String build = "";
        long aCounter = 0;

        if (s.equals("a") || s.equals("aa") || s.equals("aaa")) {
            return n;
        }

        while (build.length() < n) {
            build += s;
        }

        String lengthString = build.substring(0,(int)n);

        for (Character c: lengthString.toCharArray()) {
            if (c.equals('a')) {
                aCounter++;
            }
        }

        return aCounter;

    }

    // https://www.hackerrank.com/challenges/counting-valleys/problem
    static int countingValleys(int n, String s) {
        int valleyAmount = 0;
        int currentAltitude = 0;


        for (Character c: s.toCharArray()) {
            int latestAltitude = currentAltitude;
            if (c.equals('U')) {
                currentAltitude++;
            } else if (c.equals('D')) {
                currentAltitude--;
            }

            if (latestAltitude < 0 && currentAltitude >= 0) {
                valleyAmount++;
            }
        }

        return valleyAmount;

    }

    // https://www.hackerrank.com/challenges/jumping-on-the-clouds/problem
    static int jumpingOnClouds(int[] c) {
        int numberOfJumps = 0;

        for (int i = 0; i < c.length; i++) {
            if ((i+2) < c.length && c[i+2] == 1) {
                numberOfJumps++;
            } else {

                if (i+1 < c.length) {
                    numberOfJumps++;
                    i++;
                }
            }
        }

        return numberOfJumps;


    }

    // https://www.hackerrank.com/challenges/sock-merchant/problem
    static int sockMerchant(int n, int[] ar) {
        int numberOfPairs = 0;

        Set<Integer> colors = new HashSet<>();

        for (int i = 0; i < ar.length; i++) {
            if (!colors.contains(ar[i])) {
                colors.add(ar[i]);
            } else {
                numberOfPairs++;
                colors.remove(ar[i]);
            }
        }

        return numberOfPairs;
    }
}
