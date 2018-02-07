package com.app.hamang.tektonproject;

/**
 * Created by JKPC on 2018-02-06.
 */


public class DogItem {
    String animalName ;
    int animalImage;
    String animalGender ;
    String dogSpe ;
    String dogSpeNum ;

    public DogItem(String animalName, String animalGender, int animalImage, String dogSpe, String dogSpeNum) {
        this.animalImage = animalImage ;
        this.animalName = animalName ;
        this.animalGender = animalGender ;
        this.dogSpe = dogSpe ;
        this.dogSpeNum = dogSpeNum ;
    }
    public String getAnimalName() {return animalName ;}
    public String getAnimalGender() {return animalGender ; }
    public int getAnimalImage()
    {
        return animalImage ;
    }
    public String getDogSpe() {return dogSpe ; }
    public String getDogSpeNum() { return dogSpeNum ; }
}
