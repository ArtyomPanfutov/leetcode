package com.panfutov.leetcode.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * 211. Design Add and Search Words Data Structure
 *
 * Design a data structure that supports adding new words and finding if a string matches any previously added string.
 *
 * Implement the WordDictionary class:
 *
 * WordDictionary() Initializes the object.
 * void addWord(word) Adds word to the data structure, it can be matched later.
 * bool search(word) Returns true if there is any string in the data structure that matches word or false otherwise. word may contain dots '.' where dots can be matched with any letter.
 *
 *
 * Example:
 *
 * Input
 * ["WordDictionary","addWord","addWord","addWord","search","search","search","search"]
 * [[],["bad"],["dad"],["mad"],["pad"],["bad"],[".ad"],["b.."]]
 * Output
 * [null,null,null,null,false,true,true,true]
 *
 * Explanation
 * WordDictionary wordDictionary = new WordDictionary();
 * wordDictionary.addWord("bad");
 * wordDictionary.addWord("dad");
 * wordDictionary.addWord("mad");
 * wordDictionary.search("pad"); // return False
 * wordDictionary.search("bad"); // return True
 * wordDictionary.search(".ad"); // return True
 * wordDictionary.search("b.."); // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length <= 500
 * word in addWord consists lower-case English letters.
 * word in search consist of  '.' or lower-case English letters.
 * At most 50000 calls will be made to addWord and search.
 */
public class DesignAddAnsSearchWordsDataStructure {
    class WordDictionary {
        TrieNode root;

        /** Initialize your data structure here. */
        public WordDictionary() {
            root = new TrieNode();
        }

        public void addWord(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char current = word.charAt(i);

                if (!node.contains(current)) {
                    node.put(current, new TrieNode());
                }

                node = node.get(current);
            }

            node.setEnd();
        }

        public boolean search(String word) {
            return search(root, word);
        }

        private boolean search(TrieNode root, String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char current = word.charAt(i);

                if (current == '.') {
                    for (TrieNode trie : node.getNotEmpty()) {
                        if (search(trie, word.substring(i + 1))) {
                            return true;
                        }
                    }
                    return false;
                }

                if (!node.contains(current)) {
                    return false;
                }

                node = node.get(current);
            }

            return node.isEnd();
        }

        private final class TrieNode {
            private static final int R = 26;

            private final TrieNode[] links;
            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean contains(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public List<TrieNode> getNotEmpty() {
                List<TrieNode> list = new ArrayList<>();

                for (TrieNode node : links) {
                    if (node != null) {
                        list.add(node);
                    }
                }

                return list;
            }
        }
    }


/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
}
