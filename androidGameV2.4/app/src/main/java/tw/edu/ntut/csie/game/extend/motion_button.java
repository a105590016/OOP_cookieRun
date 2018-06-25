package tw.edu.ntut.csie.game.extend;

import tw.edu.ntut.csie.game.core.MovingBitmap;

public class motion_button {
    protected MovingBitmap ordinary;
    protected MovingBitmap click;
    private boolean visible;

    public motion_button(){
        visible = true;
    }

    public void show(){
        if(visible)
            ordinary.show();
        else
            click.show();
    }

    public void setVisible(boolean newVisible){
        visible = newVisible;
    }
}
