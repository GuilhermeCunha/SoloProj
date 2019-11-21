package com.example.projetosologsc.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

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
        LinearLayout item_listLayout;

        AnuncioViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cvAnuncios);
            nomeAnuncio = (TextView) itemView.findViewById(R.id.txtCardViewNomeAnuncio);
            precoAnuncio = (TextView) itemView.findViewById(R.id.txtCardViewPrecoAnuncio);
            item_listLayout = (LinearLayout) itemView.findViewById(R.id.item_listLayout);
        }
    }
    @NonNull
    @Override
    public AnuncioViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_list, viewGroup, false);
        AnuncioViewHolder avh = new AnuncioViewHolder(view);
        return avh;
    }

    @Override
    public void onBindViewHolder(AnuncioViewHolder anuncioViewHolder, int i) {
        final Anuncio itemAtual = anuncios.get(i);
        anuncioViewHolder.nomeAnuncio.setText(anuncios.get(i).getNome());
        anuncioViewHolder.precoAnuncio.setText(String.format("R$%.2f", anuncios.get(i).getPreco()));
        anuncioViewHolder.item_listLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(),"Mensagem: " + itemAtual.getMensagem() ,Toast.LENGTH_LONG).show();
            }
        });
        anuncioViewHolder.item_listLayout.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(v.getContext(),"Atualize para versão premium para habilitar esta função" ,Toast.LENGTH_LONG).show();
                return true;
            }
        });
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