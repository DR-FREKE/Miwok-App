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
public class FamilyFragment extends Fragment {

    MediaPlayer mediaPlayer;

    public FamilyFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);

        final ArrayList<Word> family = new ArrayList<>();
        family.add(new Word("apa", "father", R.drawable.family_father, R.raw.family_father));
        family.add(new Word("ata", "mother", R.drawable.family_mother, R.raw.family_mother));
        family.add(new Word("angsi", "son", R.drawable.family_son, R.raw.family_son));
        family.add(new Word("tune", "daughter", R.drawable.family_daughter, R.raw.family_daughter));
        family.add(new Word("taachi", "older brother", R.drawable.family_older_brother, R.raw.family_older_brother));
        family.add(new Word("chalitti", "younger brother", R.drawable.family_younger_brother, R.raw.family_younger_brother));
        family.add(new Word("tete", "older sister", R.drawable.family_older_sister, R.raw.family_older_sister));
        family.add(new Word("kolliti", "younger sister", R.drawable.family_younger_sister, R.raw.family_younger_sister));
        family.add(new Word("ama", "grandmother", R.drawable.family_grandmother, R.raw.family_grandmother));
        family.add(new Word("paapa", "grandfather", R.drawable.family_grandfather, R.raw.family_grandfather));


        WordAdapter myAdapter = new WordAdapter(getActivity(), family, R.color.FamilyPrimary);

        final ListView listView = (ListView) rootView.findViewById(R.id.myList);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long Id) {
                Word mFamily = family.get(position);

                releaseMediaPlayer();

                mediaPlayer = MediaPlayer.create(getActivity(), mFamily.getMiwokSound());
                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
                        releaseMediaPlayer();
                    }
                });
            }
        });

/**
 Bundle extraData = getIntent().getExtras();

 if(extraData == null){
 return;
 }else {
 String fromNumber = extraData.getString("myText").toString();
 textView = (TextView) findViewById(R.id.myText);
 textView.setText(fromNumber);
 }*/

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
