package com.homework.filecopy;

import java.io.*;


public class Main {

	public static void main(String[] args) {
		File file = null;
		File[] paths;
		
		FilenameFilter fileFilter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				  if(name.lastIndexOf('.')>0) {
		               
		                 
	                  int lastIndex = name.lastIndexOf('.');
	                  
	                  
	                  String str = name.substring(lastIndex);
	                
	                  
	                  if(str.equals(".pdf")) {
	                     return true;
	                  }
	               }
	               
	               return false;
				
			}
		};
		try {
			
			file = new File("src/com/homework/filecopy/texts/");
			paths = file.listFiles(fileFilter);
			
			
			
			for (File path : paths) {
				FileInputStream tmp = new FileInputStream(path);
				File folder = new File ("src/com/homework/filecopy/");
				File tmpOne = new File (folder,"" + path.getName());
				FileOutputStream finish = new FileOutputStream(tmpOne);

				byte[] b = new byte[(int)path.length()];
				int c = 0;
				while ((c=tmp.read(b)) != -1) {
					finish.write(b);
				}			
				finish.close();
				tmp.close();
			}
			
		} catch (IOException e) {
			System.out.println("File not found");
		}

	}

}
