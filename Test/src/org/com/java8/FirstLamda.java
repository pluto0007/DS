package org.com.java8;

import java.io.File;
import java.io.FileFilter;

public class FirstLamda {

	public static void main(String[] args) {
		FileFilter fileFilter = new FileFilter() {

			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".java");
			}
		};

		FileFilter filterLamda = (File pathname) -> pathname.getName().endsWith(".java");

		File dir = new File("C:\\Users\\chetankapoor\\Desktop\\programs\\Test\\src\\org\\nagarro\\com");
		File[] files = dir.listFiles(filterLamda);

		for (File f : files) {
			System.out.println(f.getName());
		}
	}

}
