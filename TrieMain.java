package TriesandTribulations;

import java.util.Scanner;


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

        //recursivley go through the trie and print all words avaiable
        printHelper(root, "");
        System.out.println();




    }

    //printAllWords(prefix)

    public void printAllWords(String prefix) {
        //if empty trie
        if (root == null){ System.out.println(); return; }

        for (int i =0; i < prefix.length(); i++){
            char c = prefix.charAt(i);
            
        }






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
        
        
    
    }
    
}
