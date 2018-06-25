package tw.edu.ntut.csie.game.extend;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

public class Jump_button extends motion_button {


    public Jump_button(){
        super();
        ordinary = new MovingBitmap(R.drawable.jump);
        click = new MovingBitmap(R.drawable.jump_click);
        ordinary.setLocation(10,300);
        click.setLocation(10,300);
    }

}
