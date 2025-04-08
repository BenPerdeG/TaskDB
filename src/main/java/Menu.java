import java.util.Scanner;

public class Menu {
    CRUD crud = new CRUD();


    public void startMenu() {
        showWelcome();
        menu(showOptions());
    }

    private void showWelcome() {
        System.out.println("\n#####################\n# Welcome to TaskDB #\n#####################\n");
    }
    private int showOptions() {
        Scanner sc = new Scanner(System.in);
        try {
            System.out.println("\u001B[0m");
            System.out.println("- List of options -");
            System.out.println(" 1 - List tasks");
            System.out.println(" 2 - Add a task");
            System.out.println(" 3 - Modify an existing task");
            System.out.println(" 4 - Delete a task");
            System.out.println(" 5 - Exit\n");
            System.out.print("Your option: ");
            int option = sc.nextInt();
            return option;
        }
        catch(Exception e){
            System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
            return (showOptions());
        }
    }
    private void menu(int option) {
        switch (option) {
            case 1:
                listOptions();
                break;

            case 2:
                return;

            case 3:
                return;

            case 4:
                return;

            case 5:
                System.out.println("Bye bye ");
                System.exit(0);

            default:
                System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
                menu(showOptions());
        }
    }

    private void listOptions() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\u001B[0m");
        System.out.println("Filter by:\n");
        System.out.println("\t1-All");
        System.out.println("\t2-Name");
        System.out.println("\t3-Priority");
        System.out.println("\t4-Status");
        System.out.println("\t5-Go Back");


    }


}
