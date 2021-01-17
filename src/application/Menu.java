package application;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Menu {
	
	private ChocolateDao chocolateDao = new ChocolateDao();
	private Scanner scanner = new Scanner(System.in);
	private List<String> options = Arrays.asList(
			"Display all chocolate profiles",
			"Add chocolate profile",
			"Delete chocolate profile",
			"Update chocolate profile");

	public void start() {
		String selection = "";
		
		do {
			printMenu();
			selection = scanner.nextLine();
			
			try {
				if(selection.equals("1")) {
					displayChocolates();
				} else if (selection.equals("2")) {
					addChocolate();
				} else if (selection.equals("3")) {
					deleteChocolate();
				} else if (selection.equals("4")) {
					updateChocolate();
				} 
			} catch (SQLException e) {
				e.printStackTrace();
			}
						
			System.out.println("Press enter to continue or type 'quit' to exit");
			scanner.nextLine();
			
		} while (!selection.equals("quit")); { //Not sure why ; is needed here, but it wouldn't run w/o it
			System.out.println("Thank you for using the Chocobase!");
		}
	}
	
	private void printMenu() {
		System.out.println("Select an option:\n---------------------------");
		for (int i = 0; i < options.size(); i++) {
			System.out.println(i + 1 + ")" + options.get(i));
		}
	}
	
	private void displayChocolates() throws SQLException {
		List<Chocolate> chocolates = chocolateDao.getChocolates();
		for (Chocolate chocolate : chocolates) {
			System.out.println(chocolate.getId() + ": " + chocolate.getType() + ", " + chocolate.getCacao() + ", " + chocolate.getSugar() + ", " + chocolate.getDairy() + ", " + chocolate.getVanilla());
		}
	}
	
	private void addChocolate() throws SQLException {
		System.out.print("Enter type of chocolate: ");
		String type = scanner.nextLine();
		System.out.print("Enter cacao solids (%): ");
		int cacao = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter sugar (%): ");
		int sugar = Integer.parseInt(scanner.nextLine());
		System.out.print("Enter if dairy is commonly added (Y or N): "); 
		String dairy = scanner.nextLine();
		System.out.print("Enter if vanilla flavoring is commonly added (Y or N): "); 
		String vanilla = scanner.nextLine();
		
		chocolateDao.addNewChocolate(type, cacao, sugar, dairy, vanilla);
	}
	
	private void deleteChocolate() throws SQLException {
		System.out.print("Enter chocolate ID to delete: ");
		int id = Integer.parseInt(scanner.nextLine());
		chocolateDao.deleteChocolateById(id);
	}
	
	private void updateChocolate() throws SQLException {
		System.out.println("Enter chocolate ID to update: ");
		int id = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter updated chocolate type: ");
		String type = scanner.nextLine();
		System.out.println("Enter updated cacao solids (%): ");
		int cacao = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter updated sugar (%): ");
		int sugar = Integer.parseInt(scanner.nextLine());
		System.out.println("Enter updated dairy additive (Y or N): ");
		String dairy = scanner.nextLine();
		System.out.println("Enter updated vanilla additive (Y or N): ");
		String vanilla = scanner.nextLine();
		
		chocolateDao.updateChocolateById(id, type, cacao, sugar, dairy, vanilla);
	}
}
