package libraryManagement;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {


        System.out.println(" *********************************************");
        System.out.println(" *****************   MENU  *******************");
        System.out.println(" *                                           *");
        System.out.println(" *  SCENARIO FOR ADMINISTRATOR      => 1     *");
        System.out.println(" *  SCENARIO FOR LIBRARY USER       => 2     *");
        System.out.println(" *  SCENARIO FOR GET DATA FROM FILE => 3     *");
        System.out.println(" *  SCENARIO FOR POLYMORHPHISM      => 4     *");
        System.out.println(" *                                           *");
        System.out.println(" *********************************************");

        Scanner reader = new Scanner(System.in);  // Reading from System.in
        System.out.println("Enter a number: ");
        int choose = reader.nextInt();

        // SCENARIO FOR ADMINISTRATOR
        if (choose == 1) {
            System.out.println("------------ SCENARIO FOR ADMINISTRATOR ---------");
            System.out.println();

            Administrator admin = new Administrator("admin", "surname", "Administrator");

            Book book1 = new Book("The Stand", "Stephen King", true);
            Book book2 = new Book("On The Road", "Jack Kerouac", true);
            Book book3 = new Book("Into The Wild", "Alexandre Supertrump", true);

            System.out.println("---- Books were added on system.");
            admin.addBook(book1);
            admin.addBook(book2);
            admin.addBook(book3);

            System.out.println("++++ List of books on system.");
            admin.viewBooks();
            System.out.println();

            LibUser user1 = new LibUser("Joey", "Tribbiani", "library user");
            LibUser user2 = new LibUser("Chandler", "Bing", "library user");
            LibUser user3 = new LibUser("Phoebe", "Buffay");

            System.out.println("---- Users were added on system.");
            admin.addUser(user1);
            admin.addUser(user2);// Polymorfism
            admin.addUser(user3);
            admin.addUser(admin);

            System.out.println("++++ List of users on system.");
            admin.viewUsers();
            System.out.println();

            admin.removeBook(book2);
            System.out.println("---- "+book2.getBookName()+" was deleted from the system.");

            System.out.println("++++ List of books on system.");
            admin.viewBooks();
            System.out.println();

            admin.addBook(book2); //sisteme yeniden eklendi

            System.out.println(" Users and books were saved on files by Administrator");
            System.out.println();
            admin.saveUsersToFile("users.csv");
            admin.saveBooksToFile("books.csv");

        } else if (choose == 2) {
            System.out.println("------------ SCENARIO FOR LIBRARY USER ---------");
            System.out.println();

            Administrator admin1 = new Administrator("admin1", "surname1", "Administrator");

            Book book1 = new Book("The Stand", "Stephen King", true);
            Book book2 = new Book("On The Road", "Jack Kerouac", true);
            Book book3 = new Book("Into The Wild", "Alexandre Supertrump", true);

            admin1.addBook(book1);
            admin1.addBook(book2);
            admin1.addBook(book3);

            LibUser user4 = new LibUser("Joey", "Tribbiani", "library user");
            LibUser user5 = new LibUser("Chandler", "Bing", "library user");
            LibUser user6 = new LibUser("Phoebe", "Buffay");

            System.out.println("---- Users were added on system.");
            user4.registerLibUser();
            user5.registerLibUser();
            user6.registerLibUser();

            user4 = admin1.addLibUser(user4);
            user5 = admin1.addLibUser(user5);
            user6 = admin1.addLibUser(user6);

            System.out.println("++++ List of users on system.");
            admin1.viewUsers();
            System.out.println();


            System.out.println("---- Borrowing scenario of users.");
            user4.borrowBook(book1);
            user5.borrowBook(book2);
            user6.borrowBook(book3);

            System.out.println("++++ Availability of books on the system");
            admin1 = user6.updateData(admin1);
            admin1.viewBooks();
            System.out.println();

            System.out.println("---- User's books returning scenario");
            user4.returnBook(book1);
            user5.returnBook(book2);
            user6.returnBook(book3);

            System.out.println("++++ Availability of books on the system");
            admin1 = user6.updateData(admin1);
            admin1.viewBooks();
            System.out.println();

        }else if(choose==3) {
            System.out.println("------------ SCENARIO FOR GET DATA FROM FILE ---------");
            System.out.println();
            Administrator admin1 = new Administrator("admin1", "surname1", "Administrator");


            admin1.loadUsersFromFile("users.csv");
            admin1.loadBooksFromFile("books.csv");

            System.out.println("++++ List of users on system.");
            admin1.viewUsers();
            System.out.println();


            LibUser user1 = (LibUser) admin1.users.get(0);
            LibUser user2 = (LibUser) admin1.users.get(1);
            LibUser user3 = (LibUser) admin1.users.get(2);

            Book book1 = admin1.books.get(0);
            Book book2 = admin1.books.get(1);
            Book book3 = admin1.books.get(2);

            user1.registerLibUser();
            user2.registerLibUser();
            user3.registerLibUser();

            user1 = admin1.addLibUser(user1);
            user2 = admin1.addLibUser(user2);
            user3 = admin1.addLibUser(user3);


            System.out.println("---- Borrowing scenario of users.");
            user1.borrowBook(book1);
            user2.borrowBook(book2);
            user3.borrowBook(book1);

            admin1 = user3.updateData(admin1);

            System.out.println("++++ Availability of books on the system");

            admin1.viewBooks();
            System.out.println();

            System.out.println("---- User's books returning scenario");
            user1.returnBook(book1);
            user2.returnBook(book2);
            user3.returnBook(book3);

            admin1 = user3.updateData(admin1);

            System.out.println("++++ Availability of books on the system");
            // admin1 =((LibUser)admin1.users.get(2)).updateData(admin1);
            admin1.viewBooks();
            System.out.println();
        }else if(choose==4){

            System.out.println("------------ SCENARIO FOR POLYMORHPHISM  ---------");

            AbstractPerson absPerson = new Administrator("absAdmin","absSurname","Administrator");
            LibUser libUser = new LibUser("Emrullah","Gencoglu");
            absPerson.addUser(libUser);

            System.out.println("++++ List of users on system.");
            absPerson.viewUsers();
            System.out.println();

        }

    }

}

