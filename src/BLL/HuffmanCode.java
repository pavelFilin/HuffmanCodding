package BLL;

import BLL.TreeMap.InternalNode;
import BLL.TreeMap.LeafNode;
import BLL.TreeMap.Node;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HuffmanCode {
    public Map<Character, Integer> getDictionary(String s) {
        Map<Character, Integer> dictionary = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (dictionary.containsKey(s.charAt(i))) {
                dictionary.put(s.charAt(i), dictionary.get(s.charAt(i)) + 1);
            } else {
                dictionary.put(s.charAt(i), 1);
            }
        }

        return dictionary;
    }

    public PriorityQueue<Node> buildTree(Map<Character, Integer> dictionary) {

        PriorityQueue<Node> nodes = new PriorityQueue<>(
                (node1, node2) ->
                        Integer.compare(node1.getSum(), node2.getSum())
        );

        for (Map.Entry<Character, Integer> entry : dictionary.entrySet()) {
            nodes.add(new LeafNode(entry.getKey(), entry.getValue()));
        }

        while (nodes.size() > 1) {
            Node left = nodes.poll();
            Node right = nodes.poll();
            nodes.add(new InternalNode(left, right));
        }

        return nodes;
    }

    public String Encoding(String text, Map<Character, String> dictionary) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < text.length(); i++) {
            result.append(dictionary.get(text.charAt(i)));
        }

        return String.valueOf(result);
    }
}
