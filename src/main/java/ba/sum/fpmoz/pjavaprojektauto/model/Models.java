package ba.sum.fpmoz.pjavaprojektauto.model;

public class Models extends Table{
    @Entity(type="INTEGER", size=32, primary = true)
    int ID;
    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String name;

    @Entity(type = "VARCHAR", size = 10, isnull = false)
    int price;

    public int getID() {
        return ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
