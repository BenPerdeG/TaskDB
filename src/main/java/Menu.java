import java.util.Scanner;

public class Menu {
    CRUD crud = new CRUD();
    Scanner sc = new Scanner(System.in);

    public void startMenu() {
        showWelcome();
        menu(showOptions());
    }

    private void showWelcome() {
        System.out.println("\n#####################\n# Welcome to TaskDB #\n#####################\n");
    }
    private int showOptions() {
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
    private void menu(int option) {
        switch (option) {
            case 1:
                return;

            case 2:
                return;

            case 3:
                return;

            case 4:
                return;

            case 5:
                return;

            default:
                System.out.println("Re show menu test");
                menu(showOptions());
        }
    }
}
