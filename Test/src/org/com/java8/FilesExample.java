package org.com.java8;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FilesExample {

	public static void main(String[] args) throws IOException {
		//File file = new File("C:\\Users\\chetankapoor\\Documents\\My Received Files\\7D68FAFB.PNG");
		 Path path = Paths.get("C:\\Users\\chetankapoor\\Documents\\My Received Files\\7D68FAFB.PNG");
		boolean pathExist = Files.exists(path, LinkOption.NOFOLLOW_LINKS);
		System.out.println(pathExist);
		
		Path destinationPath = Paths.get("C:\\Users\\chetankapoor\\Documents\\My Received Files\\chetan");
		boolean fileExists = false;
		if(!Files.exists(destinationPath, LinkOption.NOFOLLOW_LINKS)) {
			Files.createDirectories(destinationPath);
			fileExists=true;
		}
		if(fileExists) {
			Path newDestPath = Paths.get("C:\\Users\\chetankapoor\\Documents\\My Received Files\\chetan\\7D68FAFB.PNG");
			destinationPath = newDestPath;
		}
		
		Files.copy(path, destinationPath);

	}

}
