import java.io.*;
import java.util.*;

public class Options {
	public Scanner s = new Scanner(System.in);
	public BufferedOutputStream output;

	public Set<String> sortFiles() {
		File[] f = new File("files").listFiles();
		Set<String> sorted = new TreeSet<>();
		for (File file : f) {
			sorted.add(file.getName());
		}
		return (sorted);
	}

	public void showFiles() {
		System.out.println("File names in an ascending order:");
		sortFiles().forEach(System.out::println);
	}
	public void addFile() {

		System.out.println("Enter a name for the file:");
		String fName = s.nextLine();
		String pathDist = "files/" + fName;
		try {
			output = new BufferedOutputStream(new FileOutputStream(pathDist));
			System.out.println("Enter an input for your file:");
			String input_txt = s.nextLine();
			String in = input_txt;
			output.write(in.getBytes());
			System.out.println("Your file was added Successfully!");
	} catch (FileNotFoundException e) {
		System.out.println("Error! file doesn't exist.");
	} catch (IOException e) {
		System.out.println("Error!");
	} finally {
		if (output != null) {
			try {
				output.close();
			} catch (IOException e) {
				System.out.println("Error!");
			}
		}
	}

}
	public void deleteFile() {
		System.out.println("Enter the name of the file you want to delete:");
		String fName = s.nextLine();
		String pathDist = "files/" + fName;
		File file = new File(pathDist);
		boolean flag = file.delete();
		if (flag) {
			System.out.println("File was deleted Sucessfully!");
		} else {
			System.out.println("File not found");
		}
	}
	public void searchFile() throws FileNotFoundException {
		System.out.println("Enter the file name:");
		String fName = s.nextLine();
		String path = "files/" + fName;
		File file = new File(path);

		try (Scanner s = new Scanner(file)) {
			while (s.hasNextLine()) {
				System.out.print(s.nextLine());
			}
			s.close();
		}
	}
}