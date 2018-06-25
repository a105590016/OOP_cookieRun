package tw.edu.ntut.csie.game.extend;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

/**
 * Created by snow on 2018/4/19.
 */

public class BraveCookie extends Character {

    public BraveCookie() {
        super();

        run.addFrame(R.drawable.cookie31);
        run.addFrame(R.drawable.cookie32);
        run.addFrame(R.drawable.cookie33);
        run.addFrame(R.drawable.cookie34);
        run.setDelay(2);

        slide.addFrame(R.drawable.cookie8);
        slide.addFrame(R.drawable.cookie9);
        slide.setDelay(2);

        jump.addFrame(R.drawable.cookie6);
        jump.addFrame(R.drawable.cookie7);
        jump.setDelay(2);

        jumpFall.addFrame(R.drawable.cookie6);
        jumpFall.addFrame(R.drawable.cookie7);
        jumpFall.setDelay(2);

        doubleJumpReady.addFrame(R.drawable.cookie0);
        doubleJumpReady.setDelay(1);

        doubleJump.addFrame(R.drawable.cookie1);
        doubleJump.addFrame(R.drawable.cookie2);
        doubleJump.addFrame(R.drawable.cookie3);
        doubleJump.addFrame(R.drawable.cookie4);
        doubleJump.setDelay(3);

        doubleJumpFall.addFrame(R.drawable.cookie5);
        doubleJumpFall.setDelay(1);

        hp = 150;
        totalHp = hp;
    }
}
