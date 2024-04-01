package android.carolynbicycleshop.arcticfox.UI;

import android.carolynbicycleshop.arcticfox.Entities.Part;
import android.carolynbicycleshop.arcticfox.Entities.Product;
import android.carolynbicycleshop.arcticfox.R;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

/**
 * Project: Bike Arctic Fox
 * Package: android.carolynbicycleshop.arcticfox.UI
 * <p>
 * User: carolyn.sher
 * Date: 12/18/2021
 * Time: 9:15 AM
 * <p>
 * Created with Android Studio
 * To change this template use File | Settings | File Templates.
 */

public class PartAdapter extends RecyclerView.Adapter<PartAdapter.PartViewHolder> {


    class PartViewHolder extends RecyclerView.ViewHolder{
        private final TextView partItemView;
        private final TextView partItemView2;
        private PartViewHolder(View itemView){
            super(itemView);
            partItemView=itemView.findViewById(R.id.textView2);
            partItemView2=itemView.findViewById(R.id.textView3);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position=getAdapterPosition();
                    final Part current=mParts.get(position);
                    Intent intent=new Intent(context,PartDetail.class);
                    intent.putExtra("id", current.getPartID());
                    intent.putExtra("name", current.getPartName());
                    intent.putExtra("price", current.getPrice());
                    intent.putExtra("prodID",current.getProductID());
                    context.startActivity(intent);
                }
            });
        }
    }
    private List<Part> mParts;
    private final Context context;
    private final LayoutInflater mInflater;

    public PartAdapter(Context context){
        mInflater=LayoutInflater.from(context);
        this.context=context;
    }
    @NonNull
    @Override
    public PartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView=mInflater.inflate(R.layout.part_list_item,parent,false);
        return new PartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull PartViewHolder holder, int position) {
        if(mParts!=null){
            Part current=mParts.get(position);
            String name=current.getPartName();
            int prodID= current.getProductID();
            holder.partItemView.setText(name);
            holder.partItemView2.setText(Integer.toString(prodID));
        }
        else{
            holder.partItemView.setText("No part name");
            holder.partItemView.setText("No product id");
        }
    }

    public void setParts(List<Part> parts){
        mParts=parts;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mParts.size();
    }
}
