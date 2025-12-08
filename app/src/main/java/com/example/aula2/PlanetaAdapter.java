//aqui o app vai cirar e gerenciar a view de cada item da lista, dizendo quando criar ou reutilizar uma linha nova

package com.example.aula2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class PlanetaAdapter extends ArrayAdapter<Planeta> {
    private int mResource;

    public PlanetaAdapter(@NonNull Context context, int resource, @NonNull List<Planeta> objects) {
        super(context, resource, objects);
        this.mResource = resource;
    }

    @NonNull
    @Override
    //o position fala o item da lista que estamos usando, tipo: sol 0, mercurio 1...
    //parent é o listview
    //convertview reutiliza a lista
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        Planeta planeta = getItem(position);

        //aqui, o adapter vai perguntar se o convertview é null e se for é a primeira vez da lista
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(mResource, parent, false);
            //o holder cria um objeto auxiliar que salva um padrão das coisas visuais, tipo uma forma de bolo que diz: aqui tu coloca a farinha, aqui o ovo e aqui o leite
            holder = new ViewHolder();
            holder.nomePlaneta = convertView.findViewById(R.id.textView);
            holder.imgPlaneta = convertView.findViewById(R.id.imageView);
            //coloca o holder na viwe pra poder usar depois
            convertView.setTag(holder);

            //se não for nulo, então vai reusar uma linha já criada que saiu da tela, isso só é util pra sistemas com listas grandes, tipo o whatsapp
        } else {
            //aqui por exemplo, ao invés dew buscar os componentes de novo, ele só cola dentro da lista criada
            holder = (ViewHolder) convertView.getTag();
        }

        if (planeta != null) {

            //aqui ele diz pro visual quais são os dados do planeta
            holder.nomePlaneta.setText(planeta.getNome());
            holder.imgPlaneta.setImageResource(planeta.getImg());
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView nomePlaneta;
        ImageView imgPlaneta;
    }
}
//o holder é tipo a carteira, se tu deixa os documentos espalhados pela casa, quando precisar deles, vai ter que procurar
//na casa toda, com o holder não, ali vai ta sempre no bolso, foi parado na blitz? Só pegar a CNH e doc do carro, ao invés de procurar tudo dentro do carro ou casa.
//ou tipo, tu ta desmontando um ventilador, ai tu precisa de uma chave philips, vai la onde ela ta guardada, pega ela, vai até o ventilador, tira o parafuso, volta pra onde ela tava, guarda ela. Ai tu vai até o ventilador, ve que tem outro parafuso, mas agora é de fenda pra tirar e repete todo o processo de buscar e guardar de novo
//o holder é uma caixa de ferramentas, ao invés de ficar indo buscar e guardar a chave phillips, tu pega a caixa que tem a chave phillips e de fenda e sempre que precisar usar, só abrir a caixa que já ta contigo, pegar e usar a que precisar.
//fica muito mais rapido que ter que ficar buscando as coisas dentro de casa sempre que precisa.
