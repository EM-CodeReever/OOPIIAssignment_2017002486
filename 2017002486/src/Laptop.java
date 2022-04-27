//Elliot Morrison
//2017002486
import java.util.ArrayList;
import java.io.*;


public class Laptop implements Serializable {
    private int LaptopId;
    private String Brand;
    private String Model;
    private float Price;
    private String ManufactureDate;
    private int Quantity;

    public Laptop() {
        LaptopId = 0;
        Brand = "";
        Model = "";
        Price = 1300.50f;
        ManufactureDate = "2000/1/1";
        Quantity = 0;
    }
    public Laptop(int laptopId, String brand, String model, Float price, String manufactureDate, int quantity) {
        LaptopId = laptopId;
        Brand = brand;
        Model = model;
        Price = price;
        ManufactureDate = manufactureDate;
        Quantity = quantity;
    }
    public Laptop(Laptop l){
        LaptopId = l.LaptopId;
        Brand = l.Brand;
        Model = l.Model;
        Price = l.Price;
        ManufactureDate = l.ManufactureDate;
        Quantity = l.Quantity;
    }

    public int getLaptopId() {
        return LaptopId;
    }

    public void setLaptopId(int laptopId) {
        LaptopId = laptopId;
    }

    public String getBrand() {
        return Brand;
    }

    public void setBrand(String brand) {
        Brand = brand;
    }

    public String getModel() {
        return Model;
    }

    public void setModel(String model) {
        Model = model;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        Price = price;
    }

    public String getManufactureDate() {
        return ManufactureDate;
    }

    public void setManufactureDate(String manufactureDate) {
        ManufactureDate = manufactureDate;
    }

    public int getQuantity() {
        return Quantity;
    }

    public void setQuantity(int quantity) {
        Quantity = quantity;
    }

    public void WriteToFile(ArrayList<Laptop> LaptopList){
        try {
            FileOutputStream fileOut = new FileOutputStream("./laptop.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(LaptopList);
            out.close();
            fileOut.close();
            System.out.println("Data is saved in ./laptop.ser");
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }
    public ArrayList<Laptop> ReadFromFile(){
        ArrayList<Laptop> LaptopList = new ArrayList<>();
        try {
            FileInputStream fileIn = new FileInputStream("./laptop.ser");
            ObjectInputStream fin = new ObjectInputStream(fileIn);
            LaptopList = (ArrayList<Laptop>)fin.readObject();
            fin.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
        } catch (ClassNotFoundException c) {
            System.out.println("Laptop class not found");
            c.printStackTrace();
        }
        return LaptopList;
    }
    public boolean FileInitialization(){
        File laptopFile = new File("./laptop.ser");
        boolean FileInitialized = true;
        try {
            if (!laptopFile.exists()) {
                laptopFile.createNewFile();
            }else{
                FileInitialized = false;
            }
        }catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
        return FileInitialized;
    }

    public void Display(){
        System.out.println(this);
    }

    public float calculatePrice(){
        return Quantity * Price;
    }
    @Override
    public String toString() {
        return "Laptop{" +
                "LaptopId=" + LaptopId +
                ", Brand='" + Brand + '\'' +
                ", Model='" + Model + '\'' +
                ", Price=" + Price +
                ", ManufactureDate='" + ManufactureDate + '\'' +
                ", Quantity=" + Quantity +
                '}';
    }
    public static class ListTracker{
       public static ArrayList<Laptop> LaptopList = new ArrayList<>();
    }
}
