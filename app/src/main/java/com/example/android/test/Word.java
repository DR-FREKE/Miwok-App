package com.example.android.test;

/**
 * Created by KingSolo on 7/2/2017.
 */

public class Word {

    //default translation for the word...example English
    private String DefaultTranslation;

    //miwok translation for the word...
    private String MiwokTranslation;

    //images for the number activity...
    private int MiwokImages;

    //sounds to play for each view...
    private int MiwokSound;

    private boolean hasImage = false;

    //creating multiple constructors

    /** First constructor that holds just the english and miwok translation*/
    public Word(String defaultTranslation, String miwokTranslation, int miwokSound){
        this(defaultTranslation, miwokTranslation, 0, miwokSound);
        hasImage = false;
    }

    /** second constructor that holds the english and miwok translation and images...taking three param*/
    public Word(String defaultTranslation, String miwokTranslation, int miwokImages, int miwokSound){
        this.DefaultTranslation = defaultTranslation;
        this.MiwokTranslation = miwokTranslation;
        this.MiwokImages = miwokImages;
        this.MiwokSound = miwokSound;
        hasImage = true;
    }

    private void setDefaultTranslation(String defaultTrans){
        this.DefaultTranslation = defaultTrans;
    }
    private void setMiwokTranslation(String miwokTrans){
        this.MiwokTranslation = miwokTrans;
    }

    /**getter method to get the default translation of the word*/
    public String getDefaultTranslation(){
        return DefaultTranslation;
    }
    /** getter method to get the miwok translation of the word*/
    public String getMiwokTranslation(){
        return MiwokTranslation;
    }

    /** getter method to get the image*/
    public int getMiwokImages(){
        return MiwokImages;
    }
    public int getMiwokSound(){ return MiwokSound; }

    public boolean isHasImage(){
        return hasImage;
    }

    public String toString(){
        return DefaultTranslation + "\n" + MiwokTranslation;
    }
}
