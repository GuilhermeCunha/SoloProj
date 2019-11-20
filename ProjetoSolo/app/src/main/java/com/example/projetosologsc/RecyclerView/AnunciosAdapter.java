package com.example.projetosologsc.RecyclerView;

import android.app.Person;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.projetosologsc.Model.Anuncio;
import com.example.projetosologsc.R;
import java.util.List;

public class AnunciosAdapter extends RecyclerView.Adapter<AnunciosAdapter.AnuncioViewHolder>{
    List<Anuncio> anuncios;

    public static class AnuncioViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView nomeAnuncio;
        TextView precoAnuncio;

        AnuncioViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardViewAnuncios);
            nomeAnuncio = (TextView) itemView.findViewById(R.id.txtCardViewNomeAnuncio);
            precoAnuncio = (TextView) itemView.findViewById(R.id.txtCardViewPrecoAnuncio);
        }

        @NonNull
        @Override
        public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardviewanuncios, viewGroup, false);
            AnuncioViewHolder avh = new AnuncioViewHolder(view);
            return avh;
        }

        @Override
        public void onBindViewHolder(AnuncioViewHolder anuncioViewHolder, int i) {
            anuncioViewHolder.nomeAnuncio.setText(anuncios.get(i).getNome());
            anuncioViewHolder.nomeAnuncio.setText(anuncios.get(i).getPreco().toString());
        }
        @Override
        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
            super.onAttachedToRecyclerView(recyclerView);
        }
        @Override
        public int getItemCount() {
            return anuncios.size();
        }
        public AnunciosAdapter(List<Anuncio> anuncios){
            this.anuncios = anuncios;
        }
    }


}