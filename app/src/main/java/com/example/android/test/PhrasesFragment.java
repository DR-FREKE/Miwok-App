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
public class PhrasesFragment extends Fragment {

    MediaPlayer mediaPlayer;

    public PhrasesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.activity_numbers, container, false);

        final ArrayList<Word> phrase = new ArrayList<>();
        phrase.add(new Word("minto wuksus", "where are you going?", R.raw.phrase_where_are_you_going));
        phrase.add(new Word("tinnә oyaase'nә", "what is your name?", R.raw.phrase_what_is_your_name));
        phrase.add(new Word("oyaaset...", "my name is...", R.raw.phrase_my_name_is));
        phrase.add(new Word("michәksәs?", "how are you feeling?", R.raw.phrase_how_are_you_feeling));
        phrase.add(new Word("kuchi achit", "i'm feeling good.", R.raw.phrase_im_feeling_good));
        phrase.add(new Word("әәnәs'aa?", "are you coming?", R.raw.phrase_are_you_coming));
        phrase.add(new Word("hәә’ әәnәm", "yes, i'm coming.", R.raw.phrase_yes_im_coming));
        phrase.add(new Word("әәnәm", "i'm coming.", R.raw.phrase_im_coming));
        phrase.add(new Word("yoowutis", "Let's go.", R.raw.phrase_lets_go));
        phrase.add(new Word("әnni'nem", "come here.", R.raw.phrase_come_here));


        WordAdapter myAdapter = new WordAdapter(getActivity(), phrase, R.color.PhrasesPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.myList);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Word phrases = phrase.get(position);

                releaseMediaPlayer();
                mediaPlayer = MediaPlayer.create(getActivity(), phrases.getMiwokSound());

                mediaPlayer.start();

                mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                    @Override
                    public void onCompletion(MediaPlayer mediaPlayer) {
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
