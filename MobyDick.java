package mobydick;

import java.io.*;
import java.util.*;

public class MobyDick {
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
        System.out.println("Search for word: ");
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(wordSearch(s));
        numUniqueWords();
        hundredTimes();
        printFive();
    }
    
    public static String wordSearch(String s) throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("mobydick.txt"));
        
        String text = "";
        
        while (text != null) {
            text = br.readLine();
            if (text == null) {
                break;
            }
            text = text.toLowerCase();
            text = text.replaceAll("[^a-z, ^', ^0-9]", "");
            text = text.replace(",", " ");
            String[] wordStorage = text.split(" ");
            
            for (String w : wordStorage) {
                if (w.equals(s)) {
                    return "Yes, the word " + "\"" + s + "\"" + " does appear";
                }
            }
        }
        return "No, the word " + "\"" + s + "\"" + " does not appear";
    }
    
    public static void numUniqueWords() throws FileNotFoundException, IOException {
        Set<String> uniqueWords = new HashSet<String>();
        BufferedReader br = new BufferedReader(new FileReader("mobydick.txt"));
        
        String text = "";
        
        while (text != null) {
            text = br.readLine();
            if (text == null) {
                break;
            }
            text = text.toLowerCase();
            text = text.replaceAll("[^a-z, ^', ^0-9]", "");
            text = text.replace(",", " ");
            String[] wordStorage = text.split(" ");
            
            for (String w : wordStorage) {
                if (uniqueWords.contains(w) == false) {
                    uniqueWords.add(text);
                }
            }
        }
        System.out.println("Total Unique Words: " + uniqueWords.size());
    }
    
    public static void hundredTimes() throws FileNotFoundException, IOException {
        Map<String, Integer> myMap = new HashMap<String, Integer>();
        BufferedReader br = new BufferedReader(new FileReader("mobydick.txt"));
        
        String text = "";
        
        while (text != null) {
            text = br.readLine();
            if (text == null) {
                break;
            }
            
            text = text.toLowerCase();
            text = text.replaceAll("[^a-z, ^', ^0-9]", "");
            text = text.replace(",", " ");
            
            String[] wordStorage = text.split(" ");
            
            for (String w : wordStorage) {
                if (myMap.containsKey(w) == false) {
                    myMap.put(w, 1);
                }
                if (myMap.containsKey(w) == true) {
                    int count = myMap.get(w);
                    myMap.remove(w);
                    myMap.put(w, count + 1);
                }
            }
        }
        TreeMap<Integer, String> tm = new TreeMap<Integer, String>();
        for (String k : myMap.keySet()) {
            tm.put(myMap.get(k), k);
        }
        for (Integer treeKey : tm.keySet()) {
            if (treeKey >= 100) {
                System.out.println(treeKey + " " + tm.get(treeKey));
            }
        }
    }
    
    public static void printFive() throws FileNotFoundException, IOException {
        BufferedReader br = new BufferedReader(new FileReader("mobydick.txt"));
        TreeSet<String> ts = new TreeSet();
        
        String text = "";
        
        while (text != null) {
            text = br.readLine();
            if (text == null) {
                break;
            }
            text = text.toLowerCase();
            text = text.replaceAll("[^a-z, ^', ^0-9]", "");
            text = text.replace(",", " ");
            String[] wordStorage = text.split(" ");
            
            for (String w : wordStorage) {
                if (w.length() == 5 && w.charAt(0) == 97) {
                    ts.add(w);
                }
            }
        }
        System.out.println(ts);
    }
}



