package tw.edu.ntut.csie.game.extend;


import java.util.ArrayList;

import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.R;

/**
 * Created by snow on 2018/3/28.
 */

public class Stage {

    protected int coordinate_x = 0;
    protected int coordinate_y = 0;

    protected float background_x = 0;
    protected float background_y = 0;
    protected MovingBitmap background;

    public ArrayList<Props> props = new ArrayList<>();


    protected float[] floor_x;
    protected float[] floor_y;
    protected int index_x = 0;
    protected int pixelOfFloor = 60;
    protected int numberOfFloor;
    protected MovingBitmap[] floor;
    protected float floorSpeed = 5;

    private float floorToBackground = 20;
    private float backgroundSpeed = floorSpeed/floorToBackground;

    protected boolean visible = false;

    protected int[][] map1;

    protected ArrayList<Float> obstacle_x = new ArrayList<>();
    protected ArrayList<Float> obstacle_y = new ArrayList<>();
    protected ArrayList<Float> obstacleScreen_x = new ArrayList<>();
    protected ArrayList<Float> obstacleScreen_y = new ArrayList<>();
    protected ArrayList<MovingBitmap> obstacle = new ArrayList<>();


    public Stage() {
        visible = true;
    }

    public Stage(int bg_resId, int floor_resId) {
    }


    public void setObstacleLocation(MovingBitmap newobs,float x,float y){
        newobs.setLocation(x,y);
        obstacle.add(newobs);
        obstacle_x.add(newobs.getX());
        obstacle_y.add(newobs.getY());
    }
    public Stage(String bg_resId, String floor_resId){

    }

    public void move(){
        for(int i=0;i<numberOfFloor;i++){
            floor_x[i] -= 5;
            if(floor_x[i] < -50)
                floor_x[i] = index_x - 60;
            floor[i].setLocation(floor_x[i],floor_y[i]);
        }

        background_x -= backgroundSpeed;

        if(background_x == -530) {
            setVisible(false);
        }

        background.setLocation(background_x,background_y);

        for(int i=0;i<obstacle.size();i++){
            obstacleScreen_x.set(i,obstacleScreen_x.get(i)-5);
            obstacle.get(i).setLocation(obstacleScreen_x.get(i),obstacleScreen_y.get(i));
        }

        for(int i=0;i<props.size();i++)
            props.get(i).move();
    }

    public void show(){
        background.show();
        for(int i=0;i<numberOfFloor;i++)
            floor[i].show();
        for(int i=0;i<obstacle.size();i++)
            obstacle.get(i).show();
        for(int i=0;i<props.size();i++)
            props.get(i).show();
    }

    public void release(){
        background.release();
        background = null;
        for(int i=0;i<numberOfFloor;i++)
        {
            floor[i].release();
            floor[i] = null;
        }
        for(int i=0;i<obstacle.size();i++){
            obstacle.get(i).release();
            obstacle.set(i,null);
        }
    }

    public void setVisible(boolean newVisible){
        background.setVisible(newVisible);
        for (int i=0;i<numberOfFloor;i++)
            floor[i].setVisible(newVisible);
        for(int i=0;i<obstacle.size();i++)
            obstacle.get(i).setVisible(newVisible);
        visible = newVisible;
    }

    public boolean getVisible(){
        return visible;
    }
}
