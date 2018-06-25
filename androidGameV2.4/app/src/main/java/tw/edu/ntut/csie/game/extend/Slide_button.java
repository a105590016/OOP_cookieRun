package tw.edu.ntut.csie.game.extend;

import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;

public class Slide_button extends motion_button {

    public Slide_button(){
        super();
        ordinary = new MovingBitmap(R.drawable.slide);
        click = new MovingBitmap(R.drawable.slide_click);
        ordinary.setLocation(530,300);
        click.setLocation(530,300);
    }
}
