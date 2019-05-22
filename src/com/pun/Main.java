package com.pun;

import java.lang.reflect.Array;
import java.math.BigInteger;
import java.util.*;
import java.util.Stack;
import java.util.HashMap;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;

import static java.lang.Math.abs;

public class Main {

    public static void main(String[] args) {


    }

    //https://www.hackerrank.com/challenges/minimum-absolute-difference-in-an-array/problem
    //Complexity increases without Java built-in sort algorithm.
    static int minimumAbsoluteDifference(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        Arrays.sort(arr);
        for (int i = 1; i < arr.length; i++) {
            int diff = arr[i] - arr[i-1];
            if (diff == 0) {
                return 0;
            }
            if ((diff) < minDiff) {
                minDiff = arr[i] - arr[i-1];
            }
        }

        return minDiff;
    }

    //https://www.hackerrank.com/challenges/ctci-making-anagrams/problem
    static int makeAnagram(String a, String b) {
        HashMap<Character, Integer> dictionaryA = new HashMap<>();
        HashMap<Character, Integer> dictionaryB = new HashMap<>();
        int counter = 0;

        for (char c: a.toCharArray()) {
            if (!dictionaryA.containsKey(c)) {
                dictionaryA.put(c,1);
            } else {
                dictionaryA.put(c, dictionaryA.get(c) + 1);
            }
        }

        for (char c: b.toCharArray()) {
            if (!dictionaryB.containsKey(c)) {
                dictionaryB.put(c,1);
            } else {
                dictionaryB.put(c, dictionaryB.get(c) + 1);
            }
        }

        for (Character key: dictionaryA.keySet()) {
            if (dictionaryB.containsKey(key)) {
                if (!dictionaryB.get(key).equals(dictionaryA.get(key))) {
                    counter += abs(dictionaryA.get(key) - dictionaryB.get(key));
                }
            } else {
                counter += dictionaryA.get(key);
            }
        }

        for (Character key: dictionaryB.keySet()) {
            if (!dictionaryA.containsKey(key)) {
                counter += dictionaryB.get(key);
            }
        }

        return counter;

    }

    //https://www.hackerrank.com/challenges/two-strings/problem
    static String twoStrings(String s1, String s2) {
        Set<Character> first = new HashSet<>();
        Set<Character> second = new HashSet<>();

        for (char c: s1.toCharArray()) {
            first.add(c);
        }

        for (char c: s2.toCharArray()) {
            second.add(c);
        }

        for (char c: first) {
            if (second.contains(c)) {
                return "YES";
            }
        }

        return "NO";
    }

    //https://www.hackerrank.com/contests/projecteuler/challenges/euler006
    static void sumSquareDifference(long limit) {
        long smallerSum = 0;
        long largerSum = 0;
        for (int i = 1; i <= limit; i++) {
            smallerSum += i;
            largerSum += i*i;
        }

        System.out.println((smallerSum * smallerSum) - largerSum);
    }

    //https://www.hackerrank.com/contests/projecteuler/challenges/euler005/problem
    static int smallestDivisor(int upper) {
        int numb = upper;
        boolean hasFound = true;
        while (true) {
            for (int i = 1; i <= upper; i++) {
                if (numb % i != 0) {
                    hasFound = false;
                    break;
                }

                hasFound = true;
            }
            if (hasFound) {
                break;
            } else {
                numb++;
            }
        }

        return numb;
    }

    //https://www.hackerrank.com/contests/projecteuler/challenges/euler004
    //1/2 method of the question
    static long threeDigitsPalindrome(long value) {
        long largest = 0;

        for (int i = 100; i <= 999; i++) {
            for (int j = 100; j<= 999; j++) {

                if (i*j < value && i*j > largest) {
                    if (isPalindrome(i*j)) {
                        largest = i*j;
                    }
                }
            }
        }

        return largest;

    }

    //https://www.hackerrank.com/contests/projecteuler/challenges/euler004
    //2/2 method of the question
    static boolean isPalindrome(long value) {
        long reverse = 0;
        long original = value;
        while(value > 0) {

            reverse *= 10;
            reverse += (value % 10);
            value /= 10;
        }

        if (reverse == original) {
            return true;
        }

        return false;
    }



    //https://www.hackerrank.com/contests/projecteuler/challenges/euler003
    static long largestPrimeThing(long value) {
        long largestPrime = 0;
        for (int i = 0; i <= value; i++) {
            if (value % i == 0) {
                boolean isPrime = true;
                for (int j = 2; j < i; j++) {
                    if (i % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if (isPrime) {
                    largestPrime = i;
                }
            }
        }

        return largestPrime;
    }

    //https://www.hackerrank.com/contests/projecteuler/challenges/euler002
    static long oddSumFibonacciThing(long value) {
        long sum = 0;
        int previous = 0;
        int current = 1;

        while (current < value) {
            int val = current + previous;
            if (val % 2 == 0 && val < value) {
                sum += val;
            }

            previous = current;
            current = val;
        }

        return sum;

    }

    //https://www.hackerrank.com/contests/projecteuler/challenges/euler001
    static int threeNFiveMultiplierFinder(int value) {
        int sum = 0;

        for (int i = 0; i < value; i++) {
            if(i % 3 == 0) {
                sum += i;
            } else if (i % 5 == 0) {
                sum += i;
            }
        }

        return sum;

    }

    static void converter(String numb) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        hashMap.put("zero",0);
        hashMap.put("one",1);
        hashMap.put("two",2);
        hashMap.put("three",3);
        hashMap.put("four",4);
        hashMap.put("five",5);
        hashMap.put("six",6);
        hashMap.put("seven",7);
        hashMap.put("eight",8);
        hashMap.put("nine",9);
        hashMap.put("ten",10);
        hashMap.put("eleven",11);
        hashMap.put("twelve",12);
        hashMap.put("thirteen",13);
        hashMap.put("fourteen",14);
        hashMap.put("fifteen",15);
        hashMap.put("sixteen",16);
        hashMap.put("seventeen",17);
        hashMap.put("eighteen",18);
        hashMap.put("nineteen",19);
        hashMap.put("twenty",20);
        hashMap.put("thirty",30);
        hashMap.put("forty",40);
        hashMap.put("fifty",50);
        hashMap.put("sixty",60);
        hashMap.put("seventy",70);
        hashMap.put("eighty",80);
        hashMap.put("ninety",90);
        hashMap.put("hundred",100);
        hashMap.put("thousand",1000);
        hashMap.put("million",1000000);
        hashMap.put("negative",-1);
        int result = 0;
        String[] wordArray = numb.split(" ");

        int endMultiplier = 1;

        int previous = 1;

        if (wordArray[0].equals("negative")) {
            endMultiplier *= -1;
        }

        for (int i = 0; i < wordArray.length; i++) {
            if(wordArray[i].equals("negative")) {
                continue;
            }
            int val = hashMap.get(wordArray[i]);
            if (val == 100) {
                result += val*previous;
            } else if (val < 10 && (wordArray.length - i) >= 2) {

            } else {
                result += val;
            }
            previous = val;
        }

        System.out.println(result * endMultiplier);

    }

    static void remover(String input) {
        String[] divided = input.split(",");
        String actual = divided[0];
        String charsToRemove = divided[1];
        char[] chars = charsToRemove.toCharArray();

        for (char character: chars) {
            String charAsString = "" + character;
            actual = actual.replace(charAsString, "");
        }

        System.out.println(actual);
    }

    //https://www.hackerrank.com/challenges/jesse-and-cookies/problem
    static int cookies(int k, int[] A) {
        Queue<Integer> queue = new PriorityQueue<>();
        int counter = 0;
        for (Integer element: A) {
            queue.add(element);
        }

        while (queue.size() > 1) {
            if (queue.peek() > k) {
                return counter;
            }

            Stack<String> myStack = new Stack<>();

            int lowest = queue.poll();
            int second = queue.poll();
            int temp = lowest + 2 * second;
            queue.add(temp);
            counter++;
        }

        if (queue.size() >= 1 && queue.peek() > k) {
            return counter;
        } else {
            return -1;
        }
    }

    static boolean check(String line) {
        Stack<Character> inputStack = new Stack();
        for (int i = 0; i < line.length(); i++) {
            char character = line.charAt(i);
            if (character == '(' || character == '{' || character == '[') {
                inputStack.push(character);
            } else if (character == ']') {
                if (inputStack.pop() != '[' ) {
                    return false;
                }
            } else if (character == '}') {
                if (inputStack.pop() != '{') {
                    return false;
                }
            } else if (character == ')') {
                if (inputStack.pop() != '(') {
                    return false;
                }
            }
        }

        return true;
    }

    //https://www.hackerrank.com/challenges/ctci-ransom-note/problem
    static void checkMagazine(String[] magazine, String[] note) {
        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String word: magazine) {
            if (!hashMap.containsKey(word)) {
                hashMap.put(word,1);
            } else {
                int count = hashMap.get(word);
                hashMap.replace(word, count, count+1);
            }
        }

        for (String word: note) {
            if (!hashMap.containsKey(word)) {
                System.out.println("No");
                return;
            } else {
                int count = hashMap.get(word);
                if (count <= 0) {
                    System.out.println("No");
                    return;
                }
                hashMap.replace(word, count, count - 1);
            }
        }

        System.out.println("Yes");
    }

    static int findMergeNode(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        while (head1 != null && head2 != null) {
            System.out.println(head1.data);
            System.out.println(head2.data);

            head1 = head1.next;
            head2 = head2.next;
        }

        return 1;

    }

    //https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
    //ref: https://en.wikipedia.org/wiki/Cycle_detection
    static boolean hasCycle(SinglyLinkedListNode head) {
        SinglyLinkedListNode slow = head;
        SinglyLinkedListNode fast = head;

        while (head != null && head.next != null) {
            try {
                slow = slow.next;
                fast = fast.next.next;

                if (slow == fast) {
                    return true;
                }
            } catch (NullPointerException n) {
                break;
            }
        }

        return false;
    }

    //https://www.hackerrank.com/challenges/delete-duplicate-value-nodes-from-a-sorted-linked-list/problem
    static SinglyLinkedListNode removeDuplicates(SinglyLinkedListNode head) {
        SinglyLinkedListNode temp = head;
        while (temp != null) {
            try {
                if (temp.data == temp.next.data) {
                    temp.next = temp.next.next;
                    continue;
                }

                temp = temp.next;
            } catch (NullPointerException n) {
                break;
            }
        }

        return head;
    }

    //https://www.hackerrank.com/challenges/get-the-value-of-the-node-at-a-specific-position-from-the-tail/problem
    static int getNode(SinglyLinkedListNode head, int positionFromTail) {
        //Space complexity increased to gain time complexity.
        //We could also go with iterative approach to have O(1) space complexity.
        List<SinglyLinkedListNode> nodeList = new ArrayList<>();

        while (head != null) {
            nodeList.add(head);
            head = head.next;
        }

        return nodeList.get(nodeList.size() - 1 - positionFromTail).data;

    }

    //https://www.hackerrank.com/challenges/merge-two-sorted-linked-lists/problem
    static SinglyLinkedListNode mergeLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {
        SinglyLinkedListNode head3;
        if (head1.data < head2.data) {
            head3 = head1;
        } else {
            head3 = head2;
        }

        SinglyLinkedListNode tempHead = head3;
        while (head1 != null && head2 != null) {
            if (head1.data < head2.data) {
                tempHead.next = head1;
                head1 = head1.next;
            } else {
                tempHead.next = head2;
                head2 = head2.next;
            }

            tempHead = tempHead.next;
        }

        if (head1 == null) {
            tempHead.next = head2;
        } else {
            tempHead.next = head1;
        }

        return head3;
    }

    //https://www.hackerrank.com/challenges/compare-two-linked-lists/problem
    static boolean compareLists(SinglyLinkedListNode head1, SinglyLinkedListNode head2) {

        while (head1 != null && head2 != null) {
            if (head1.data != head2.data) {
                return false;
            }

            head1 = head1.next;
            head2 = head2.next;
        }

        return head1 == head2;

    }

    //https://www.hackerrank.com/challenges/reverse-a-linked-list/problem
    static SinglyLinkedListNode reverse(SinglyLinkedListNode head) {
        if (head == null) {
            return null;
        }

        SinglyLinkedListNode currentNode;
        SinglyLinkedListNode prev;
        SinglyLinkedListNode nextNode;
        prev = null;
        currentNode = head;

        while (currentNode != null) {
            nextNode = currentNode.next;
            currentNode.next = prev;
            prev = currentNode;
            currentNode = nextNode;
        }

        return prev;

    }

    //https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list-in-reverse/problem
    static void reversePrint(SinglyLinkedListNode head) {
        List<Integer> list = new ArrayList();
        if (head == null) {
            return;
        }

        while (head != null) {
            list.add(head.data);
            head = head.next;
        }

        for (int i = list.size() - 1; i >= 0; i--) {
            System.out.println(list.get(i));
        }

        // Could use stack as well.

    }

    //https://www.hackerrank.com/challenges/delete-a-node-from-a-linked-list/problem
    static SinglyLinkedListNode deleteNode(SinglyLinkedListNode head, int position) {
        if(position == 0) {
            head = head.next;
        } else {
            SinglyLinkedListNode current;
            current = head;

            for(int i=0;i<position-1;i++){
                current=current.next;
            }

            current.next = current.next.next;
        }

        return head;


    }

    //https://www.hackerrank.com/challenges/insert-a-node-at-a-specific-position-in-a-linked-list/problem
    static SinglyLinkedListNode insertNodeAtPosition(SinglyLinkedListNode head, int data, int position) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (head == null) {
            return newNode;
        }

        SinglyLinkedListNode node = head;
        int counter = 0;
        while (node.next != null) {
            node = node.next;
            counter++;
            if (counter == position - 1) {
                SinglyLinkedListNode temp = node.next;
                node.next = newNode;
                newNode.next = temp;
                break;
            }
        }

        return head;

    }

    //https://www.hackerrank.com/challenges/insert-a-node-at-the-head-of-a-linked-list/problem
    static SinglyLinkedListNode insertNodeAtHead(SinglyLinkedListNode llist, int data) {
        SinglyLinkedListNode newNode = new SinglyLinkedListNode(data);
        if (llist != null) {
            newNode.next = llist;
        } else {
            return newNode;
        }

        return newNode;
    }

    //https://www.hackerrank.com/challenges/insert-a-node-at-the-tail-of-a-linked-list/problem
    static SinglyLinkedListNode insertNodeAtTail(SinglyLinkedListNode head, int data) {
        SinglyLinkedListNode node = new SinglyLinkedListNode(data);
        node.next = null;
        if (head == null) {
            head = node;
        } else {
            SinglyLinkedListNode tail = head;
            while(tail.next != null) {
                tail = tail.next;
            }
            tail.next = node;
        }

        return head;
    }

    //https://www.hackerrank.com/challenges/print-the-elements-of-a-linked-list/problem
    static void printLinkedList(SinglyLinkedListNode head) {
        System.out.println(head.data);
        if (head.next != null) {
            printLinkedList(head.next);
        }

    }

    //https://www.hackerrank.com/challenges/encryption/problem
    static String encryption(String s) {
        int numb = s.length();
        int lower = (int)Math.sqrt(numb);
        int upper = lower + 1;

        if ((lower * upper) < numb) {
            lower = upper;
        }

        System.out.println(lower);
        System.out.println(upper);

        String[][] grid = new String[lower][upper];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                try {
                    char c = s.charAt((upper * i) + j);
                    grid[i][j] = Character.toString(c);
                } catch (IndexOutOfBoundsException e) {
                    grid[i][j] = " ";
                }
            }
        }

        List<Character> build = new ArrayList<>();
        char lastChar = ' ';

        for (int i = 0; i < upper; i++) {
            for (int j = 0; j < lower; j++) {
                build.add((grid[j][i]).charAt(0));
                lastChar = (grid[j][i]).charAt(0);
            }

            if (lastChar != ' ') {
                build.add(" ".charAt(0));
            }
        }

        StringBuilder builder = new StringBuilder(build.size());
        for (Character c: build) {
            builder.append(c);
        }

        return builder.toString();

    }

    //https://www.hackerrank.com/challenges/equality-in-a-array/problem
    static int equalizeArray(int[] arr) {
        Map<Integer, Integer> numbers = new HashMap<>();
        int mostOccurringNumb = 0;
        int maxAmount = 0;
        int removeCount = 0;

        for(int i: arr) {
            if (numbers.containsKey(i)) {
                int amount = numbers.get(i);
                amount++;
                numbers.put(i, amount);

                if (amount > maxAmount) {
                    mostOccurringNumb = i;
                    maxAmount = amount;
                }

            } else {
                numbers.put(i, 1);
            }
        }


        for(int i: arr) {
            if (i != mostOccurringNumb) {
                removeCount++;
            }
        }

        if (maxAmount > 0) {
            return removeCount;
        } else {
            return arr.length;
        }
    }

    //https://www.hackerrank.com/challenges/permutation-equation/problem
    static int[] permutationEquation(int[] p) {
        HashMap<Integer, Integer> dictionary = new HashMap<>();

        for (int i = 0; i < p.length; i++) {
            dictionary.put(p[i], i+1);
        }

        int[] returnArray = new int[p.length];

        for(int i = 1; i <= p.length; i++) {
            returnArray[i] = (dictionary.get(dictionary.get(i)));
        }

        return returnArray;
    }

    //https://www.hackerrank.com/challenges/extra-long-factorials/problem
    static void extraLongFactorials(int n) {
        BigInteger factorial = BigInteger.valueOf(1);

        while (n > 0) {
            factorial = factorial.multiply(BigInteger.valueOf(n));
            n--;
        }

        System.out.println(factorial);

    }

    //https://www.hackerrank.com/challenges/find-digits/problem
    static int findDigits(int n) {
        int count = 0;
        int digit = 0;
        int innerN = n;
        while (innerN > 0) {
            digit = innerN % 10;
            innerN /= 10;
            if (digit != 0 && n % digit == 0) {
                count++;
            }
        }

        return count;
    }

    //https://www.hackerrank.com/challenges/jumping-on-the-clouds-revisited/problem
    //One test case will always fail, its a bug.
    static int jumpingOnClouds(int[] c, int k) {
        int e = 100;
        int n = c.length;
        int index = 0;
        int current;

        do {
            index = (index + k) % n;
            current = c[index];

            if (current == 1) {
                e -= 3;
            } else {
                e -= 1;
            }

        } while (index != 0);

        return e;

    }

    //https://www.hackerrank.com/challenges/cut-the-sticks/problem
    static int[] cutTheSticks(int[] arr) {

        List<Integer> returnArray = new ArrayList<>();

        Arrays.sort(arr);

        int prev = -1;

        for (int i = 0; i < arr.length; i++) {
            int counter = 0;

            if (prev == arr[i]) {
                continue;
            }

            for (int j = 0; j < arr.length; j++) {

                if (arr[j] - arr[i] >= 0) {
                    counter++;
                }
            }

            returnArray.add(counter);
            prev = arr[i];
        }

        int[] result = new int[returnArray.size()];

        for (int i = 0; i < returnArray.size(); i++) {
            result[i] = returnArray.get(i);
        }

        return result;

    }

    //https://www.hackerrank.com/challenges/library-fine/problem
    static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {
        if (y1 > y2) {
            return (y1-y2) * 10000;
        } else if (y1 == y2) {
            if (m1 > m2) {
                return (m1 - m2) * 500;
            } else if (m1 == m2) {
                if (d1 > d2) {
                    return (d1 - d2) * 15;
                } else {
                    return 0;
                }
            } else {
                return 0;
            }
        } else {
            return 0;
        }
    }

    //https://www.hackerrank.com/challenges/sherlock-and-squares/problem
    static int squares(int a, int b) {
        int count = 0;
        int i = 1;
        while (i*i <= b) {
            if (i*i > a && i*i <= b) {
                System.out.println(i*i);
                count++;
            }
            i++;
        }

        return count;

    }

    //https://www.hackerrank.com/challenges/strange-advertising/problem
    static int viralAdvertising(int n) {
        int shared = 5;
        int liked = 2;
        int totalLiked = 2;

        while (n > 1) {
            shared = liked * 3;
            liked = shared / 2;
            totalLiked += liked;
            n--;
        }

        return totalLiked;

    }

    //https://www.hackerrank.com/challenges/save-the-prisoner/problem
    static int saveThePrisoner(int n, int m, int s) {
        int val = s + m - 1;
        int returnVal = val % n;

        if (returnVal == 0) {
            return n;
        } else {
            return returnVal;
        }
    }

    //https://www.hackerrank.com/challenges/beautiful-days-at-the-movies/problem
    static int beautifulDays(int i, int j, int k) {
        int beautifulCount = 0;
        for (int numb = i; numb <= j; numb++) {
            int revNumb = 0;
            int numbCopy = numb;

            while (numbCopy > 0) {
                revNumb = revNumb * 10 + numbCopy % 10;
                numbCopy = numbCopy / 10;

            }

            double differenceDivided = abs(numb-revNumb) / (double) k;


            if (((differenceDivided * 10) % 10) == 0) {
                beautifulCount++;
            }
        }

        return beautifulCount;

    }

    //https://www.hackerrank.com/challenges/mark-and-toys/problem
    // using Java sdk Arrays.sort to get 35 points :/, which is Quicksort or Merge Sort depending on the type of array.
    static int maximumToys(int[] prices, int k) {
        Arrays.sort(prices);
        int toyAmount = 0;
        int totalCost = 0;

        for (int i = 0; i < prices.length; i++) {
            if ((prices[i] + totalCost) <= k) {
                totalCost += prices[i];
                toyAmount++;
            } else {
                break;
            }
        }

        return toyAmount;

    }


    // this implementation times out, due to bubblesort but its cool.
    static int maximumToysBubbleSort(int[] prices, int k) {
        boolean isSwapped = false;
        int toyAmount = 0;
        int totalCost = 0;

        // bubble sort but is it efficient?
        for (int j = 0; j < prices.length-1; j++) {
            isSwapped = false;
            for (int i = 0; i < prices.length-j-1; i++) {
                if (prices[i] > prices[i+1]) {
                    int temp = prices[i];
                    prices[i] = prices[i+1];
                    prices[i+1] = temp;
                }
            }
            if (isSwapped = false) {
                break;
            }
        }

        //get the amount of toys available for purchase
        for (int i = 0; i < prices.length; i++) {
            if ((prices[i] + totalCost) <= k) {
                totalCost += prices[i];
                toyAmount++;
            } else {
                break;
            }
        }

        return toyAmount;
    }

    //https://www.hackerrank.com/challenges/sparse-arrays/problem
    static int[] matchingStrings(String[] strings, String[] queries) {
        int[] returnArray = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int counter = 0;
            for (int j = 0; j < strings.length; j++) {
                if (queries[i].equals(strings[j])) {
                    counter++;
                }
            }
            returnArray[i] = counter;
        }

        return returnArray;
    }


    //https://www.hackerrank.com/challenges/arrays-ds/problem
    static int[] reverseArray(int[] a) {
        for (int i = 0; i < a.length / 2; i++) {
            int temp = 0;
            temp = a[i];
            a[i] = a[a.length-1-i];
            a[a.length-1-i] = temp;
        }

        return a;
    }

    //https://www.hackerrank.com/challenges/2d-array/problem
    static int hourglassSum(int[][] arr) {
        int highestSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                int innerSum = 0;
                try {
                    innerSum += arr[i][j];
                    innerSum += arr[i][j+1];
                    innerSum += arr[i][j+2];
                    innerSum += arr[i+1][j+1];
                    innerSum += arr[i+2][j];
                    innerSum += arr[i+2][j+1];
                    innerSum += arr[i+2][j+2];

                } catch (IndexOutOfBoundsException e) {
                    System.out.println("chill");
                    break;
                }
                if (highestSum < innerSum) {
                    highestSum = innerSum;
                }
            }
        }

        return highestSum;
    }

    //https://www.hackerrank.com/challenges/angry-professor/problem
    static String angryProfessor(int k, int[] a) {
        int lateCounter = 0;

        for (int i = 0; i < a.length; i++) {
            if (a[i] > 0) {
                lateCounter++;
            }
        }

        if ((a.length - lateCounter) < k) {
            return "YES";
        } else {
            return "NO";
        }

    }

    //https://www.hackerrank.com/challenges/utopian-tree/problem
    static int utopianTree(int n) {
        int height = 1;

        if (n <= 0) {
            return height;
        } else {
            for (int i = 1; i <= n; i++) {
                if (i % 2 != 0) {
                    height *= 2;
                } else {
                    height += 1;
                }
            }

            return height;
        }
    }

    //https://www.hackerrank.com/challenges/designer-pdf-viewer/problem
    static int designerPdfViewer(int[] h, String word) {
        char[] charArray = word.toCharArray();
        char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        int tallest = 0;

        for (int i = 0; i < word.length(); i++) {
            for (int j = 0; j < alphabet.length; j++) {
                if (charArray[i] == alphabet[j]) {
                    if (tallest < h[j]) {
                        tallest = h[j];
                    }
                }
            }
        }

        return tallest * word.length();

    }

    //https://www.hackerrank.com/challenges/the-hurdle-race/problem
    static int hurdleRace(int k, int[] height) {
        int highest = 0;
        for (int i = 0; i < height.length; i++) {
            if (highest < height[i]) {
                highest = height[i];
            }
        }

        if (highest > k) {
            return highest - k;
        } else {
            return 0;
        }

    }

    //https://www.hackerrank.com/challenges/climbing-the-leaderboard/problem
    static int[] climbingLeaderboard(int[] scores, int[] alice) {
        int currentVal = 0;
        int rankCounter = 0;
        int[] rankingArray = new int[scores.length];
        int[] alicePositions = new int[alice.length];
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] != currentVal) {
                rankCounter++;
                currentVal = scores[i];
            }
            rankingArray[i] = rankCounter;
        }

        int k = 0;
        int innerCounter = 0;
        for (int i = 0; i < alice.length; i++) {
            while (alice[i] < scores[k]) {
                innerCounter++;
                k++;

                if (k == scores.length) {
                    break;
                }
            }

            k = 0;

            if (innerCounter == scores.length) {
                alicePositions[i] = rankingArray[innerCounter - 1] + 1;
            } else {
                alicePositions[i] = rankingArray[innerCounter];
            }

            innerCounter = 0;
        }

        return alicePositions;
    }

    //https://www.hackerrank.com/challenges/picking-numbers/problem
    static int pickingNumbers(List<Integer> a) {
        int counter = 0;
        int selectedNumber = 0;
        int subArrayCount = 0;
        Collections.sort(a);
        for (int i = 0; i < a.size(); i++) {
            int innerCounter = 0;
            for (int j = i+1; j < a.size(); j++) {
                if (abs(a.get(i) - a.get(j)) <= 1) {
                    innerCounter++;
                    if (innerCounter > counter) {
                        selectedNumber = a.get(i);
                        counter = innerCounter;
                    }
                }
            }
        }

        for (int i: a) {
            if (i == selectedNumber || i == selectedNumber + 1) {
                subArrayCount++;
            }
        }

        return subArrayCount;
    }

    //https://www.hackerrank.com/challenges/magic-square-forming/problem
    static int formingMagicSquare(int[][] s) {
        int cost[] = {0,0,0,0,0,0,0,0};
        int t[][] =
                {
                        {4,9,2,3,5,7,8,1,6},
                        {4,3,8,9,5,1,2,7,6},
                        {2,9,4,7,5,3,6,1,8},
                        {2,7,6,9,5,1,4,3,8},
                        {8,1,6,3,5,7,4,9,2},
                        {8,3,4,1,5,9,6,7,2},
                        {6,7,2,1,5,9,8,3,4},
                        {6,1,8,7,5,3,2,9,4},
                };

        for(int i=0;i<8;i++)
        {
            cost[i] = abs(t[i][0]-s[0][0]) + abs(t[i][1]-s[0][1]) + abs(t[i][2]-s[0][2]);
            cost[i] = cost[i] + abs(t[i][3]-s[1][0]) + abs(t[i][4]-s[1][1]) + abs(t[i][5]-s[1][2]);
            cost[i] = cost[i] + abs(t[i][6]-s[2][0]) + abs(t[i][7]-s[2][1]) + abs(t[i][8]-s[2][2]);
        }

        Arrays.sort(cost);
        return cost[0];
    }

    //https://www.hackerrank.com/challenges/cats-and-a-mouse/problem
    static String catAndMouse(int x, int y, int z) {
        if (abs(x - z) == abs(y - z)) {
            return "Mouse C";
        } else if (abs(x - z) < abs(y - z)) {
            return "Cat A";
        } else {
            return "Cat B";
        }
    }

    //https://www.hackerrank.com/challenges/electronics-shop/problem
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        int sum = 0;
        ArrayList<Integer> possibleCombinations = new ArrayList<>();

        for (int i = 0; i < keyboards.length; i++) {
            for (int j = 0; j < drives.length; j++) {
                if (keyboards[i] + drives[j] <= b) {
                    possibleCombinations.add(keyboards[i] + drives[j]);
                }
            }
        }

        Collections.sort(possibleCombinations);

        if (possibleCombinations.isEmpty()) {
            return -1;
        } else {
            return possibleCombinations.get(possibleCombinations.size() - 1);
        }
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

        return abs(leftSum-rightSum);

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
