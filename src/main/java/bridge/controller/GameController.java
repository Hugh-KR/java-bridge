package bridge.controller;


import bridge.BridgeNumberGenerator;
import bridge.constant.Constant;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;
import bridge.dto.PositionDto;
import bridge.view.input.InputView;
import bridge.view.output.OutputView;
import java.util.List;

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

        makeUserPosition(bridgeMaker);

    }

    public BridgeMaker initBridgeMaker() {
        return ExceptionHandler.getExceptionHandler(() -> {
            final int size = inputView.readBridgeSize();
            return new BridgeMaker(bridgeNumberGenerator, size);
        });
    }

    public void makeUserPosition(final BridgeMaker bridgeMaker) {
        final List<String> defaultBridge = bridgeMaker.getDefaultBridge();
        PositionDto positionDto = null;
        for (int i = 1; i <= defaultBridge.size(); i++) {
            final String commend = inputView.readMoving();
            System.out.println(defaultBridge);
            final List<List<String>> positions =  BridgeGame.move(commend, defaultBridge.get(i));
//            final List<String> userPosition = bridgeMaker.makeUserPosition(positions);
            positionDto = new PositionDto(positions.get(0), positions.get(1), i);
            outputView.printMap(positionDto);

            if (positions.get(0).contains("X") || positions.get(1).contains("X")) {
                gameCycle(positionDto);
                break;
            }
        }
        gameClear(positionDto);
    }

    public void gameCycle(final PositionDto positionDto) {
        final String retryCommend = initRetryCommend();
        if (retryCommend.equals(Constant.COMMEND_OF_EXIT)) {
            gameFail(positionDto);
        }
        if (retryCommend.equals(Constant.COMMEND_OF_RETRY)) {
            run();
        }
    }

    private void gameFail(final PositionDto positionDto) {
        outputView.printFailResult(positionDto);
    }

    private void gameClear(final PositionDto positionDto) {
        outputView.printFailResult(positionDto);
    }

    private String initRetryCommend() {
        return ExceptionHandler.getExceptionHandler(inputView::readGameCommand);
    }
}
