package edu.hcmus.hw4;

import android.app.Activity;
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

public class CustomAdapter extends ArrayAdapter {
    private Context context;
    private List<PhoneInfo> phoneInfos;

    public CustomAdapter(@NonNull Context context, int resource, int name, @NonNull List phoneInfos) {
        super(context, resource, phoneInfos);
        this.context = context;
        this.phoneInfos = phoneInfos;
    }


    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.custom_row_layout, null);
        }
        ImageView avatar = (ImageView) convertView.findViewById(R.id.avatar);
        TextView name = (TextView) convertView.findViewById(R.id.name);
        TextView phone = (TextView) convertView.findViewById(R.id.phone);
        avatar.setImageResource(phoneInfos.get(position).getAvatar());
        name.setText(phoneInfos.get(position).getName());
        phone.setText(phoneInfos.get(position).getPhone());
        return convertView;
    }
}
