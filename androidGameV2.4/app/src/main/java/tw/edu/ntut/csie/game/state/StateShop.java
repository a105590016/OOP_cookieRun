package tw.edu.ntut.csie.game.state;

import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.extend.ButtonEventHandler;

public class StateShop extends AbstractGameState {
    /**
     * 建構一個<code>AbstractGameState</code>實體。
     *
     * @param engine 執行狀態處理者的引擎
     */

    private MovingBitmap _background;


    private BitmapButton _buyHpButton;
    private BitmapButton _exitButton;

    public StateShop(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        addGameObject(_background = new MovingBitmap(R.drawable.shopbackground));
        initializeBuyHpButton();
        initializeExitButton();
    }

    private void initializeExitButton() {
        addGameObject(_exitButton = new BitmapButton(R.drawable.exit, R.drawable.exit_pressed, 465, 320));
        _exitButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                changeState(Game.INITIAL_STATE);
            }
        });
        addPointerEventHandler(_exitButton);
    }

    private void initializeBuyHpButton() {
        addGameObject(_buyHpButton = new BitmapButton(R.drawable.buyhp, R.drawable.buyhp_pressed, 465, 270));
        _buyHpButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                StateRun.BUY_HP_TIMES ++ ;
            }
        });
        addPointerEventHandler(_buyHpButton);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }
}
