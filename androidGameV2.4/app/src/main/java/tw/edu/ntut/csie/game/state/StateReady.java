package tw.edu.ntut.csie.game.state;

import java.util.Map;

import tw.edu.ntut.csie.game.Game;
import tw.edu.ntut.csie.game.R;
import tw.edu.ntut.csie.game.core.MovingBitmap;
import tw.edu.ntut.csie.game.engine.GameEngine;
import tw.edu.ntut.csie.game.extend.BitmapButton;
import tw.edu.ntut.csie.game.extend.ButtonEventHandler;

public class StateReady extends AbstractGameState {

    private MovingBitmap _helpInfo;
    private MovingBitmap _aboutInfo;
    private MovingBitmap _background;
    private MovingBitmap _shop;

    private BitmapButton _exitButton;
    private BitmapButton _helpButton;
    private BitmapButton _menuButton;
    private BitmapButton _aboutButton;
    private BitmapButton _startButton;
    private BitmapButton _shopButton;

    private boolean _showHelp;
    private boolean _showAbout;
    private boolean _showShop;

    public StateReady(GameEngine engine) {
        super(engine);
    }

    @Override
    public void initialize(Map<String, Object> data) {
        addGameObject(_helpInfo = new MovingBitmap(R.drawable.helpbackground));
        addGameObject(_background = new MovingBitmap(R.drawable.readybackground));
        addGameObject(_aboutInfo = new MovingBitmap(R.drawable.aboutbackground));
        initializeStartButton();
        initializeExitButton();
        initializeMenuButton();
        initializeHelpButton();
        initializeAboutButton();
        initializeShopButton();
        setVisibility(false, false);
    }

    /**
     * ��l�ơyAbout�z�����s�C
     */
    // �}�o²��
    private void initializeAboutButton() {
        addGameObject(_aboutButton = new BitmapButton(R.drawable.about, R.drawable.about_pressed, 465, 270));
        _aboutButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                setVisibility(false, true);
            }
        });
        addPointerEventHandler(_aboutButton);
    }

    /**
     * ��l�ơyHelp�z�����s�C
     */
    // �C������
    private void initializeHelpButton() {
        addGameObject(_helpButton = new BitmapButton(R.drawable.help, R.drawable.help_pressed, 465, 220));
        _helpButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                setVisibility(true, false);
            }
        });
        addPointerEventHandler(_helpButton);
    }

    /**
     * ��l�ơyMenu�z�����s�C
     */
    private void initializeMenuButton() {
        addGameObject(_menuButton = new BitmapButton(R.drawable.menu, R.drawable.menu_pressed, 465, 320));
        _menuButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                setVisibility(false, false);
            }
        });
        addPointerEventHandler(_menuButton);
    }

    /**
     * ��l�ơyExit�z�����s�C
     */
    private void initializeExitButton() {
        addGameObject(_exitButton = new BitmapButton(R.drawable.exit, R.drawable.exit_pressed, 465, 320));
        _exitButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                _engine.exit();
            }
        });
        addPointerEventHandler(_exitButton);
    }

    /**
     * ��l�ơyStart�z�����s�C
     */
    private void initializeStartButton() {
        addGameObject(_startButton = new BitmapButton(R.drawable.start, R.drawable.start_pressed, 465, 170));
        _startButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                changeState(Game.RUNNING_STATE);
            }
        });
        addPointerEventHandler(_startButton);
    }

    private void initializeShopButton() {
        addGameObject(_shopButton = new BitmapButton(R.drawable.shop, R.drawable.shop_pressed, 465, 120));
        _shopButton.addButtonEventHandler(new ButtonEventHandler() {
            @Override
            public void perform(BitmapButton button) {
                changeState(Game.SHOP_STATE);
            }
        });
        addPointerEventHandler(_shopButton);
    }

    @Override
    public void pause() {
    }

    @Override
    public void resume() {
    }

    /**
     * �]�w�e���W���ǹϤ�����ܡA���ǹϤ������áC
     *
     * @param showHelp  ���Help�e��
     * @param showAbout ���About�e��
     */
    private void setVisibility(boolean showHelp, boolean showAbout) {
        _showHelp = showHelp;
        _showAbout = showAbout;
        boolean showMenu = !_showAbout && !_showHelp;
        _helpInfo.setVisible(_showHelp);
        _aboutInfo.setVisible(_showAbout);
        _background.setVisible(showMenu);

        _exitButton.setVisible(showMenu);
        _helpButton.setVisible(showMenu);
        _aboutButton.setVisible(showMenu);
        _startButton.setVisible(showMenu);
        _menuButton.setVisible(!showMenu);
        _shopButton.setVisible(showMenu);
    }
}

