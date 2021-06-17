import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class ManageBook {
    Book[] list = new Book[0];
    Scanner input = new Scanner(System.in);
    Comparator<Book> comparator = Comparator.comparing(Book::getName);

    public void insert() {
        System.out.println("Adding new Classes");
        System.out.println("Input ID");
        int id = input.nextInt();
        input.nextLine();
        System.out.println("Input Name");
        String name = input.nextLine();
        System.out.println("Input Publish Date");
        String publishDate = input.nextLine();
        System.out.println("Input Author");
        String author = input.nextLine();
        System.out.println("Input Language");
        String language = input.nextLine();
        System.out.println("Input price");
        float price = Float.parseFloat(input.nextLine());
        Book book = new Book(id, name, publishDate, author, language, price);
        Book[] newList = new Book[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        newList[newList.length - 1] = book;
        list = newList;
    }

    public void remove() {
        System.out.println("Input Book ID to delete");
        Book[] newList = new Book[list.length - 1];
        int id = input.nextInt();
        int start = 0;
        for (int i = 0; i < list.length; i++) {
            if (id == list[i].getId()) {
                start = i;
            }
        }
        for (int i = start; i < list.length - 1; i++) {
            list[i] = list[i + 1];
        }
        list[list.length - 1] = null;
        for (int i = 0; i < newList.length; i++) {
            newList[i] = list[i];
        }
        list = newList;
    }

    public void update() {
        System.out.println("Input Book ID to update");
        int id = Integer.parseInt(input.nextLine());
        for (Book B : list) {
            if (B.getId() == id) {
                updateChoice(B);
                return;
            }
        }
    }

    private void updateChoice(Book B) {
        System.out.println("What to change");
        System.out.println("1. ID");
        System.out.println("2. Name");
        System.out.println("3. Publish date");
        System.out.println("4. Author");
        System.out.println("5. Language");
        int choice = Integer.parseInt(input.nextLine());
        switch (choice) {
            case 1 -> {
                System.out.println("Input new ID");
                int ID = Integer.parseInt(input.nextLine());
                B.setId(ID);
            }
            case 2 -> {
                System.out.println("Input new name");
                String name = input.nextLine();
                B.setName(name);
            }
            case 3 -> {System.out.println("Input new publish date");
                String publishDate = input.nextLine();
                B.setPublishDate(publishDate);
            }
            case 4 -> {System.out.println("Input new author");
                String author = input.nextLine();
                B.setAuthor(author);
            }
            case 5 -> {System.out.println("Input new language");
                String language = input.nextLine();
                B.setLanguage(language);
            }
        }
    }

    public void search() {
        System.out.println("Input Book name to search");
        String name = input.nextLine();
        for(Book B: list){
            if(B.getName().equals(name)){
                B.display();
            }
        }
    }

    public void sort() {
        Arrays.sort(list,comparator);
        for(Book B : list){
            B.display();
        }
    }

}
