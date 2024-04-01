package android.carolynbicycleshop.arcticfox.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.carolynbicycleshop.arcticfox.Entities.Part;
import android.carolynbicycleshop.arcticfox.Entities.Product;
import android.carolynbicycleshop.arcticfox.R;
import android.carolynbicycleshop.arcticfox.database.Repository;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PartList extends AppCompatActivity {
    String name;
    double price;
    int productID;
    EditText editName;
    EditText editPrice;
    Repository repository;
    Product currentProduct;
    int numParts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_part_list);
        name = getIntent().getStringExtra("name");
        editName = findViewById(R.id.productname);
        editName.setText(name);
        price = getIntent().getDoubleExtra("price", -1.0);
        editPrice = findViewById(R.id.productprice);
        editPrice.setText(Double.toString(price));
        productID = getIntent().getIntExtra("id", -1);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        RecyclerView recyclerView = findViewById(R.id.partrecyclerview);
        repository = new Repository(getApplication());
        final PartAdapter partAdapter = new PartAdapter(this);
        recyclerView.setAdapter(partAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        List<Part> filteredParts= new ArrayList<>();
        for(Part p:repository.getAllParts()){
            if(p.getProductID()==productID)filteredParts.add(p);
        }
        partAdapter.setParts(filteredParts);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_partlist, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            case R.id.partrefresh:
                RecyclerView recyclerView = findViewById(R.id.partrecyclerview);
                repository = new Repository(getApplication());
                final PartAdapter partAdapter = new PartAdapter(this);
                recyclerView.setAdapter(partAdapter);
                recyclerView.setLayoutManager(new LinearLayoutManager(this));
                List<Part> filteredParts = new ArrayList<>();
                for (Part p : repository.getAllParts()) {
                    if (p.getProductID() == productID) filteredParts.add(p);
                }
                partAdapter.setParts(filteredParts);
                return true;
            case R.id.productsave:
                Product product;
                if (productID == -1) {
                    int newID = repository.getAllProducts().get(repository.getAllProducts().size() - 1).getProductID() + 1;
                    product = new Product(newID, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
                    repository.insert(product);
                } else {
                    product = new Product(productID, editName.getText().toString(), Double.parseDouble(editPrice.getText().toString()));
                    repository.update(product);
                }
                return true;
            case R.id.productdelete:
                for (Product prod : repository.getAllProducts()) {
                    if (prod.getProductID() == productID) currentProduct = prod;
                }

                numParts = 0;
                for (Part part : repository.getAllParts()) {
                    if (part.getProductID() == productID) ++numParts;
                }

                if (numParts == 0) {
                    repository.delete(currentProduct);
                    Toast.makeText(PartList.this, currentProduct.getProductName() + " was deleted", Toast.LENGTH_LONG).show();
                } else {
                    Toast.makeText(PartList.this, "Can't delete a product with parts", Toast.LENGTH_LONG).show();
                }
                return true;
        }
        return true;
    }

    public void enterPartDetail(View view) {
        Intent intent = new Intent(PartList.this, PartDetail.class);
        intent.putExtra("prodID",productID);
        intent.putExtra("id", -1);
        startActivity(intent);
    }
}