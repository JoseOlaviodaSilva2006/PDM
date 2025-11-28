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
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;
        Planeta planeta = getItem(position);

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.nomePlaneta = convertView.findViewById(R.id.textView);
            holder.imgPlaneta = convertView.findViewById(R.id.imageView);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        if (planeta != null) {
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
