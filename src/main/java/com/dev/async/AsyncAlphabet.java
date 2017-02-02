package com.dev.async;

import java.util.Iterator;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class AsyncAlphabet extends Thread {
	String name;

	char[] alphabetArray = { 'A', 'B', 'C', 'D', 'E', 'F', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S',
			'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	BlockingQueue<Character> alphabet = new LinkedBlockingQueue<>();

	public static Iterator<Character> iter = null;

	public AsyncAlphabet(String threadName) {
		super(threadName);
		this.name = threadName;
		for (char c : alphabetArray)
			alphabet.add(c);

		iter = alphabet.iterator();

	}

	public static void main(String[] args) {
		AsyncAlphabet t1 = new AsyncAlphabet("T1");
		AsyncAlphabet t2 = new AsyncAlphabet("T2");
		t1.start();
		t2.start();
		sync(t1);
		sync(t2);		
	}
	public static void sync(Thread t) {
		synchronized(t) {
			try {
				t.wait();
			} catch (InterruptedException e) {
				t.notifyAll();
			}
		}

	}

	public void run() {
		try {
			printChar(this.name );
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void printChar(String name) throws InterruptedException {
		while (iter.hasNext()) {			
			synchronized (this) {				
				System.out.println(name + " -> " + iter.next());
				Thread.currentThread().sleep(100);
				this.notifyAll();
			}
			
		}
		//Done printing
		System.exit(0);
	}

}
