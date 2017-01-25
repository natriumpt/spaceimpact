package org.academiadecodigo.bootcamp.spaceimpact.simplegfx;

import org.academiadecodigo.simplegraphics.pictures.Picture;

public class SimpleGfxField extends SimpleGfxRepresentable {

    private int pictureStateMachine;
    private Picture[] pictureArray;

    public SimpleGfxField(int x, int y) {
        super(new Picture(x,y,"background1.png"));
        this.pictureArray = new Picture[30];
        pictureStateMachine = 1;
        fillPictureArray(x,y);
    }

    public void fillPictureArray(int x, int y){
        for (int i = 1; i < pictureArray.length ; i++){
                pictureArray[i] = new Picture(x,y,"background" + i +".png");
        }
    }

    public void stateMachinePictureChanging() {
        Picture picture;

        if (pictureStateMachine == 30)
            pictureStateMachine = 1;
        picture = pictureArray[pictureStateMachine];
        picture.draw();
        pictureStateMachine++;
    }







}
