package tw.edu.ntut.csie.game.extend;

import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.core.MovingBitmap;

public class Props implements GameObject {

    private MovingBitmap props;
    private float x;
    private float y;
    private int coordinate_x;
    private int coordinate_y;
    private boolean visible;
    private float speed;
    private int grade;
    private boolean mark = false;
    private float hp;

    public Props(int ResId,int new_x,int new_y,int newGrade,float newSpeed){

        props = new MovingBitmap(ResId);
        visible = true;
        coordinate_x = new_x;
        coordinate_y = new_y;
        grade = newGrade;
        speed = newSpeed;
        x = coordinate_x;
        y = coordinate_y;
    }

    public Props(int ResId,int new_x,int new_y,int newGrade,float newhp,float newSpeed){

        props = new MovingBitmap(ResId);
        visible = true;
        coordinate_x = new_x;
        coordinate_y = new_y;
        grade = newGrade;
        speed = newSpeed;
        x = coordinate_x;
        y = coordinate_y;
        hp = newhp;
    }

    public void setVisible(boolean newVisible){
        visible = newVisible;
    }

    public void setSpeed(float newSpeed){
        speed = newSpeed;
    }

    @Override
    public void move() {
        x -= speed;
        props.setLocation(x,y);
    }

    @Override
    public void show() {
        props.setVisible(visible);
        props.show();
    }

    @Override
    public void release() {
        props.release();
        props = null;
    }

    public int getGrade(){
        return grade;
    }

    public int getCoordinate_x(){
        return coordinate_x;
    }

    public int getCoordinate_y(){
        return coordinate_y;
    }

    public void setMark(){
        mark = true;
    }

    public boolean getMark(){
        return mark;
    }

    public float getHp() {
        return hp;
    }

    public float getHeight(){
        return props.getHeight();
    }
    public float getWidth(){
        return props.getWidth();
    }
}
