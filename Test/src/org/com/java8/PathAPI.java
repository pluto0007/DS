package org.com.java8;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class PathAPI {

	public static void main(String[] args) {
		// Path are similar to File
		// Files.lines(path) Read all lines from a file as a Stream.
		Path path = Paths.get("C:\\Users\\chetankapoor\\Desktop\\programs\\Test\\src\\org\\com\\java8\\peopleWithDOB.txt");
		try (Stream<String> stream = Files.lines(path)){
			
			stream.filter(line->line.contains("19"))
			.findFirst()
			.ifPresent(System.out::println);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		Path path2 = Paths.get("C:\\Users\\chetankapoor\\Desktop\\META-INF" );
		System.out.println(Files.exists(path2, LinkOption.NOFOLLOW_LINKS));
		
		// Files.list(path2) Return a lazily populated Stream, the elements of which are the entries in the directory.
		//The listing is not recursive
		try(Stream<Path> stream = Files.list(path2)) {
			stream.filter(path3->path3.toFile().isDirectory())
			.forEach(System.out::println);

		} catch (Exception e) {
			// TODO: handle exception
		}

		// Files.list(path2) Return a Stream that is lazily populated with Path by walking the file tree rooted at a
		//given starting file. The file tree is traversed depth-first.
		try(Stream<Path> stream = Files.walk(path2)) {
			stream.filter(path3->path3.toFile().isDirectory())
			.forEach(System.out::println);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

}
