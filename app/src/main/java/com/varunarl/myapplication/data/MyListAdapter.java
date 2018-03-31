package com.varunarl.myapplication.data;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.varunarl.myapplication.R;

import java.util.List;

/**
 * Created by sasitha on 3/10/18.
 */

public class MyListAdapter extends ArrayAdapter {


    private @LayoutRes int resourceId;

    public MyListAdapter(@NonNull Context context, @NonNull List<PinDetails> objects) {
        super(context, android.R.layout.simple_list_item_activated_2, objects);
        this.resourceId = android.R.layout.simple_list_item_activated_2;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        PinDetails pinDetails = (PinDetails) getItem(position);
        if (convertView == null){
            convertView = ((LayoutInflater)getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE))
                                .inflate(resourceId,null);
        }
        TextView tv1 = convertView.findViewById(android.R.id.text1);

        tv1.setText(pinDetails.getAccountName());
        convertView.setTag(pinDetails.getId());

        return convertView;
    }
}
