package bridge.controller;


import bridge.BridgeNumberGenerator;
import bridge.domain.BridgeMaker;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;

public class GameController {

    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final InputView inputView;
    private final OutputView outputView;

    public GameController(final BridgeNumberGenerator bridgeNumberGenerator,
                          final InputView inputView,
                          final OutputView outputView) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        final BridgeMaker bridgeMaker = initBridgeMaker();
        System.out.println(bridgeMaker.getDefaultBridge().toString());

    }

    public BridgeMaker initBridgeMaker() {
        return ExceptionHandler.getExceptionHandler(() -> {
            final int size = inputView.readBridgeSize();
            return new BridgeMaker(bridgeNumberGenerator, size);
        });
    }




}
