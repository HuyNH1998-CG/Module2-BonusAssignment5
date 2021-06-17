import java.util.Scanner;

public class Menu {
    public Scanner input = new Scanner(System.in);
    ManageBook manageBook = new ManageBook();
    public void menu() {
        while (true) {
            welcome();
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1 -> insert();
                case 2 -> edit();
                case 3 -> remove();
                case 4 -> search();
                case 5 -> sort();
                case 6 -> {
                    System.out.println("Exiting.....");
                    System.exit(0);
                }
            }
        }
    }

    private void welcome() {
        System.out.println("Welcome");
        System.out.println("1.Insert book");
        System.out.println("2.Edit book");
        System.out.println("3.Remove Book");
        System.out.println("4.Search Book");
        System.out.println("5.Sort Book");
        System.out.println("6.Exit");
    }

    public void insert() {
        manageBook.insert();
    }

    public void edit() {
        manageBook.update();
    }

    public void remove() {
        manageBook.remove();
    }

    public void search() {
        manageBook.search();
    }

    public void sort() {
        manageBook.sort();
    }
}
