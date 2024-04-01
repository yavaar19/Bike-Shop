package android.carolynbicycleshop.arcticfox.DAO;

import android.carolynbicycleshop.arcticfox.Entities.Product;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

/**
 * Project: Bike Arctic Fox
 * Package: android.carolynbicycleshop.arcticfox.DAO
 * <p>
 * User: carolyn.sher
 * Date: 12/17/2021
 * Time: 2:58 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Dao
public interface ProductDAO {
    @Insert(onConflict= OnConflictStrategy.IGNORE)
    void insert(Product product);

    @Update
    void update(Product product);

    @Delete
    void delete(Product product);

    @Query("SELECT * FROM PRODUCTS ORDER BY productID ASC")
    List<Product> getAllProducts();
}
