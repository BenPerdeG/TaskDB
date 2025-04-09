import java.util.List;
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
                addTask();
                break;

            case 3:
                modifyTask();
                
                break;

            case 4:
                deleteTask();
                break;

            case 5:
                System.out.println("Bye bye ");
                System.exit(0);

            default:
                System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
                menu(showOptions());
        }
    }

    private void addTask() {
        Scanner sc = new Scanner(System.in);

        //Valores Default
        String title = "New Task";
        String description = "Describe your task";
        int priority=0;
        Task.Status status = Task.Status.fromValue(0);
        int intstatus =0;

        System.out.println("New task info:");

        System.out.print("Task Name (New Task): ");
        String tmpNm = sc.nextLine();
        if(!tmpNm.equals("")){title = tmpNm;}

        System.out.print("Task description (Describe your task): ");
        String tmpDsc = sc.nextLine();
        if(!tmpDsc.equals("")){description = tmpDsc;}

        System.out.print("Task priority(0): ");
        String tmpPr = sc.nextLine();
        if(!tmpPr.equals("")){
            try{
                priority=Integer.parseInt(tmpPr);
            }catch (Exception e){
                System.out.println("\u001B[31m"+"Something went wrong with your priority setting. Defaulting value to 0."+"\u001B[0m");
            }
        }

        System.out.print("Task status |0-3| (0): ");
        String tmpSt = sc.nextLine();
        if(!tmpSt.equals("")){
            try{
            if(Integer.parseInt(tmpSt)==0 || Integer.parseInt(tmpSt)==1 || Integer.parseInt(tmpSt)==2 || Integer.parseInt(tmpSt)==3 ){
                status =  Task.Status.fromValue(Integer.parseInt(tmpSt));
                intstatus = Integer.parseInt(tmpSt);
            }else {
                System.out.println("\u001B[31m"+"Something went wrong with your priority setting. Defaulting value to 0 (PENDING)."+"\u001B[0m");
            }
            }catch (Exception e){
                System.out.println("\u001B[31m"+"Something went wrong with your priority setting. Defaulting value to 0 (PENDING)."+"\u001B[0m");
            }
        }

        Task newTask = new Task(title,description,priority,status);
        crud.create(title,description,priority,intstatus);
        System.out.println("This is the new task you've added:\n" + newTask);

        menu(showOptions());
    }



    private void modifyTask() {
        Scanner sc = new Scanner(System.in);
        Task oldTask;
        Task newTask = new Task();
        String oldTitle, title, oldDescription ,description;
        int oldPriority, priority, oldStatus, Status;
        System.out.print("Name of the task to modify: ");
        oldTitle = sc.nextLine().trim();
        List<Task> taskTemporal = crud.getTaskByName(oldTitle);
        if (taskTemporal.get(0) == null) return;
        System.out.println("You will modify this task: ");
        oldTask = taskTemporal.get(0);
        System.out.println(oldTask);
        System.out.println("Task modification in progres...");
        System.out.println("EMPTY to keep (old values)");
        System.out.print("Tittle (" + oldTask.getTitle() + "): ");
        newTask.setTitle(sc.nextLine());
        if (newTask.getTitle().equals("")) {
            newTask.setTitle(oldTask.getTitle());
        }
        System.out.print("Description: (" + oldTask.getDescription() + "): ");
        newTask.setDescription(sc.nextLine());
        if (newTask.getDescription().equals("")) {
            newTask.setDescription(oldTask.getDescription());
        }
        System.out.print("Priority (" + oldTask.getPriority() + "): ");
        String temporal = sc.nextLine().trim();
        try {
            newTask.setPriority(Integer.parseInt(temporal));
        } catch (Exception e) {
            newTask.setPriority(oldTask.getPriority());
        }
        if (String.valueOf(newTask.getPriority()).equals("")) {
            newTask.setPriority(oldTask.getPriority());
        }
        System.out.print("Stuts (" + oldTask.getStatus() + "): ");
        temporal = sc.nextLine().trim();

        try {
            newTask.setStatus(Task.Status.fromValue(Integer.parseInt(temporal)));
        } catch (Exception e) {
            newTask.setStatus(oldTask.getStatus());
        }
        if (String.valueOf(newTask.getStatus()).equals("")) {
            newTask.setStatus(oldTask.getStatus());
        }
        crud.update(oldTitle, newTask.getTitle(), newTask.getDescription(), newTask.getPriority(), newTask.getStatus().getValue());
        System.out.println("\nTask modified successfully, task:");
        System.out.println(newTask);
        menu(showOptions());
    }

    private void deleteTask() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Name of the task to delete: ");
        String title = sc.nextLine().trim();
        List<Task> taskTemporal = crud.getTaskByName(title);
        System.out.println(taskTemporal);
        System.out.println("You will delete this task/s, if empty there's no task with such name.");
        System.out.print("This is an action without and UNDO, make sure to think twice before delete.\nYes to delete Ctrl + c to force quit.");
        sc.nextLine();
        int response = crud.delete(title);
        if (response == 1) System.out.println("The task \"" + title +"\" has been successfully deleted.");
        else System.out.println("Wrong task name.");
        menu(showOptions());
    }

    private void listOptions() {
        Scanner sc = new Scanner(System.in);
        try{
        System.out.println("\u001B[0m");
        System.out.println("Filter by:\n");
        System.out.println("\t1 - All");
        System.out.println("\t2 - Name");
        System.out.println("\t3 - Priority");
        System.out.println("\t4 - Status");
        System.out.println("\t5 - Go Back");
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
                    System.out.print("NAME: ");
                    crud.selectByName(sc.nextLine());
                }
                catch(Exception e){
                    System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
                }

               break;

            case 3:
                try {
                    System.out.print("PRIORITY: ");
                    crud.selectByPriority(sc.nextInt());
                }
                catch(Exception e){
                    System.out.println("\u001B[31m"+"\n\tThere has been an issue with your option select. Please try again with an option from 1-5.");
                }
                break;

            case 4:
                try {
                    System.out.print("STATUS(0-3): ");
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
