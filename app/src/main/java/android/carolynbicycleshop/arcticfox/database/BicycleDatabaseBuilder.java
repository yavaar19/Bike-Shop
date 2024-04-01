package android.carolynbicycleshop.arcticfox.database;

import android.carolynbicycleshop.arcticfox.DAO.PartDAO;
import android.carolynbicycleshop.arcticfox.DAO.ProductDAO;
import android.carolynbicycleshop.arcticfox.Entities.Part;
import android.carolynbicycleshop.arcticfox.Entities.Product;
import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/**
 * Project: Bike Arctic Fox
 * Package: android.carolynbicycleshop.arcticfox.database
 * <p>
 * User: carolyn.sher
 * Date: 12/17/2021
 * Time: 3:08 PM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */
@Database(entities = {Product.class, Part.class}, version = 1,exportSchema = false)
public abstract class BicycleDatabaseBuilder extends RoomDatabase {
    public abstract ProductDAO productDAO();
    public abstract PartDAO partDAO();

    private static volatile BicycleDatabaseBuilder INSTANCE;

    static BicycleDatabaseBuilder getDatabase(final Context context){
        if(INSTANCE==null){
            synchronized (BicycleDatabaseBuilder.class){
                if(INSTANCE==null){
                    INSTANCE= Room.databaseBuilder(context.getApplicationContext(),BicycleDatabaseBuilder.class,"MyBicycleDatabase.db")
                    .fallbackToDestructiveMigration()
                    .build();
                }
            }
        }
        return INSTANCE;
    }
}
