package com.feng.algorthm.tree;

import com.sun.deploy.util.StringUtils;

import java.util.HashMap;

/**
 * @author
 * @time 2022/7/31 17:33
 * @Description- TODO
 */
public class TrieTree {
    public static class Node1 {
        public int pass;
        public int end;
        public Node1[] nexts;

        public Node1(){
            pass = 0;
            end = 0;
            /*
                0   a
                1   b
                ... ...
                25  z
                nexts[i] == null    i方向的路不存在
                nexts[i] != null    i方向的路存在
             */
            nexts = new Node1[26];
        }
    }

    public static class Trie1 {
        private Node1 root;

        public Trie1() {
            root = new Node1();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] str = word.toCharArray();
            Node1 node = root;
            node.pass++;
            int index = 0;
            for (int i=0; i<str.length; i++){
                index = str[i] - 'a'; //减ASCII，确定走哪条路
                if (node.nexts[index] == null){
                    node.nexts[index] = new Node1();
                }
                node = node.nexts[index];
                node.pass++;
            }
            node.end++;
        }

        /**
         * word这个单词之前加过几次
         * @param word
         * @return
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }

            char[] chs = word.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i=0; i<chs.length; i++){
                index = chs[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.end;
        }

        /**
         * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }

            char[] chs = pre.toCharArray();
            Node1 node = root;
            int index = 0;
            for (int i=0; i<chs.length; i++){
                index = chs[i] - 'a';
                if (node.nexts[index] == null){
                    return 0;
                }
                node = node.nexts[index];
            }
            return node.pass;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                Node1 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i] - 'a';
                    if (--node.nexts[index].pass == 0) {
                        node.nexts[index] = null;
                        return;
                    }
                    node = node.nexts[index];
                }
                node.end--;
            }
        }

    }


    public static class Node2 {
        public int pass;
        public int end;
        public HashMap<Integer,Node2> nexts;

        public Node2() {
            pass = 0;
            end = 0;
            nexts = new HashMap<>();
        }
    }

    public static class Trie2 {
        private Node2 root;

        public Trie2() {
            root = new Node2();
        }

        public void insert(String word) {
            if (word == null) {
                return;
            }

            char[] str = word.toCharArray();
            Node2 node = root;
            node.pass++;
            int index = 0;
            for (int i=0; i<str.length; i++){
                index = str[i];
                if (!node.nexts.containsKey(index)){
                    node.nexts.put(index,new Node2());
                }
                node = node.nexts.get(index);
                node.pass++;
            }
            node.end++;
        }

        /**
         * word这个单词之前加过几次
         * @param word
         * @return
         */
        public int search(String word) {
            if (word == null) {
                return 0;
            }

            char[] chs = word.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i=0; i<chs.length; i++){
                index = chs[i];
                if (!node.nexts.containsKey(index)){
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.end;
        }

        /**
         * 所有加入的字符串中，有几个是以pre这个字符串作为前缀的
         * @param pre
         * @return
         */
        public int prefixNumber(String pre) {
            if (pre == null) {
                return 0;
            }

            char[] chs = pre.toCharArray();
            Node2 node = root;
            int index = 0;
            for (int i=0; i<chs.length; i++){
                index = chs[i];
                if (!node.nexts.containsKey(index)){
                    return 0;
                }
                node = node.nexts.get(index);
            }
            return node.pass;
        }

        public void delete(String word) {
            if (search(word) != 0) {
                char[] chs = word.toCharArray();
                Node2 node = root;
                node.pass--;
                int index = 0;
                for (int i = 0; i < chs.length; i++) {
                    index = chs[i];
                    if (--node.nexts.get(index).pass == 0) {
                        node.nexts.remove(index);
                        return;
                    }
                    node = node.nexts.get(index);
                }
                node.end--;
            }
        }
    }


    public static void main(String[] args) {
        Trie1 trie1 = new Trie1();
        trie1.insert("abcdefghijk");
        int search = trie1.search("abcdefghijk");
        System.out.println(search);
        trie1.delete("abcdefghij");
        System.out.println(trie1.search("abcdefghijk"));

        Trie2 trie2 = new Trie2();
        trie2.insert("abcdefghijk");
        int search2 = trie2.search("abcdefghijk");
        System.out.println(search2);
        trie2.delete("abcdefghij");
        System.out.println(trie2.search("abcdefghijk"));
    }
}
