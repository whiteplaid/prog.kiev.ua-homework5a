package com.homework.filecopy;

import java.io.*;


public class Main {

	public static void main(String[] args) {
		File file = null;
		File target = null;
		String ext = ".pdf";
		try {
			
			file = new File("src/com/homework/filecopy/texts/");
			target = new File ("src/com/homework/filecopy/");
			FileCopy copy = new FileCopy();
			System.out.println(copy.FileCopyMethod(file, target, ext));
			
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

}
