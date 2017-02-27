package libraryManagement;



/**
 * Created by egc on 2/23/2017.
 */
public class LibUser extends AbstractPerson {

    /**
     * default constractor
     */
    public LibUser(){
        setName("");
        setSurname("");
        setUserType("");
    }

    /**
     *
     * consractor
     * @param name  name of user
     * @param surname  surname of user
     */
    public LibUser(String name,String surname){
        setName(name);
        setSurname(surname);
        setUserType("library user");
    }

    /**
     *
     * Constractor
     * @param name name of user
     * @param surname surname of user
     * @param userType type of user
     */
    public LibUser(String name ,String surname,String userType){
        setName(name);
        setSurname(surname);
        setUserType(userType);

    }

    /**
     *
     * @see libraryManagement.AbstractPerson#addUser(AbstractPerson)
     */
    @Override
    public boolean addUser(AbstractPerson absPerson) {

            try{
                if ( absPerson instanceof Administrator)
                    throw new IllegalArgumentException();
                else if ( absPerson instanceof LibUser)
                    throw new IllegalArgumentException();

            }
            catch (IllegalArgumentException e){
                System.out.printf("Library User do not add new user ...");
                return false;
            }
            return false;


    }

    /**
     *
     *@see libraryManagement.AbstractPerson#saveUsersToFile(String)
     */
    @Override
    public void saveUsersToFile(String filename) {
        try{
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){
            System.out.printf("Illegal Operation...");
        }
    }

    /**
     *
     * @see libraryManagement.AbstractPerson#loadUsersFromFile(String)
     */
    @Override
    public void loadUsersFromFile(String filename) {
        try{
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){
            System.out.printf("Illegal Operation...");
        }
    }
    /**
     * kullanicinin sisteme  kendini  kaydetme
     */
    public void registerLibUser(){
        users.add(this);
    }

    /**
     *
     * Bu method kullanicinin sistemden odunc kitap almasini saglar
     * @param book istenilen kitabin objesi
     * @return boolean
     */
    public boolean borrowBook(Book book){

        for (int j = 0; j < books.size() ; ++j)
            if (books.get(j).getBookName()==book.getBookName() && books.get(j).getStock() == true) {
                books.get(j).libUser = this;
                books.get(j).setStock(false);
                System.out.println(">> "+getName() + " , " + book.getBookName() + "  kitabini aldi.");
                return true;
            }
        System.out.println(">> "+getName() + " , " + book.getBookName() + "  kitabini alamadi.");
        return false;
    }

    /**
     *
     * Bu method kullanicinin odunc aldigi kitabi geri getirmesi
     * @param book geri verilen kitap objesi
     * @return boolean basariliysa true return eder.
     */
    public boolean returnBook(Book book){

            for(int j=0;j<books.size();++j)
                if (books.get(j).getBookName()==book.getBookName() && books.get(j).getStock() == false){
                    books.get(j).libUser = null;
                    books.get(j).setStock(true);
                    System.out.println(">> "+getName() + " , " + book.getBookName() + "  kitabini geri birakti.");
                    return true;
                }
       // System.out.println(">> "+" kayitlarda bu kitap yoktur.");
        return false;
    }

    /**
     *
     * Bu method sistemdeki kitaplari goruntuler
     */
    public void viewBooks(){
       for(int i=0;i<books.size();++i)
           System.out.println(books.get(i).getBookName() + " " + books.get(i).getAuthor() + " " +books.get(i).getStock());
    }

    /**
     * Bu method sistemdeki kitaplari gunceller
     * @param admin kitaplarin bulundugu obje
     * @return Administrator
     */
    public Administrator updateData(Administrator admin){
        Administrator admin1=new Administrator(admin.getName(),admin.getSurname(),"Administrator");
        for(int i=0;i<books.size();++i){
            admin1.books.add(books.get(i));
        }
        return admin1;
    }

    /**
     *
     */
    @Override
    public void viewUsers(){
        try{
            throw new IllegalArgumentException();
        }
        catch(IllegalArgumentException e){
            System.out.printf("Illegal Operation...");
        }
    }
}
