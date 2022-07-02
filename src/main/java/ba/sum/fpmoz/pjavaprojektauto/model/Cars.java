package ba.sum.fpmoz.pjavaprojektauto.model;

public class Cars extends Table{
    @Entity(type="INTEGER", size=32, primary = true)
    int ID;

    @Entity(type = "CHAR", size = 4, isnull = false)
    String year;
    /*
        @TODO add ENUM datatype
     */
    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String conditions;
    /*
        @TODO add ENUM datatype
     */
    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String availabilities;

    @ForeignKey(table = "Brands", attribute = "ID")
    @Entity(type = "INTEGER", size = 32)
    int brandsID;

    public int getID() {
        return ID;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getConditions() {
        return conditions;
    }

    public void setConditions(String conditions) {
        this.conditions = conditions;
    }

    public String getAvailabilities() {
        return availabilities;
    }

    public void setAvailabilities(String availabilities) {
        this.availabilities = availabilities;
    }

    public int getBrandsID() {
        return brandsID;
    }

    public void setBrandsID(int brandsID) {
        this.brandsID = brandsID;
    }
}
