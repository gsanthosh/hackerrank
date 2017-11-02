/**
 * 
 */
package com.santhosh.hackerrank.algorithm.codinginterview;

import java.util.Scanner;

import com.santhosh.hackerrank.algorithm.util.Trie;

/**
 * @author santhosh
 *
 */
public class TrieContacts {

	Trie trie=new Trie();
	
	public void addWordToContacts(String contact) {
		trie.insertWord(contact);
	}
	
	public int findWordCount(String contact) {
		return trie.getPrefixCount(contact);
	}
	
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		TrieContacts sol = new TrieContacts();
		for (int a0 = 0; a0 < n; a0++) {
			String op = in.next();
			String contact = in.next();
			if (op.equals("add")) {
				sol.addWordToContacts(contact);
			} else {
				System.out.println(sol.findWordCount(contact));
			}
		}
	}
}
