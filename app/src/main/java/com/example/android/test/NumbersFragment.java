package com.example.android.test;


import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
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
public class NumbersFragment extends Fragment {

    MediaPlayer mediaPlayer;
    AudioManager audioManager;

    public NumbersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       View rootView = inflater.inflate(R.layout.activity_numbers, container, false);
       audioManager = (AudioManager) getActivity().getSystemService(Context.AUDIO_SERVICE);

        final ArrayList<Word> words = new ArrayList<>();
        words.add(new Word("Two", "Otiiko", R.drawable.number_two, R.raw.number_two));
        words.add(new Word("Three", "Tolookosu", R.drawable.number_three, R.raw.number_three));
        words.add(new Word("Four", "Oyyisa", R.drawable.number_four, R.raw.number_four));
        words.add(new Word("Five", "Massokka", R.drawable.number_five, R.raw.number_five));
        words.add(new Word("Six", "Temmokka", R.drawable.number_six, R.raw.number_six));
        words.add(new Word("Seven", "Kenekaku", R.drawable.number_seven, R.raw.number_seven));
        words.add(new Word("Eight", "Kawinta", R.drawable.number_eight, R.raw.number_eight));
        words.add(new Word("Nine", "Wo'e", R.drawable.number_nine, R.raw.number_nine));
        words.add(new Word("Ten", "Na'aacha", R.drawable.number_ten, R.raw.number_ten));

        WordAdapter myAdapter = new WordAdapter(getActivity(), words, R.color.NumbersPrimary);

        ListView listView = (ListView) rootView.findViewById(R.id.myList);
        listView.setAdapter(myAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String num = String.valueOf(adapterView.getItemAtPosition(position));
                String num2 = "hello world";
                //Toast.makeText()
//                Word word = words.get(position);
//                mediaPlayer = MediaPlayer.create(NumbersActivity.this, word.getMiwokSound());
//                mediaPlayer.start();
                int i = 0;
                for(Word worder : words){

                    if(position == i){
                        //release every possible available sounds
                        releaseMediaPlayer();

                        //before a sound can be played, we must check if we have audio focus
                        int result = audioManager.requestAudioFocus(new AudioManager.OnAudioFocusChangeListener() {
                            @Override
                            public void onAudioFocusChange(int focusChange) {
                                if(focusChange == AudioManager.AUDIOFOCUS_GAIN_TRANSIENT){

                                }
                            }
                        }, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);

                        if(result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED){
                            //if audio focus is granted, play a sound
                            mediaPlayer = MediaPlayer.create(getActivity(), worder.getMiwokSound());
                            mediaPlayer.start();
                            mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                                @Override
                                public void onCompletion(MediaPlayer mediaPlayer) {
                                    releaseMediaPlayer();
                                }
                            });
                        }
                    }
                    i++;
                }

            }
        });


        Log.v("NumbersActivity", "words in index 0: " +words.get(0));
        Log.v("NumbersActivity", "words in index 1: " +words.get(1));
        Log.v("NumbersActivity", "words in index 2: " +words.get(2));

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
