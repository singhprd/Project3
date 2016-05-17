package com.codeclan.petersproject;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.codeclan.petersproject.Enclosure;
import com.codeclan.petersproject.R;

public class EnclosureAdapter extends ArrayAdapter<Enclosure> {

    private Context context;
    private int resource;
    private Enclosure[] objects;

    public EnclosureAdapter(Context context, int resource, Enclosure[] objects) {
        super(context, resource, objects);
        this.context=context;
        this.resource=resource;
        this.objects=objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater= ((Activity) context).getLayoutInflater();

        View row = inflater.inflate(resource,parent,false);

        TextView title= (TextView) row.findViewById(R.id.enclosureListItemText1);
        TextView number=(TextView) row.findViewById(R.id.enclosureListItemText2);
        title.setText( objects[position].getName());
        number.setText(Integer.toString(objects[position].getId()));
        return row;
    }

}