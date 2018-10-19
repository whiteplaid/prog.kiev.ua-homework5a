package com.homework.filecopy;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;

public class FileCopy {
	private File sourceDir;
	private File targetDir;
	private String lastIndex;
	

	public FileCopy(File sourceDir, File targetDir, String lastIndex) {
		super();
		this.sourceDir = sourceDir;
		this.lastIndex = lastIndex;
		this.targetDir = targetDir;
	}


	public FileCopy() {
		super();
		// TODO Auto-generated constructor stub
	}


	public File getSourceDir() {
		return sourceDir;
	}


	public void setSourceDir(File sourceDir) {
		this.sourceDir = sourceDir;
	}


	public String getLastIndex() {
		return lastIndex;
	}


	public void setLastIndex(String lastIndex) {
		this.lastIndex = lastIndex;
	}


	public File getTargetDir() {
		return targetDir;
	}


	public void setTargetDir(File targetDir) {
		this.targetDir = targetDir;
	}


	public Boolean FileCopyMethod (File sourceDir, File targetDir, String ext) throws IOException {
		if (sourceDir == null || targetDir == null || ext == null) return false;
		File[] paths;
		
		FilenameFilter fileFilter = new FilenameFilter() {
			
			@Override
			public boolean accept(File dir, String name) {
				  if(name.lastIndexOf('.')>0) {
		               
		                 
	                  int lastIndex = name.lastIndexOf('.');
	                  
	                  
	                  String str = name.substring(lastIndex);
	                
	                  
	                  if(str.equals(ext)) {
	                     return true;
	                  }
	               }
	               
	               return false;
				
			}
		};
		paths = sourceDir.listFiles(fileFilter);
		
		
		
		for (File path : paths) {
			FileInputStream tmp = new FileInputStream(path);
			File tmpOne = new File (targetDir,"" + path.getName());
			FileOutputStream finish = new FileOutputStream(tmpOne);

			byte[] b = new byte[(int)path.length()];
			while ((tmp.read(b)) != -1) {
				finish.write(b);
			}			
			finish.close();
			tmp.close();
		}
		return true;
	}


	@Override
	public String toString() {
		return "FileCopy [sourceDir=" + sourceDir + ", lastIndex=" + lastIndex + ", targetDir=" + targetDir + "]";
	}
	
}
