package bridge;


import bridge.controller.GameController;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class AppConfig {

    private static final AppConfig APP_CONFIG = new AppConfig();

    public final GameController gameController;
    public final BridgeNumberGenerator bridgeNumberGenerator;
    public final InputView inputView;
    public final OutputView outputView;

    private AppConfig() {
        this.outputView = initOutputView();
        this.inputView = initInputView(outputView);
        this.bridgeNumberGenerator = initBridgeNumberGenerator();
        this.gameController = initController(bridgeNumberGenerator, inputView, outputView);
    }

    public static AppConfig getInstance() {
        return APP_CONFIG;
    }

    private OutputView initOutputView() {
        return new OutputView();
    }

    private InputView initInputView(final OutputView outputView) {
        return new InputView(outputView);
    }

    private BridgeNumberGenerator initBridgeNumberGenerator() {
        return new BridgeRandomNumberGenerator();
    }

    private GameController initController(final BridgeNumberGenerator bridgeNumberGenerator,
                                          final InputView inputView,
                                          final OutputView outputView) {
        return new GameController(bridgeNumberGenerator, inputView, outputView);
    }
}
