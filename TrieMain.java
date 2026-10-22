package TriesandTribulations;

import java.util.Scanner;
import java.util.HashSet;
import java.util.ArrayList;


class Node{

    //fields
    Node[] children;
    boolean isTerminal;

    //methods
    //contructor
    public Node(){
        children = new Node[Trie.Alpsize];
        isTerminal = false;
    }

    //accessors
    public Node[] getChildren(){
        return children;
    }

    public boolean isTerminal(){
        return isTerminal;
    }

    //mutators
    public void setChildren(Node[] children){
        this.children = children;
    }

    public void setTerminal(boolean isTerminal){
        this.isTerminal = isTerminal;
    }
}


class Trie{

    //fields
    Node root;
    public static final int Alpsize = 128;

    // public methods
    public Trie(){
        root = null;
    }

    //insert(word)
    public void insert(String word){
        //initialize root
        if (root == null){
            root = new Node();
        }

        //start at top of tree
        Node curr = root;

        //go through every letter in word
        for (int i = 0; i < word.length(); i++){
            char c = word.charAt(i);

            //build a path for each letter
            if (curr.getChildren()[c] == null){
                curr.getChildren()[c] = new Node();
            }

            //move pointer to bottom of tree
            curr = curr.getChildren()[c];
        }

        //set child as true
        curr.setTerminal(true);

    }

    //search(word)
    public boolean search(String word){

        //check for empty trie
        if (root == null) return false;

        Node curr = root;

        // Go through every char
        for (int i=0; i < word.length(); i++){
            char c = word.charAt(i);

            //if there's a dead end
            if (c >= Alpsize || curr.getChildren()[c] == null){
                return false;
            }

            //go to next node
            curr = curr.getChildren()[c];
        }

        return curr.isTerminal();
    }

    //printAll()
    public void printAll(){
        //if enpty trie
        if (root == null) {System.out.println(); return;}

        //recursively go through the trie and print all words avaiable
        printHelper(root, "");
        System.out.println();




    }

    //printAllWords(prefix)

    public void printAllWords(String prefix) {
        //if empty trie
        if (root == null){ System.out.println(); return; }

        Node curr = root;
        //go to end of prefix
        for (int i =0; i < prefix.length(); i++){
            char c = prefix.charAt(i);

            // prefix path breaks early
            if (c >= Alpsize || curr.getChildren()[c] == null){
                System.out.println();
                return;
            }

            curr = curr.getChildren()[c];

        }

        printHelper(curr, prefix);

    }
    //other methods

    //helper function
    private void printHelper(Node curr, String currWrd){
        //if word is valid
        if (curr.isTerminal()){
            System.out.print("'" + currWrd + "', ");
        }

        //loop through all letters

        for (int i = 0; i < Alpsize; i++){
            
            //if there's a child node that exist @ index
            if (curr.getChildren()[i] != null){
                printHelper(curr.getChildren()[i], currWrd + (char) i);
            }
        }
    }

}


public class TrieMain {

    public static void main(String[] args){
        //no args launcing code
        if (args.length == 0){
            System.out.println("Please use 'test' or 'memuse' for modes");
            return;
        }

        //test
        if (args[0].equals("test")){

            Trie trie = new Trie();

            //load trie with test words
            String[] testWords = {"banana", "bandana", "bandaid", "bandage", "letter", "lettuce", "let", "tool", "toy", "toilet"};

            //insert all test words into trie
            for (String i : testWords){
                trie.insert(i);
            }

            Scanner sc = new Scanner(System.in);

            while (true) {
                //Display menu
                System.out.println("{add WORD}: Add a word");
                System.out.println("{printAll}: Print all words");
                System.out.println("{startswith PREFIX}: Print words that start with");
                System.out.println("{search WORD}: Match a specific word");
                System.out.println("{quit}: Quit");

                System.out.println("? ");

                //watch for case sensitive inputs
                String input = sc.nextLine().trim();
                String[] parts = input.split(" ");
                String cmd = parts[0].toLowerCase();


                //all user inputs
                if (cmd.equals("quit")) break;
                else if (cmd.equals("add") && parts.length > 1) trie.insert(parts[1]);
                else if (cmd.equals("printall")) trie.printAll();
                else if (cmd.equals("startswith") && parts.length > 1) trie.printAllWords(parts[1]);
                else if (cmd.equals("search") && parts.length > 1){
                    //2 cases
                    //1. if found
                    if (trie.search(parts[1])) System.out.print("word '" + parts[1] + "' was found in the trie");
                    //2. not found
                    else System.out.println("word '" + parts[1] + "' was  NOT found in the trie");
                }

                System.out.println("* press enter *");
                sc.nextLine();


                //clear terminal
                System.out.print("\033[H\033[2J");
                System.out.flush();





            }
        }






        //memuse




        
        
    
    }
    
}
