package cfarrell;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
//import asg.cliche.Command;
//import asg.cliche.Param;
//import asg.cliche.Shell;
//import asg.cliche.ShellFactory;

public class Main {

	private Scanner sc = new Scanner(System.in);
	// called by interface name first
	AutoComplete brute; // brute force autocomplete
	AutoComplete quick; // quick autocomplete

	public static void main(String[] args) throws IOException {
		Main main = new Main();
		main.run();
		// Create a shell with ac@ and the user's name displayed in lower case
		// Shell shell = ShellFactory.createConsoleShell("ac@" +
		// System.getProperty("user.name").toLowerCase(), "Welcome to
		// autocomplete- ?help for instructions", main);
		// shell.commandLoop();
	}

	public Main() {
		try {
			brute = new BruteAutoComplete();
			quick = new QuickAutoComplete();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	private int mainMenu() {
		System.out.println("1) Enter URL of list");
		System.out.println("2) Enter term");
		System.out.println("3) Change autocomplete mode");
		System.out.println("0) Exit");
		System.out.print("==>>");
		int option = sc.nextInt();
		return option;
	}

	public void run() {
		{
			System.out.println("Autocomplete system");
			int option = mainMenu();
			while (option != 0) {
				switch (option) {
				case 1:
					URLName();
					break;
				case 2:
					matches();
					break;
				case 3:
					mode();
					break;
				}

				option = mainMenu();
			}
			System.out.println("Exiting... bye");
		}
	}

	// @Command(description="Enter a prefix")
	public void matches() {
		System.out.println("Enter a prefix");
		String prefix = sc.next();
		System.out.println("Number of terms to return");
		int k = sc.nextInt();
		System.out.println("Working");
		brute.matches(prefix, k);

	}

	// @Command(description="Load in a file to process")
	public void URLName() {
		String URL =  sc.nextLine();
		
		System.out.println("Work In Progress");
	}

	// @Command(description="Allow the user to switch between quick and slow
	// complete modes")
	public void mode() {
		boolean useQuickComplete = false;
		/*
		 * include some method for setting this to true when the user puts in a
		 * value of say "1" for a quick search. Then return to the main menu and
		 * show that this has been selected
		 */
		System.out.println("The only mode is BruteAutoComplete!");
	}

}
