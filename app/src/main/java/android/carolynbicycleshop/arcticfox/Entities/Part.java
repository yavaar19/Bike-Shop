package android.carolynbicycleshop.arcticfox.Entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

/**
 * Project: Bike Arctic Fox
 * Package: android.carolynbicycleshop.arcticfox.Entities
 * <p>
 * User: carolyn.sher
 * Date: 12/17/2021
 * Time: 2:55 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Entity(tableName="parts")
public class Part {
    @PrimaryKey(autoGenerate = true)
    private int partID;

    private String partName;
    private double price;
    private int productID;

    public Part(int partID, String partName, double price, int productID) {
        this.partID = partID;
        this.partName = partName;
        this.price = price;
        this.productID = productID;
    }

    public int getPartID() {
        return partID;
    }

    public void setPartID(int partID) {
        this.partID = partID;
    }

    public String getPartName() {
        return partName;
    }

    public void setPartName(String partName) {
        this.partName = partName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }
}
