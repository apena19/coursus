package com.admin.coursus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class AdaptadorCurso  extends RecyclerView.Adapter<AdaptadorCurso.CursoViewHolder>{

    private ArrayList<Curso> cursos;
    private AdaptadorCurso.OnCursoClickListener clickListener;

    public AdaptadorCurso(ArrayList<Curso> cursos, AdaptadorCurso.OnCursoClickListener clickListener){
        this.cursos = cursos;
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CursoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_curso,parent,false);
        return new AdaptadorCurso.CursoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull CursoViewHolder holder, int position) {
        final Curso c = cursos.get(position);

        holder.featured_photo.setImageResource(c.getFeatured_photo());
        holder.nombre.setText(c.getNombre());
        holder.categoria.setText(c.getCategoria());
        holder.duracion.setText(c.getDuracion());

        holder.v.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clickListener.onCursoClick(c);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cursos.size();
    }

    public static class CursoViewHolder extends RecyclerView.ViewHolder{
        private CircleImageView featured_photo;
        private TextView nombre;
        private TextView categoria;
        private TextView duracion;
        private View v;

        public CursoViewHolder(View itemView){
            super(itemView);
            v = itemView;
            featured_photo = v.findViewById(R.id.imgFotoCurso);
            categoria = v.findViewById(R.id.lblCategoriaCurso);
            nombre = v.findViewById(R.id.lblNombreCurso);
            duracion = v.findViewById(R.id.lblDuracionCurso);
        }

    }
    public interface OnCursoClickListener{
        void onCursoClick(Curso c);
    }

}
