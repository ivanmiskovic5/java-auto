package ba.sum.fpmoz.pjavaprojektauto.model;

public class Customers extends Table {
    @Entity(type="INTEGER", size=32, primary = true)
    int ID;
    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String name;
    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String lastname;
    /*
        @TODO add unique constraint
     */
    @Entity(type = "CHAR", size = 13, isnull = false)
    String uid;
    /*
        @TODO add unique constraint
     */
    @Entity(type = "VARCHAR", size = 30, isnull = false)
    String email;

    @Entity(type = "VARCHAR", size = 50, isnull = false)
    String adress;
    /*
        @TODO add unique constraint
     */
    @Entity(type = "VARCHAR", size = 15, isnull = false)
    String phone;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
