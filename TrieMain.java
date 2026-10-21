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

    Node root;
    public static final int Alpsize = 128;

    public Trie(){
        root = null;
    }

    
}


public class TrieMain {

    public static void main(String[] args){
        
        
    
    }
    
}
