package ba.sum.fpmoz.pjavaprojektauto.model;

public class Brands extends Table {
    @Entity(type="INTEGER", size=32, primary = true)
    int ID;

    @Entity(type = "VARCHAR", size = 15, isnull = false)
    String Brand;

    @Entity(type = "VARCHAR", size = 20, isnull = false)
    String Origin;

    @ForeignKey(table = "Models", attribute = "ID")
    @Entity(type = "INTEGER", size = 32)
    int ModelsID;

    public int getID() {
        return ID;
    }


    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getOrigin() {
        return Origin;
    }

    public void setOrigin(String origin) {
        Origin = origin;
    }

    public int getModelsID() {
        return ModelsID;
    }

    public void setModelsID(int modelsID) {
        ModelsID = modelsID;
    }
}
