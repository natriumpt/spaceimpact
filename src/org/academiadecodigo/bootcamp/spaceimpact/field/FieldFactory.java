package org.academiadecodigo.bootcamp.spaceimpact.field;

import org.academiadecodigo.bootcamp.spaceimpact.graphics.GFXField;

/**
 * Created by betacodecadet on 20/01/17.
 */
public class FieldFactory {

    public static Field makeField(FieldType fieldType, int posX, int posY, int width, int height){
        switch (fieldType) {
            case SIMPLE_GFX:
                return new GFXField(posX,posY,width,height);
            default:
                System.out.println("¯\\_(ツ)_/¯ Could not create field");
                return new GFXField(posX,posY,width,height);
        }
    }

}
