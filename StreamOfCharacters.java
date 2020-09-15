// Time Complexity : O(1)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode (1032): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class StreamChecker {
    
    class TrieNode {
        boolean isEnd;
        TrieNode children [];
        TrieNode() {
            children = new TrieNode[26];
        }
    }
    
    TrieNode root;
    public void insert(String word) {
        TrieNode curr = root;
        for (int i = word.length() - 1; i >= 0; i--) {
            char c = word.charAt(i);
            if (curr.children[c - 'a'] == null) {
                curr.children[c - 'a'] = new TrieNode();
            }
            curr = curr.children[c - 'a'];
        }
        curr.isEnd = true;
    }
    
    StringBuilder sb;
    public StreamChecker(String[] words) {
        root = new TrieNode();
        sb = new StringBuilder();
        for (String word : words) {
            insert(word);
        }
    }
    
    public boolean query(char letter) {
        sb.append(letter);
        TrieNode curr = root;
        for (int i = sb.length() - 1; i >= 0; i--) {
            char c = sb.charAt(i);
            curr = curr.children[c - 'a'];
            if (curr == null) return false;
            if (curr.isEnd) return true;
        }
        return false;
    }
}