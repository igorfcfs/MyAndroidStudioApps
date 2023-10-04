package com.example.rotine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RotinasNoturnasRecViewAdapter extends RecyclerView.Adapter<RotinasNoturnasRecViewAdapter.ViewHolder> {

    private ArrayList<Rotina> contacts = new ArrayList<>();
    private Context context;

    public RotinasNoturnasRecViewAdapter(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup/*parent of all layout types*/ parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rotina_noturna_list_item, parent, false);
//        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contacts_list_item, null);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        holder.txtNome.setText(contacts.get(position).getNome());
        holder.txtHorario.setText(contacts.get(position).getHorario());
        holder.parent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                holder.checkBoxRotinaMatinal.setChecked(true);
                Toast.makeText(context, contacts.get(position).getNome() + " Selected", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return contacts.size();
    }

    public void setContacts(ArrayList<Rotina> contacts) {
        this.contacts = contacts;
        notifyDataSetChanged();
    }

    //Inner Class
    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtNome, txtHorario;
        private /*RelativeLayout*/ CardView parent;
        private ImageView image;
//        private CheckBox checkBoxRotinaMatinal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtNome = itemView.findViewById(R.id.txtNome);
            txtHorario = itemView.findViewById(R.id.txtHorario);
            parent = itemView.findViewById(R.id.parent);
//            checkBoxRotinaMatinal = itemView.findViewById(R.id.checkBoxRotinaMatinal);
        }
    }
}
