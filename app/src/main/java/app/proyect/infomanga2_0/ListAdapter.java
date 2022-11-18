package app.proyect.infomanga2_0;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.infomanga2_0.R;

import java.util.List;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder>{
    private List<ListElement> mData;
    private LayoutInflater mInflater;
    private Context context;

    public ListAdapter(List<ListElement> itemList, Context context){
        this.mInflater = LayoutInflater.from(context);
        this.context = context;
        this.mData = itemList;
    }

    @Override
    public int getItemCount() {return mData.size(); }

    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType){
        View view = mInflater.inflate(R.layout.list_element,null);
        return new ListAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ListAdapter.ViewHolder holder, final int position){
        holder.bindData(mData.get(position));
    }

    public void setItems(List<ListElement> items) {mData = items; }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView ic_bookicon;
        TextView name, autor;
        ViewHolder(View itemView) {
            super(itemView);
            ic_bookicon=itemView.findViewById(R.id.iconImageView);
            name = itemView.findViewById(R.id.nameTextView);
            autor = itemView.findViewById(R.id.autorTextView);
        }
        void bindData(final ListElement item) {
            ic_bookicon.setColorFilter(Color.parseColor(item.getColor()), PorterDuff.Mode.SRC_IN);
            name.setText(item.getName());
            autor.setText(item.getAutor());
        }
    }
}
