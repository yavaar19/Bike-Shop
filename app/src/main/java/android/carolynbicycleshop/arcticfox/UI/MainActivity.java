package android.carolynbicycleshop.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;

import android.carolynbicycleshop.arcticfox.Entities.Part;
import android.carolynbicycleshop.arcticfox.Entities.Product;
import android.carolynbicycleshop.arcticfox.R;
import android.carolynbicycleshop.arcticfox.database.Repository;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    public static int numAlert;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //I'm changing my code
        //I'm changing my code again
        Repository repo=new Repository(getApplication());
        Product product= new Product(1,"bicycle", 100.0);
        repo.insert(product);
        Part part=new Part(1,"wheel",10.0,1);
        repo.insert(part);
    }

    public void enterApp(View view) {
        Intent intent=new Intent(MainActivity.this,ProductList.class);
        startActivity(intent);
    }
}