package rateMyClass;	
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.text.html.HTMLDocument.Iterator;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.stream.JsonReader;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;

public class main {
	public static void main(String[] args) throws FileNotFoundException {
		int count = 0;
		do {
			System.out.println("Which course do you want to search? (ex.CS 125)");
			Scanner a = new Scanner(System.in);
			String course = a.nextLine();
			course = course.toUpperCase();
			readDataFromJson(course, count);
			count ++;
		} while (1 > 0);
	}
	public static void readDataFromJson(String s, int count) throws FileNotFoundException {
		JsonReader file = new JsonReader(new FileReader("src\\rateMyClass\\database.json"));
		Gson gson = new Gson();
		List<courseInfo> rs = new ArrayList<courseInfo>();
		Type type = new TypeToken<ArrayList<courseInfo>>() {
		}.getType();
		rs = gson.fromJson(file, type);
		boolean found = false;
		for (courseInfo a : rs) {
			if (a.getName().equals(s)) {
				System.out.println();
				System.out.println("Course Number: " + s);
				System.out.println("Course Name: " + a.getTitle());
				System.out.println("Average GPA: " + a.getAvg_gpa());
				System.out.println("(data from " + a.getSum_students() + " students)");
				System.out.println("Comments from students reflection:");
				a.printComment();
				System.out.println("Do you want to add your data in? (Yes/No)");
				Scanner scan = new Scanner(System.in);
				String yes = scan.nextLine();
				if (yes.equalsIgnoreCase("yes")) {
					System.out.println("What's your GPA? (Enter a number only)");
					double gpa = scan.nextDouble();
					a.setgpa(gpa);
					a.setSum_students(a.getSum_students() + 1);
					System.out.println("Any comment to the course?");
					Scanner b = new Scanner(System.in);
					String commentToAdd = b.nextLine();
					a.addComment(commentToAdd);
					System.out.println("Thanks for your reflection!");
				}
				found = true;
				break;
			}
		}
		if (found == false) {
			System.out.println("Sorry, our database doesn't have information about " + s + ". Please try another one." );
		}
	}
}