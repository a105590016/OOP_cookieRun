package tw.edu.ntut.csie.game.extend;

import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by snow on 2018/4/12.
 */

public class Floor {
    private float coordinate_x;
    private float coordinate_y;
    private MovingBitmap floor;
    boolean visible;

    public Floor(){
        setVisible(true);
    }

    public Floor(int ResId){
        setLocation(0,0);
        floor = new MovingBitmap(ResId);
        setVisible(true);
    }

    public Floor(String ResId){
        setLocation(0,0);
        floor = new MovingBitmap(ResId);
        setVisible(true);
    }

    public void setLocation(float x,float y){
        coordinate_x = x;
        coordinate_y = y;
    }

    public void move(float movement){

    }

    public float getCoordinate_x(){
        return coordinate_x;
    }

    public float getCoordinate_y(){
        return coordinate_y;
    }

    public void setVisible(boolean newVisible){
        visible = newVisible;
    }

    public boolean getVisible(){
        return visible;
    }
}

