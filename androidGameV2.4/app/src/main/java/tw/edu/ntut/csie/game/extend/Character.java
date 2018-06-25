package tw.edu.ntut.csie.game.extend;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.Log;

import tw.edu.ntut.csie.game.GameObject;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;

/**
 * Created by snow on 2018/4/12.
 */

public class Character implements GameObject {

    protected Animation run ;
    protected Animation slide;
    protected Animation jump;
    protected Animation jumpFall;
    protected Animation doubleJumpReady;
    protected Animation doubleJump;
    protected Animation doubleJumpFall;

    protected Stage stage;

    protected float coordinate_x = 0;
    protected float coordinate_y = 0;

    protected boolean runVisible = false;               //1
    protected boolean slideVisible = false;             //2
    protected boolean jumpVisible = false;              //3
    protected boolean jumpFallVisible = false;          //4
    protected boolean doubleJumpReadyVisible = false;   //5
    protected boolean doubleJumpVisible = false;        //6
    protected boolean doubleJumpFallVisible = false;    //7

    protected boolean jumpFallFinish = false;
    protected boolean crush = false;

    protected float hp = 0;
    protected float totalHp = 0;
    private float percentOfHp;
    protected int state = 0;
    protected int crushtimes = 120;

    protected int jumpTimes = 0;
    protected float jumpSpeed = 12f;
    protected float runSpeed = 5;

    protected Paint paint = new Paint();
    protected RectF rectF_Hp;
    protected Paint paint2 = new Paint();
    protected RectF rectF_Hp_Background;
    private int grade;
    private Audio sound;
    private boolean stageFinish = false;


    public Character(){
        run = new Animation();
        slide = new Animation();
        jump = new Animation();
        jumpFall = new Animation();
        doubleJumpReady = new Animation();
        doubleJump = new Animation();
        doubleJumpFall = new Animation();

        runVisible = true;

        run.setVisible(runVisible);
        slide.setVisible(slideVisible);
        jump.setVisible(jumpVisible);
        jumpFall.setVisible(jumpFallVisible);
        doubleJumpReady.setVisible(doubleJumpReadyVisible);
        doubleJump.setVisible(doubleJumpVisible);
        doubleJumpFall.setVisible(doubleJumpFallVisible);
        coordinate_x = 50;
        coordinate_y = 320;
        sound = new Audio(R.raw.eatcoin);

    }

    public Character(int ResId){

    }

    public Character(String ResId){

    }

    public void setHp(float newHp){
        hp = newHp;
        totalHp = newHp;
    }

    public void setRunVisible(boolean visible){
        runVisible = visible;
    }

    public void setSlideVisible(boolean visible){
        slideVisible = visible;
    }

    public void setJumpVisible(boolean visible){
        jumpVisible = visible;
    }

    public void setJumpFallVisible(boolean visible){
        jumpFallVisible = visible;
    }

    public void setDoubleJumpReadyVisible(boolean visible){
        doubleJumpReadyVisible = visible;
    }

    public void setDoubleJumpVisible(boolean visible){
        doubleJumpVisible = visible;
    }

    public void setDoubleJumpFallVisible(boolean visible){
        doubleJumpFallVisible = visible;
    }

    public void setJumpFallFinish(boolean finish){
        jumpFallFinish = finish;
    }

    public void setJumpTimes(int times){
        jumpTimes = times;
    }

    public void setSpeed(float speed1){
        jumpSpeed = speed1;
    }

    public void setCoordinate_x(float newx){ coordinate_x = newx;}

    public void setCoordinate_y(float newy){ coordinate_y = newy;}

    public void setStage(Stage newStage){ stage = newStage;}

    public boolean getRunVisible(){return runVisible;}

    public boolean getSlideVisible(){return slideVisible;}

    public boolean getJumpVisible(){return jumpVisible;}

    public boolean getJumpFallVisible(){return jumpFallVisible;}

    public boolean getDoubleJumpReadyVisible(){return doubleJumpReadyVisible;}

    public boolean getDoubleJumpVisible(){return doubleJumpVisible;}

    public boolean getDoubleJumpFallVisible(){return doubleJumpFallVisible;}

    public boolean getJumpFallFinish(){return jumpFallFinish;}

    public float getCoordinate_x(){return coordinate_x;}

    public float getCoordinate_y(){return coordinate_y;}

    public float getHeight(){
        if(runVisible)
            return 60;
        else if (slideVisible)
            return 30;
        else if(jumpVisible)
            return 40;
        else if (jumpFallVisible)
            return 40;
        else if(doubleJumpReadyVisible)
            return 60;
        else if(doubleJumpVisible)
            return 45;
        else if(doubleJumpFallVisible)
            return 60;
        return 0;
    }

    public float getWidth(){
        if(runVisible)
            return 50;
        else if (slideVisible)
            return 70;
        else if(jumpVisible)
            return 50;
        else if(jumpFallVisible)
            return 50;
        else if(doubleJumpReadyVisible)
            return 50;
        else if(doubleJumpVisible)
            return 45;
        else if(doubleJumpFallVisible)
            return 30;
        return 0;
    }

    public float getHp(){
        return hp;
    }

    public boolean getStageFinish(){
        return stageFinish;
    }

    public void setStageFinish(boolean newFinish){
        stageFinish = newFinish;
    }


    @Override
    public void move() {
        hp -= 0.1;

        coordinate_x += runSpeed;

        run.setVisible(runVisible);
        slide.setVisible(slideVisible);
        jump.setVisible(jumpVisible);
        jumpFall.setVisible(jumpFallVisible);
        doubleJumpReady.setVisible(doubleJumpReadyVisible);
        doubleJump.setVisible(doubleJumpVisible);
        doubleJumpFall.setVisible(doubleJumpFallVisible);

        if(runVisible)
            runMove();
        else if(slideVisible)
            slideMove();
        else if(jumpVisible)
            jumpMove();
        else if(jumpFallVisible)
            jumpFallMove();
        else if(doubleJumpReadyVisible)
            doubleJumpReadyMove();
        else if(doubleJumpVisible)
            doubleJumpMove();
        else if(doubleJumpFallVisible)
            doubleJumpFallMove();

    }

    @Override
    public void show() {
        if(hp < 0)
            hp = 0;

        percentOfHp = hp / totalHp;
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(3);
        paint.setTextSize(40);

        paint2.setColor(Color.GRAY);
        paint2.setAlpha(64);
        paint2.setStyle(Paint.Style.FILL);
        paint2.setStrokeWidth(3);
        paint2.setTextSize(40);

        Canvas canvas = GameEngine.canvas;
        canvas.drawText("HP",10,40,paint);
        rectF_Hp = new RectF(70,20,400*percentOfHp+70,40);
        rectF_Hp_Background = new RectF(70,20,470,40);
        canvas.drawRoundRect(rectF_Hp_Background,20,20,paint2);
        canvas.drawRoundRect(rectF_Hp,20,20,paint);



        if(crushtimes == 0) {
            state = 0;
            crush = false;
        }

        if(crush) {
            if(crushtimes % 2 == 1){
                run.show();
                slide.show();
                jump.show();
                jumpFall.show();
                doubleJumpReady.show();
                doubleJump.show();
                doubleJumpFall.show();
            }
            crushtimes--;
        }
        else{
            run.show();
            slide.show();
            jump.show();
            jumpFall.show();
            doubleJumpReady.show();
            doubleJump.show();
            doubleJumpFall.show();
        }



    }

    @Override
    public void release() {
        run.release();
        slide.release();
        jump.release();
        jumpFall.release();
        doubleJumpReady.release();
        doubleJump.release();
        doubleJumpFall.release();
    }

    public void runMove(){
        touchFloor(0);
        run.setLocation(50,coordinate_y-run.getHeight());
        run.move();
    }

    public void slideMove(){
        touchFloor(0);
        slide.setLocation(50,coordinate_y - slide.getHeight());
        slide.move();
    }

    public void jumpMove(){
        jumpCollision(jumpSpeed);
        coordinate_y -= jumpSpeed;
        jumpSpeed --;
        jump.setLocation(50,coordinate_y-jump.getHeight());
        jump.move();
        jumpTimes --;
        if(jumpTimes == 0){
            jumpVisible = false;
            jumpFallVisible = true;
            jumpSpeed = 0;
        }
    }

    public void jumpFallMove(){
        if(touchFloor(jumpSpeed)==1){
            jumpFallFinish = true;
            jumpFallVisible = false;
            runVisible = true;
        }
        jumpFall.setLocation(50,coordinate_y - jumpFall.getHeight());
        jumpFall.move();
        jumpSpeed ++;
    }

    public void doubleJumpReadyMove(){
        jumpCollision(jumpSpeed);
        coordinate_y -= jumpSpeed;
        doubleJumpReady.setLocation(50,coordinate_y - doubleJumpReady.getHeight());
        doubleJumpReady.move();
        jumpTimes --;
        jumpSpeed --;
        if(jumpTimes == 0){
            doubleJumpReadyVisible = false;
            doubleJumpVisible = true;
            jumpTimes = 8 ;
        }
    }

    public void doubleJumpMove(){
        jumpCollision(jumpSpeed);
        coordinate_y -= jumpSpeed;
        doubleJump.setLocation(50,coordinate_y - doubleJump.getHeight());
        doubleJump.move();
        jumpSpeed --;
        jumpTimes --;
        if(jumpTimes == 0) {
            doubleJumpVisible = false;
            doubleJumpFallVisible = true;
            jumpSpeed = 0;
        }
//        Log.e("doublejump","doublejump");
    }

    public void doubleJumpFallMove(){
        if(touchFloor(jumpSpeed) == 1){  //撞到地板 掉落完成 恢復跑步狀態
            jumpFallFinish = true;
            doubleJumpFallVisible = false;
            runVisible = true;
        }
        doubleJumpFall.setLocation(50,coordinate_y - doubleJumpFall.getHeight());
        doubleJumpFall.move();
        jumpSpeed ++;
    }


    public int jumpCollision(float speed){
        for(int i = (int)((coordinate_x - runSpeed)/10);i <= (int)((coordinate_x + getWidth())/10);i++){
            int h = (int)(speed+getHeight());
            for(int j = 0;j <= h;j++){
                int mapy = (int)((coordinate_y - j)/10);
                if(mapy < 0)
                    break;
                if(stage.map1[mapy][i] == 2 && !crush){  //判斷碰撞
                    hp -= 10;
                    crush = true;
                    crushtimes = 60;
                    Log.e(String.valueOf(coordinate_x)+","+String.valueOf(coordinate_y),"crush");
                }
                else if(stage.map1[mapy][i] == 4){  //判斷終點
                    stageFinish = true;
                }
                else if(stage.map1[mapy][i] == 5){
                    for(int k=0;k<stage.props.size();k++){
                        if(stage.props.get(k).getCoordinate_x() <= i*10 && stage.props.get(k).getCoordinate_x()+stage.props.get(k).getWidth() > i*10 && stage.props.get(k).getCoordinate_y() <= mapy*10 && stage.props.get(k).getCoordinate_y()+getHeight() >= mapy*10){
                            Log.e("run","getpoint");
                            grade += stage.props.get(k).getGrade();
                            hp += stage.props.get(k).getHp();
                            stage.props.get(k).release();
                            stage.props.remove(k);
                            sound.play();
                            break;
                        }
                    }
                }

            }
        }
        return 0;
    }

    public int touchFloor(float speed){
        for(int i = (int)((coordinate_x - runSpeed)/10);i <= (int)((coordinate_x + getWidth())/10);i++){
            int h = (int)(speed+getHeight());
            for(int j = 0;j <= h;j++){
                int mapy = (int)((coordinate_y-getHeight() + j)/10);
                if(mapy < 0)
                    break;
                if(stage.map1[mapy][i] == 2 && !crush){  //判斷碰撞
                    hp -= 10;
                    crush = true;
                    crushtimes = 60;
                    Log.e(String.valueOf(coordinate_x)+","+String.valueOf(coordinate_y),"crush");
                }
                else if(stage.map1[mapy][i] == 4){  //判斷終點
                    stageFinish = true;
                }
                else if(stage.map1[mapy][i] == 5){
                    for(int k=0;k<stage.props.size();k++){
                        if(stage.props.get(k).getCoordinate_x() <= i*10 && stage.props.get(k).getCoordinate_x()+stage.props.get(k).getWidth() > i*10 && stage.props.get(k).getCoordinate_y() <= mapy*10 && stage.props.get(k).getCoordinate_y()+getHeight() >= mapy*10){
                            Log.e("run","getpoint");
                            grade += stage.props.get(k).getGrade();
                            hp += stage.props.get(k).getHp();
                            stage.props.get(k).release();
                            stage.props.remove(k);
                            sound.play();
                            break;
                        }
                    }
                }
            }
            if(crush)
                break;
        }
        for(int i = (int)((coordinate_x - runSpeed)/10);i <= (int)((coordinate_x + getWidth())/10);i++){
            int h = (int)(speed);
            for(int j = 0;j <= h;j++){
                int mapy = (int)((coordinate_y + j)/10);
                if(mapy < 0)
                    break;
                if(stage.map1[mapy][i] == 1  ) {   //判斷地板
                    coordinate_y += j;
                    return 1;
                }
            }
        }
        if(jumpFallVisible || doubleJumpFallVisible){   //若無碰撞 跳躍後掉落速度增加
            coordinate_y += speed;
        }
        else {                                      //踩空之後設定為二段跳掉落的動畫
            runVisible = false;
            slideVisible = false;
            jumpVisible = false;
            jumpFallVisible = false;
            doubleJumpReadyVisible = false;
            doubleJumpVisible = false;
            doubleJumpFallVisible = true;
            jumpSpeed = 0;
        }
        return 0;
    }

    public int getGrade(){
        return grade;
    }
}
