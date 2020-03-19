package com.example.android.test;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import static android.R.attr.resource;
import static android.R.attr.theme;
import static com.example.android.test.R.id.imgrep;

/**
 * Created by KingSolo on 7/2/2017.
 */

public class WordAdapter extends ArrayAdapter<Word> {

    int mLayoutColor;

    public WordAdapter(Activity context, ArrayList<Word> wordArrayAdapterord, int layoutColor) {
        super(context, 0, wordArrayAdapterord);

        this.mLayoutColor = layoutColor;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView == null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item, parent, false);
        }

        Word currentWord = getItem(position);

        TextView miwoktextView = (TextView) listItemView.findViewById(R.id.miwokeLang);
        miwoktextView.setText(currentWord.getMiwokTranslation());

        TextView engtextView = (TextView) listItemView.findViewById(R.id.english);
        engtextView.setText(currentWord.getDefaultTranslation());

        ImageView imgrep = (ImageView) listItemView.findViewById(R.id.imgrep);
        imgrep.setImageResource(currentWord.getMiwokImages());
        if(currentWord.isHasImage() == true){
            imgrep.setVisibility(View.VISIBLE);
        }else{
            imgrep.setVisibility(View.GONE);
        }

        View container = listItemView.findViewById(R.id.itemView);
        int linearBackground = ContextCompat.getColor(getContext(), mLayoutColor);

        container.setBackgroundColor(linearBackground);

        return listItemView;
    }
}
