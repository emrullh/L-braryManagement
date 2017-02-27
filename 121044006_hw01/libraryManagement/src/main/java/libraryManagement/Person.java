
package libraryManagement;
/**
 * Created by egc on 2/22/2017.
 */
public interface Person {
    /**
     *
     * @return name of the user
     */
    public String getName();

    /**
     *
     * @return surname of the user
     */
    public String getSurname();

    /**
     *
     * @return type of the user
     */
    public String getUserType();

    /**
     *
     * @param name set name of the user
     */
    public void setName(String name);


    /*
     * set surname of the user
     */
    public void setSurname(String surname);

    /**
     *
     * @param type set type of the user
     */
    public void setUserType(String type);
}
