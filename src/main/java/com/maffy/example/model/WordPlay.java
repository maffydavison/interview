package com.maffy.example.model;

import java.io.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created with IntelliJ IDEA.
 * User: maffy davison
 * Date: 10/24/13
 * Time: 3:47 PM
 * To change this template use File | Settings | File Templates.
 */
public class WordPlay {

    public boolean isPalindrome(String input) {
        boolean result = true;

        String test = input.replaceAll("[ ,.;!]", "").toLowerCase();
        for (int i = 0, j= test.length() -1; i != j; i++, j--) {
            if (test.charAt(i) != test.charAt(j)) {
                result = false;
                break;
            }
        }

        return result;
    }

    public int [] mergeSortedArrays(int [] one, int [] two) {

        int total = one.length + two.length;
        int oneIndex = 0, twoIndex = 0;

        int [] result = new int[total];
        int count = 0;
        while (oneIndex < one.length && twoIndex < two.length) {
            if (one[oneIndex] < two[twoIndex]) {
                result[count++] = one[oneIndex++];
            } else {
                result[count++] = two[twoIndex++];
            }
        }

        while (oneIndex < one.length) {
            result[count++] = one[oneIndex++];
        }

        while (twoIndex < two.length) {
            result[count++] = two[twoIndex++];
        }

        return result;
    }

    public static String addStringToInt(String number, int addend) {

        char [] from = number.toCharArray();
        char [] to = String.valueOf(addend).toCharArray();
        int sum;
        int carry = 0;
        int shorter = from.length > to.length ? to.length - 1 : from.length -1;
        int longer = from.length > to.length ? from.length - 1 : to.length -1;
        StringBuilder builder = new StringBuilder();

        while (longer >= 0) {
            if (shorter >= 0 ) {
                sum = Character.getNumericValue(from[longer]) + Character.getNumericValue(to[shorter]) + carry;
            } else {
                sum = Character.getNumericValue(from[longer]) + carry;
            }
            if(sum > 9) {
                carry = 1;
                builder.append(sum % 10);
            } else {
                carry = 0;
                builder.append(sum);
            }

            longer--;
            shorter--;
        }


        return builder.reverse().toString();
    }

    public ListNode reverse(ListNode node) {
        ListNode result;
        ListNode secondElement;
        if (node == null || node.next == null) {
            result = node;
        } else {
            secondElement = node.next;
            node.next = null;
            ListNode reversed = reverse(secondElement);
            secondElement.next = node;
            result = reversed;
        }
        return result;
    }

    public static void main(String[] args) {
        String [] arrayOfWords = { "my", "dog", "has", "fleas"};
        ArrayList<String> arrayList = new ArrayList<String>(Arrays.asList(arrayOfWords));
        System.out.println("Before reverse as whole words...");
        System.out.println(arrayList.toString());

        Collections.reverse(arrayList);
        System.out.println("Reversed as whole words...");
        System.out.println(arrayList.toString());

        System.out.println();
        System.out.println("Find the largest value in a map of products...");
        HashMap<String, Integer> products = new HashMap<String, Integer>();
        for (int i = 1; i < 51 ; i++) {
             products.put("product" + i, i);
        }

        Integer result = Collections.max(products.values());
        System.out.println("Max value = " + result);

        for (Map.Entry<String, Integer> e : products.entrySet()) {
            if (e.getValue().equals(result)) {
                System.out.println("Max value of " + result + " is value of " + e.getKey());
            }
        }

        System.out.println();
        System.out.println("Reverse all the characters of a String...");
        String testOne = "esrever";
        String reverse = new StringBuffer(testOne).reverse().toString();

        System.out.println("Original: " + testOne);
        System.out.println("Reversed: " + reverse);

        System.out.println();
        arrayList = (ArrayList<String>) Arrays.asList(arrayOfWords);
        ListIterator listIterator = arrayList.listIterator();
        Collections.sort(arrayList);
        System.out.println("Sorted Array for no reason...");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }

        System.out.println();
        Date date = new Date();
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);

        System.out.println("Today: " + date.toString());
        calendar. add(Calendar.MONTH, 1);
        System.out.println("Plus a month: " + calendar.getTime().toString());
        calendar.add(Calendar.HOUR, 7);
        System.out.println("Plus 7 hours: " + calendar.getTime().toString());
        calendar.add(Calendar.YEAR, 3);
        System.out.println("Plus 3 years: " + calendar.getTime().toString());

        System.out.println();
        LinkedList linkedList = new LinkedList();
        linkedList.add("1");
        linkedList.add("8");
        linkedList.add("6");
        linkedList.add("4");
        linkedList.add("5");
        System.out.println(linkedList);
        linkedList.subList(2, 4).clear();
        System.out.println(linkedList);

        System.out.println();
        List<String> list = Collections.unmodifiableList(new ArrayList<String>(Arrays.asList(new String[] { "a", "b" })));
        try {
            list.set(0, "new value");
        }
        catch (UnsupportedOperationException e) {
            System.out.println("Tried to set a new value in unmodifiable list.");
        }
        Set<String> set = new HashSet<String>(Arrays.asList(new String[] { "a", "b" }));
        set = Collections.unmodifiableSet(set);
        try {
            set.remove(Arrays.asList(new String[] { "a", "b" }).get(0));
        }
        catch (UnsupportedOperationException e) {
            System.out.println("Tried to remove a value in unmodifiable set.");
        }
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put("0", 0);
        map.put("1", 1);
        map.put("2", 2);
        map = Collections.unmodifiableMap(map);
        try {
            map.remove(1);
        }
        catch (UnsupportedOperationException e) {
            System.out.println("Tried to remove a value in unmodifiable map.");
        }

        System.out.println();
        try {
            InetAddress address = InetAddress.getLocalHost();
            System.out.println("Local HostAddress: " + address.getHostAddress());
            String hostname = address.getHostName();
            System.out.println("Local host name: " + hostname);
        } catch (UnknownHostException e) {
            System.out.println("Got UnknownHostException: " + e.getMessage());
        }

/*        System.out.println();
        for (long count = 0; count < 33 ; count++) {
            long fibonacci = fibonacci(count);
            System.out.println("Fibonacci of " + count + " is " + fibonacci);
        }*/

        System.out.println();
        String [] first = { "one", "two", "three", "four"};
        String [] second = { "one", "one", "two", "five"};
        List<String> checkem = new ArrayList<String>(Arrays.asList(first));
        checkem.addAll(Arrays.asList(second));
        ListIterator iterator = checkem.listIterator();
        Collections.sort(checkem);
        Map<String, Integer> resultMap = new HashMap<String, Integer>();
        String bigKey = null;
        int bigValue = 0;
        while (iterator.hasNext()) {
            int value;
            String last = iterator.next().toString();
            if (!resultMap.containsKey(last)) {
                value = 1;
                resultMap.put(last, value);
            } else {
                int val = resultMap.get(last);
                value = ++val;
                resultMap.remove(last);
                resultMap.put(last, value);
            }

            if (value > bigValue) {
                bigValue = value;
                bigKey = last;
            }
        }
        System.out.println("Key: " + bigKey + " value: " + bigValue);

        System.out.println();
        List<String> lines = new ArrayList<String>();
        try {
            BufferedReader in = new BufferedReader
                    (new FileReader("/Users/maryannfinnerty/ideaGit/example/testFile.txt"));
            String str;
            while ((str = in.readLine()) != null) {

                lines.add(str);
            }
        }
        catch (IOException e) {
        }
        ListIterator iterator1 = lines.listIterator();
        Pattern p = Pattern.compile("words");
        int counter = 0;
        while (iterator1.hasNext()) {
            String input = iterator1.next().toString();
            Matcher m = p.matcher(input);
            while (m.find()) {
                counter++;
            }

        }
        System.out.println("Count of words (literally) is: " + counter);

        try {
            BufferedWriter out = new
                    BufferedWriter(new FileWriter("/Users/maryannfinnerty/ideaGit/example/testOutFile.txt"));
            out.write("aString");
            out.close();
            System.out.println
                    ("File created successfully");
        }
        catch (IOException e) {
        }


        Path filename = Paths.get("/Users/maryannfinnerty/ideaGit/example/testOutFileNio.txt");
        try {
            OutputStream out = new
                    BufferedOutputStream(Files.newOutputStream(filename, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.CREATE));
            byte [] bytes = "aStringdoodahday".getBytes();
            out.write(bytes);
            out.close();
            System.out.println
                    ("File with standard options created successfully");
        }
        catch (IOException e) {
        }

        long startTime = System.currentTimeMillis();
        String tester = "This is a test";
        StringBuffer buf = new StringBuffer();
        String [] array = tester.split(" ");
        System.out.println("array has " + array.length + " elements");

        List<String> lister = new ArrayList<String>(Arrays.asList(array));
        Collections.reverse(lister);

        for (int a = 0 ; a < array.length -1; a++) {
            buf.append(lister.get(a) + " ");

        }
        buf.append(lister.get(array.length - 1));
        System.out.println("String output: " + buf.toString());
        long endTime = System.currentTimeMillis();
        System.out.println("Collections test timing: " + (endTime - startTime));

        System.out.println();
        startTime = System.currentTimeMillis();
        String test2 = "This is a test";
        String [] array2 = test2.split(" ");
        StringBuffer buf2 = new StringBuffer();
        String [] resultArray = new String[array2.length];
        int counter2 = 0;
        for (int b = array2.length -1; b >= 0 && counter2 < array2.length ; b--, counter2++) {
            resultArray[counter2] = array2[b];

        }
        for (int j = 0 ; j < array2.length -1; j++) {
            buf2.append(resultArray[j] + " ");

        }
        buf2.append(resultArray[array2.length - 1]);
        System.out.println("String output: " + buf2.toString());
        endTime = System.currentTimeMillis();
        System.out.println("Array test timing: " + (endTime - startTime));

        System.out.println();
        startTime = System.currentTimeMillis();
        System.out.println("Before reverse: " + tester);
        buf = new StringBuffer();
        for (int c = array.length -1; c > 0; c--) {
            buf.append(array[c] + " ");
        }
        buf.append(array[0]);
        System.out.println("Reversed: " + buf.toString());
        System.out.println("Single loop test timing: " + (endTime - startTime));

        System.out.println();
        String google = WordPlay.addStringToInt("1234", 5);
        System.out.println("Adding string to int: 1234 + 5 == " + google);
        google = WordPlay.addStringToInt("123", 56789);
        System.out.println("Adding string to int: 123 + 56789 == " + google);



    }

}

