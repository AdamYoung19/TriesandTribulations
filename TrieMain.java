package TriesandTribulations;



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

    
    

}


public class TrieMain {

    public static void main(String[] args){
        
        
    
    }
    
}
