package libraryManagement;

import java.io.*;

/**
 * Created by egc on 2/23/2017.
 */
public class Administrator extends AbstractPerson {

    /**
     * Administrator constructor sets name surname and type
     */
    public Administrator(){
        setName("Admin");
        setSurname("");
        setUserType("Administrator");
    }
    /**
     * Administrator constructor sets name surname and type
     * @param name name of admin
     */
    public Administrator(String name){
        setName(name);
        setSurname("");
        setUserType("Administrator");
    }

    /**
     * Administrator constructor sets name surname and type
     * @param name name of admin
     * @param surname surname of admin
     * @param type  type of user
     */
    public Administrator(String name,String surname,String type){
        setName(name);
        setSurname(surname);
        setUserType(type);
    }

    /**
     *
     * @see libraryManagement.AbstractPerson#addUser(AbstractPerson)
     * Polymorfic code absPerson gets different type user like (library  user and adminisrator)
     */
    @Override
    public boolean addUser(AbstractPerson absPerson) {
        if ( absPerson instanceof Administrator ||
                absPerson instanceof LibUser){
            users.add(absPerson);
            return true;
        }

        return false;
    }

    /**
     *
     *@see libraryManagement.AbstractPerson#saveUsersToFile(String)
     */
    @Override
    public void saveUsersToFile( String filename) {

        FileWriter fileWriter = null;

        try{
            fileWriter = new FileWriter(filename);
            for(int i=0;i<users.size();++i){
                //System.out.println(users.get(i).getName());
                fileWriter.append(String.valueOf(users.get(i).getName()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(users.get(i).getSurname()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(users.get(i).getUserType()));
                fileWriter.append("\n");
            }
        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }

    }

    /**
     *
     * @see libraryManagement.AbstractPerson#loadUsersFromFile(String)
     */
    @Override
    public void loadUsersFromFile(String filename) {

        String line = "";
        String cvsSplitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) {
                // use comma as separator

                String[] token = line.split(cvsSplitBy);

                if(token[2].compareTo("Administrator")==0) {

                   users.add(new Administrator(token[0],token[1],token[2]));
                    //System.out.println(token[0] + " " + token[1] + " " + token[2]);
                }else if(token[2].compareTo("library user")==0){

                    users.add(new LibUser(token[0],token[1],token[2]));
                    //System.out.println(token[0] + " " + token[1] + " " + token[2]);
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Bu method sisteme yeni kitap ekler.
     * @param newBook eklenecek kitap objesi
     * @return sisteme eklendiginde true return eder.
     */
    public boolean addBook(Book newBook){

        books.add(newBook);
        /*for(int i=0;i<books.size();++i)
            System.out.println(books.get(i).getBookName());*/
        return true;
    }

    /**
     *
     * Bu method sistemden kitabi siler.
     * @param oldBook silinecek kitap objesi
     * @return silindiginde true return eder.
     */
    public boolean removeBook(Book oldBook){
        for(int i=0;i<books.size();++i)
            if(books.get(i).getBookName()== oldBook.getBookName() && books.get(i).getAuthor() == oldBook.getAuthor()){
                books.remove(i);
                return true;
            }
        return false;
    }

    /**
     *
     * Bu method kitaplari dosyaya kaydeder.
     * @param filename kayit yapilan dosya adi.
     */
    public void saveBooksToFile( String filename) {

        FileWriter fileWriter = null;

        try{

            fileWriter = new FileWriter(filename);
            for(int i=0;i<books.size();++i){

                fileWriter.append(String.valueOf(books.get(i).getBookName()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(books.get(i).getAuthor()));
                fileWriter.append(",");
                fileWriter.append(String.valueOf(books.get(i).getStock()));
                fileWriter.append("\n");
            }

        } catch (Exception e) {
            System.out.println("Error in CsvFileWriter !!!");
            e.printStackTrace();
        }finally {

            try {
                fileWriter.flush();
                fileWriter.close();
            } catch (IOException e) {
                System.out.println("Error while flushing/closing fileWriter !!!");
                e.printStackTrace();
            }

        }

    }

    /**
     *
     * Bu method kitap bilgilerini dosyadan veri yapisina aktarir.
     * @param filename bilgilerin alindigi dosya adi.
     */
    public void loadBooksFromFile(String filename) {

        String line = "";
        String cvsSplitBy = ",";

        try {
            BufferedReader br = new BufferedReader(new FileReader(filename));

            while ((line = br.readLine()) != null) {
                String[] token = line.split(cvsSplitBy);

                if(token[2].compareTo("true")==0)
                    books.add(new Book(token[0],token[1],true));
                else
                    books.add(new Book(token[0],token[1],false));

                //System.out.println(token[0] + " " + token[1] + " " + token[2]);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * Bu method sistem deki kullanicilari goruntuler.
     */
    @Override
    public void viewUsers(){
        for (int i=0;i<users.size();++i){

            System.out.print(users.get(i).getName());
            System.out.printf(" / ");
            System.out.print(users.get(i).getSurname());
            System.out.printf(" / ");
            System.out.println(users.get(i).getUserType());
        }
    }

    /**
     *
     * Bu method sistemdeki kitaplari goruntuler
     */
    public void viewBooks(){

        for(int i=0;i<books.size();++i){

            System.out.println(books.get(i).getBookName() + " / " + books.get(i).getAuthor() + " / " +books.get(i).getStock());
        }
    }

    /**
     *
     * Bu method sisteme library kullanicisi ekler.
     * @param libUser eklenecek kullanici objesi.
     * @return LibUser kullanici objesi return eder.
     */
    public LibUser addLibUser(LibUser libUser){

        users.add(new LibUser(libUser.getName(),libUser.getSurname(),libUser.getUserType()));
        LibUser libUser1=new LibUser(libUser.getName(),libUser.getSurname(),"library user");
        for(int i=0;i<books.size();++i){
            libUser1.books.add(books.get(i));
        }
        return libUser1;
    }


}
