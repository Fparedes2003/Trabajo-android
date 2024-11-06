package fabian.stomas.aplicacion2;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Canal> items;
    private View.OnClickListener onClickListener;
    public MyAdapter(ArrayList<Canal> items) {
        this.items = items;
    }
    public void setOnClickListener(View.OnClickListener onClickListener){
        this.onClickListener = onClickListener;
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card, parent, false);
        view.setOnClickListener(onClickListener);
        return new MyViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        Canal canal = items.get(position);
        holder.titleTextView.setText(canal.getNombre());
        holder.descriptionTextView.setText(canal.getDescripcion());
        holder.tipoTextView.setText(canal.getTipo_canaldb());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView titleTextView;
        TextView descriptionTextView;
        TextView tipoTextView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titulo);
            descriptionTextView = itemView.findViewById(R.id.descripcion);
            tipoTextView = itemView.findViewById(R.id.tipo);
        }

    }
}
