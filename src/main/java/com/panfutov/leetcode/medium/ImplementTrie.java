package com.panfutov.leetcode.medium;

/**
 * 208. Implement Trie (Prefix Tree)
 * A trie (pronounced as "try") or prefix tree is a tree data structure used to efficiently store and retrieve keys in a dataset of strings. There are various applications of this data structure, such as autocomplete and spellchecker.
 *
 * Implement the Trie class:
 *
 * Trie() Initializes the trie object.
 * void insert(String word) Inserts the string word into the trie.
 * boolean search(String word) Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
 * boolean startsWith(String prefix) Returns true if there is a previously inserted string word that has the prefix prefix, and false otherwise.
 *
 *
 * Example 1:
 *
 * Input
 * ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]
 * [[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]
 * Output
 * [null, null, true, false, true, null, true]
 *
 * Explanation
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // return True
 * trie.search("app");     // return False
 * trie.startsWith("app"); // return True
 * trie.insert("app");
 * trie.search("app");     // return True
 *
 *
 * Constraints:
 *
 * 1 <= word.length, prefix.length <= 2000
 * word and prefix consist only of lowercase English letters.
 * At most 3 * 104 calls in total will be made to insert, search, and startsWith.
 */
public class ImplementTrie {
    static final class TrieNode {
        private final TrieNode[] links;
        private static final int R = 26;
        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    static final class Trie {
        private final TrieNode root;

        /** Initialize your data structure here. */
        public Trie() {
            root = new TrieNode();
        }

        /**
         *  Inserts a word into the trie.
         *  Time complexity: O(m)
         *  Space complexity: O(m)
         *  where m is the length of the word
         */
        public void insert(String word) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char currentChar = word.charAt(i);

                if (!node.containsKey(currentChar)) {
                    node.put(currentChar, new TrieNode());
                }

                node = node.get(currentChar);
            }

            node.setEnd();
        }

        /**
         * Returns if the word is in the trie.
         * Time complexity: O(m)
         * Space complexity: O(1)
         * where m is the length of the word
         */
        public boolean search(String word) {
            TrieNode node = searchPrefix(word);

            return node != null && node.isEnd();
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPrefix(prefix);

            return node != null;
        }

        private TrieNode searchPrefix(String prefix) {
            TrieNode node = root;

            for (int i = 0; i < prefix.length(); i++) {
                char currentChar = prefix.charAt(i);

                if (node.containsKey(currentChar)) {
                    node = node.get(currentChar);
                } else {
                    return null;
                }
            }

            return node;
        }
    }

}
