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
                Scanner sc = new Scanner(System.in);
                System.out.print("This is an action without and UNDO, make sure to think twice before delete.\nName of the task to delete: ");
                String title = sc.nextLine().trim();
                crud.delete(title);

                break;

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
        try{
        System.out.println("\u001B[0m");
        System.out.println("Filter by:");
        System.out.println("\t1-All");
        System.out.println("\t2-Name");
        System.out.println("\t3-Priority");
        System.out.println("\t4-Status");
        System.out.println("\t5-Go Back");
        int option = sc.nextInt();
        listTask(option);
        }
        catch(Exception e){
            System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
            listOptions();
        }

    }

    private void listTask(int option) {
        Scanner sc = new Scanner(System.in);
        switch (option) {
            case 1:
                crud.selectALL();
                break;

            case 2:
                try {
                    System.out.print("NAME:");
                    crud.selectByName(sc.nextLine());
                }
                catch(Exception e){
                    System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
                }

               break;

            case 3:
                try {
                    System.out.print("PRIORITY:");
                    crud.selectByPriority(sc.nextInt());
                }
                catch(Exception e){
                    System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
                }
                break;

            case 4:
                try {
                    System.out.print("STATUS(0-3):");
                    crud.selectByStatus(sc.nextInt());
                }
                catch(Exception e){
                    System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
                }
                break;

            case 5:
                menu(showOptions());

            default:
                System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
                menu(showOptions());
        }
        listOptions();
    }


}
