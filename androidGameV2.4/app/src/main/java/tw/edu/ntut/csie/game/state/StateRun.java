package tw.edu.ntut.csie.game.state;

import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.Pointer;
import tw.edu.ntut.csie.game.PointerEventHandler;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.Audio;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.core.SoundEffects;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.extend.BraveCookie;
import tw.edu.ntut.csie.game.extend.ButtonEventHandler;
import tw.edu.ntut.csie.game.extend.Character;
import tw.edu.ntut.csie.game.extend.Integer;
import tw.edu.ntut.csie.game.extend.Jump_button;
import tw.edu.ntut.csie.game.extend.Slide_button;
import tw.edu.ntut.csie.game.extend.Stage;
import tw.edu.ntut.csie.game.extend.Stage1;
import tw.edu.ntut.csie.game.extend.Stage2;

public class StateRun extends GameState {
    public static final int DEFAULT_SCORE_DIGITS = 1;
    public static int BUY_HP_TIMES = 0;
    private Stage1 stage1;
    private Stage2 stage2;

    private Integer _scores;

    private BraveCookie braveCookie;

    private boolean _grab;
    private int _cx, _cy;

    private Audio _music;
    private Audio jumpAudio;
    private boolean jump;
    private boolean down;
    private int times;
    private int jumptimes;

    private  Pointer pointer1;
    private  Pointer pointer2;

    private Jump_button jump_button;
    private Slide_button slide_button;


    public StateRun(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        stage1 = new Stage1();
        stage2 = new Stage2();
        _scores = new Integer(DEFAULT_SCORE_DIGITS, 0, 480, 10);
//        initializePauseButton();
        pointer1 = null;
        pointer2 = null;

        braveCookie = new BraveCookie();
        braveCookie.setStage(stage1);
        stage2.setVisible(false);
        braveCookie.setHp(150+30*BUY_HP_TIMES);

        jump_button = new Jump_button();
        slide_button = new Slide_button();



        _music = new Audio(R.raw.bgm);
        _music.setRepeating(true);
        _music.play();

        jumpAudio = new Audio(R.raw.jump);

        _grab = false;
        jump = false;
        down = false;
        jumptimes = 0;

    }

    @Override
    public void move() {
//        Log.e(String.valueOf(braveCookie.getHp()),"run");
        if(braveCookie.getHp() <= 0 || (braveCookie.getStageFinish() && stage2.getVisible())){
            changeState(Game.OVER_STATE);
            Log.e(String.valueOf(braveCookie.getHp()),"run");
        }

        if(braveCookie.getStageFinish() && stage1.getVisible()){
            braveCookie.setCoordinate_x(50f);
            stage2.setVisible(true);
            stage1.setVisible(false);
            braveCookie.setStageFinish(false);
            braveCookie.setStage(stage2);
        }

        if(stage1.getVisible())
            stage1.move();

        if(stage2.getVisible())
            stage2.move();

        if(braveCookie.getJumpFallFinish()){
            jumptimes = 0;
            braveCookie.setJumpFallFinish(false);
        }

        braveCookie.move();
        _scores.setValue(braveCookie.getGrade());
        _scores.setDigits(String.valueOf(braveCookie.getGrade()).length());
    }

    @Override
    public void show() {
//        Log.e("test", "show");
        stage1.show();
        stage2.show();
        _scores.show();
        braveCookie.show();
        jump_button.show();
        slide_button.show();
//        pause_button.show();
    }

    @Override
    public void release() {
        stage1.release();
        _scores.release();
        braveCookie.release();
        _music.release();
        stage1 = null;
        _scores = null;
        braveCookie = null;
        _music = null;

    }

    @Override
    public void keyPressed(int keyCode) {
        // TODO Auto-generated method stub
    }

    @Override
    public void keyReleased(int keyCode) {
        // TODO Auto-generated method stub
    }

    @Override
    public void orientationChanged(float pitch, float azimuth, float roll) {

    }

    @Override
    public void accelerationChanged(float dX, float dY, float dZ) {
        // TODO Auto-generated method stub
    }

    @Override
    public boolean pointerPressed(Pointer actionPointer, List<Pointer> pointers) {
        if (actionPointer.getX() <= 320 && jumptimes < 2) {  //用互鎖的方式，解決部分BUG
            pointer2 = null;
            slide_button.setVisible(true);
            jumpAudio.play();
            if(jumptimes == 0){
                jumptimes++;
                braveCookie.setJumpTimes(10);
                braveCookie.setSpeed(13);
                braveCookie.setRunVisible(false);
                braveCookie.setSlideVisible(false);
                braveCookie.setJumpVisible(true);
                braveCookie.setJumpFallVisible(false);
                braveCookie.setDoubleJumpReadyVisible(false);
                braveCookie.setDoubleJumpVisible(false);
                braveCookie.setDoubleJumpFallVisible(false);
            }
            else if((braveCookie.getJumpVisible() || braveCookie.getJumpFallVisible()) && !braveCookie.getJumpFallFinish()){
                Log.e("2","touch");
                jumptimes++;
                braveCookie.setSpeed(13);
                braveCookie.setJumpTimes(2);
                braveCookie.setJumpVisible(false);
                braveCookie.setJumpFallVisible(false);
                braveCookie.setDoubleJumpReadyVisible(true);
//                Log.e(String .valueOf(braveCookie.getJumpVisible())+" "+String.valueOf(braveCookie.getJumpFallVisible())+" "+String.valueOf(braveCookie.getDoubleJumpReadyVisible()),"touch");
            }
            jump_button.setVisible(false);
            pointer1 = actionPointer;
        }
//        else if(actionPointer.getX() >= 600 && actionPointer.getX() <= 632 && actionPointer.getY() >= 10 && actionPointer.getY() <= 42)
//            pause();
        else if(pointer1 == null && actionPointer.getX() > 320 && !braveCookie.getJumpVisible() && !braveCookie.getDoubleJumpVisible() && !braveCookie.getDoubleJumpFallVisible() && !braveCookie.getJumpFallVisible()){
            braveCookie.setRunVisible(false);
            braveCookie.setSlideVisible(true);
            braveCookie.setJumpVisible(false);
            braveCookie.setDoubleJumpVisible(false);
            braveCookie.setDoubleJumpFallVisible(false);
            slide_button.setVisible(false);
            pointer2 = actionPointer;
        }

        return true;
    }

    @Override
    public boolean pointerMoved(Pointer actionPointer, List<Pointer> pointers) {
        return false;
    }

    public void resizeAndroidIcon() {

    }

    @Override
    public boolean pointerReleased(Pointer actionPointer, List<Pointer> pointers) {
        _grab = false;

        if(pointer1 != null && pointer1.getID() == actionPointer.getID()){
            pointer1 = null;
            jump_button.setVisible(true);
        }

        if(pointer2 != null && pointer2.getID() == actionPointer.getID()){
            pointer2 = null;
            braveCookie.setSlideVisible(false);
            braveCookie.setRunVisible(true);
            slide_button.setVisible(true);
        }

        return false;
    }

    @Override
    public void pause() {
        _music.pause();
    }

    @Override
    public void resume() {
        _music.resume();
    }


}
