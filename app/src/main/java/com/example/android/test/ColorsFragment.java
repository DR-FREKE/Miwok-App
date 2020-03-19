package com.example.android.test;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class ColorsFragment extends Fragment {

    MediaPlayer mediaPlayer;

    public ColorsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
        final ArrayList<Word> color = new ArrayList<>();
        color.add(new Word("wetetti", "red", R.drawable.color_red, R.raw.color_red));
        color.add(new Word("chokokki", "green", R.drawable.color_green, R.raw.color_green));
        color.add(new Word("takaakki", "brown", R.drawable.color_brown, R.raw.color_brown));
        color.add(new Word("topoppi", "gray", R.drawable.color_gray, R.raw.color_gray));
        color.add(new Word("kululli", "black", R.drawable.color_black, R.raw.color_black));
        color.add(new Word("kelelli", "white", R.drawable.color_white, R.raw.color_white));
        color.add(new Word("topiisa", "dusty yellow", R.drawable.color_dusty_yellow, R.raw.color_dusty_yellow));
        color.add(new Word("chiwiita", "mustard yellow", R.drawable.color_mustard_yellow, R.raw.color_mustard_yellow));

        WordAdapter myAdapter = new WordAdapter(getActivity(), color, R.color.ColorsPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.myList);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long Id) {
                Word mColor = color.get(position);

                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getContext(), mColor.getMiwokSound());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        //Toast.makeText(getApplicationContext(), "I'm done playing", Toast.LENGTH_LONG).show();
                        releaseMediaPlayer();
                    }
                });
            }
        });

        return rootView;
    }
    public void releaseMediaPlayer(){

        if(mediaPlayer != null){
            mediaPlayer.release();

            mediaPlayer = null;
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
