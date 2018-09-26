package PL.ConsolePL;

import BLL.HuffmanCode;
import BLL.TreeMap.InternalNode;
import BLL.TreeMap.LeafNode;
import BLL.TreeMap.Node;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class ConsolePL implements Runnable {
    private String TEXT = "abrakadabra";

    private HuffmanCode huffmanCode;

    public ConsolePL() {
        huffmanCode = new HuffmanCode();
    }

    @Override
    public void run() {
        Map dictionary = huffmanCode.getDictionary(TEXT);
        System.out.println("Instance string is " + TEXT);
        showDictionary(dictionary);
        PriorityQueue<Node> priorityQueue = huffmanCode.buildTree(dictionary);
        Node root = priorityQueue.poll();
        root.buildCode("");
        Map<Character, String> codeChars = new HashMap<>();
        fillCodeChars(root, codeChars);
        codeChars.forEach((character, s) -> System.out.println(character + " " + s));
        String resultText = huffmanCode.Encoding(TEXT, codeChars);
        System.out.println(resultText);

    }

    public Map<Character, String> fillCodeChars(Node node, Map<Character, String> codeChars) {
        if (node instanceof LeafNode) {
            codeChars.put(((LeafNode) node).getCharacter(), node.getCode());
        } else {
            fillCodeChars(((InternalNode) node).getLeft(), codeChars);
            fillCodeChars(((InternalNode) node).getRight(), codeChars);
        }

        return codeChars;
    }

    public void showDictionary(Map<Character, Integer> dictionary) {
        dictionary.forEach((character, integer) -> System.out.println(character + ": " + integer));
    }


}
