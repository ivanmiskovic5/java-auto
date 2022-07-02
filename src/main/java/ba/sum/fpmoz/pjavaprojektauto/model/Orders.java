package ba.sum.fpmoz.pjavaprojektauto.model;

public class Orders extends Table{
    @Entity(type="INTEGER", size=32, primary = true)
    int ID;

    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String owner;

    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String company;

    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String date;

    @ForeignKey(table = "Cars", attribute = "ID")
    @Entity(type = "INTEGER", size = 32)
    int carsID;

    @ForeignKey(table = "Customers", attribute = "ID")
    @Entity(type = "INTEGER", size = 32)
    int customersID;

    @ForeignKey(table = "Workers", attribute = "ID")
    @Entity(type = "INTEGER", size = 32)
    int workersID;

    public int getID() {
        return ID;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getCarsID() {
        return carsID;
    }

    public void setCarsID(int carsID) {
        this.carsID = carsID;
    }

    public int getCustomersID() {
        return customersID;
    }

    public void setCustomersID(int customersID) {
        this.customersID = customersID;
    }

    public int getWorkersID() {
        return workersID;
    }

    public void setWorkersID(int workersID) {
        this.workersID = workersID;
    }
}
