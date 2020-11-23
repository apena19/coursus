package com.admin.coursus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdaptadorUsuario extends RecyclerView.Adapter<AdaptadorUsuario.UsuarioViewHolder> {

    private ArrayList<Usuario> usuarios;
    private OnUsuariolickListener clickListener;

    public AdaptadorUsuario(ArrayList<Usuario> usuarios, OnUsuariolickListener clickListener){
        this.usuarios = usuarios;
        this.clickListener = clickListener;
    }

    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user,parent,false);
        return new UsuarioViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        final Usuario u = usuarios.get(position);

        holder.foto.setImageResource(u.getFoto());
        holder.cedula.setText(u.getCedula());
        holder.nombre.setText(u.getNombre());
        holder.apellido.setText(u.getApellido());
        holder.celular.setText(u.getCelular());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onUsuarioClick(u);
            }
        });


    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    public static class UsuarioViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView foto;
        private TextView cedula;
        private TextView nombre;
        private TextView apellido;
        private TextView celular;
        private View v;

        public UsuarioViewHolder(View itemView){
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.imgFotoUser);
            cedula = v.findViewById(R.id.lblCedulaUser);
            nombre = v.findViewById(R.id.lblNombreUser);
            apellido = v.findViewById(R.id.lblApellidouser);
            celular = v.findViewById(R.id.lblCelularuser);
        }

    }

    public interface OnUsuariolickListener{
        void onUsuarioClick(Usuario u);
    }
}
