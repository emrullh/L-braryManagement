package libraryManagement;

import java.io.File;
import java.util.ArrayList;
/**
 *
 * @author emrullah
 * implement interface class
 *
 */
public abstract class AbstractPerson implements Person {

    private String name;

    private String surname;

    private String userType;

    /**
     * users ArrayList hold the all type which will be inherited from abstract class
     */
    protected ArrayList<AbstractPerson> users = new ArrayList<AbstractPerson>();

    /**
     * books ArrayList hold the all type which will be inherited from abstract class
     */
    protected ArrayList<Book> books=new ArrayList<Book>();
    /**
     *
     * @see libraryManagement.Person#setName(String)
     */
    public void setName(String name){
        this.name=name;
    }

    /**
     *
     * @see  Person#getSurname()
     */
    public void setSurname(String surname){
        this.surname=surname;
    }

    /**
     *
     * @see Person#getUserType()
     */
    public void setUserType(String userType){
        this.userType=userType;
    }

    /**
     *
     * @see Person#getName()
     */
    public String getName(){
        return name;
    }

    /**
     *
     * @see libraryManagement.Person#setUserType(String)
     */
    public String getUserType() {
        return userType;
    }

    /**
     *
     * @see Person#getSurname()
     */
    public String getSurname() {
        return surname;
    }

    /**
     *
     * Bu method sisteme yeni kullanici ekler.(Polymorpic method)
     * @param absPerson sisteme kaydedilecek kullanicinin objesi
     * @return boolean basarili bir sekilde eklenildiginde true return eder.
     */
    public abstract boolean addUser(AbstractPerson absPerson);
    /**
     *
     * Bu method kullanicilari dosyaya kaydetmek icin kullanilir.
     * @param filename kullanicilarin kayit edilecegi dosya adi
     */
    public abstract void saveUsersToFile( String filename);

    /**
     *
     * Bu method kullanicilarin bilgilerini dosyadan alir.
     * @param filename kullanicilarin bilgilerinin alinacagi dosya adi
     */
    public abstract void loadUsersFromFile(String filename);

    public abstract void viewUsers();

}
