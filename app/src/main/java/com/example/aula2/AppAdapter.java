package com.example.aula2;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class AppAdapter extends ArrayAdapter<ApplicationInfo> {

    private final Context mContext;
    private final int mResource;

    public AppAdapter(@NonNull Context context, int resource, @NonNull List<ApplicationInfo> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder = new ViewHolder();
            holder.appName = convertView.findViewById(R.id.app_name);
            holder.appIcon = convertView.findViewById(R.id.app_icon);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        ApplicationInfo applicationInfo = getItem(position);

        if (applicationInfo != null) {
            PackageManager packageManager = mContext.getPackageManager();
            holder.appName.setText(applicationInfo.loadLabel(packageManager));
            holder.appIcon.setImageDrawable(applicationInfo.loadIcon(packageManager));
        }

        return convertView;
    }

    private static class ViewHolder {
        TextView appName;
        ImageView appIcon;
    }
}
