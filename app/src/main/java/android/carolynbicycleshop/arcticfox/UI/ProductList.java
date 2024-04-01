package android.carolynbicycleshop.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.carolynbicycleshop.arcticfox.Entities.Product;
import android.carolynbicycleshop.arcticfox.R;
import android.carolynbicycleshop.arcticfox.database.Repository;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.List;

public class ProductList extends AppCompatActivity {
    private Repository repository;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        repository=new Repository(getApplication());
        List<Product> allProducts=repository.getAllProducts();
        RecyclerView recyclerView=findViewById(R.id.recyclerview);
        final ProductAdapter productAdapter=new ProductAdapter(this);
        recyclerView.setAdapter(productAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productAdapter.setProducts(allProducts);
    }
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_productlist, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.productrefresh:
                repository=new Repository(getApplication());
                List<Product> allProducts=repository.getAllProducts();
                RecyclerView recyclerView=findViewById(R.id.recyclerview);
                final ProductAdapter productAdapter=new ProductAdapter(this);
                recyclerView.setAdapter(productAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                productAdapter.setProducts(allProducts);
        }
        return super.onOptionsItemSelected(item);
    }

    public void enterPartsList(View view) {
        Intent intent=new Intent(ProductList.this,PartList.class);
        startActivity(intent);
    }
}