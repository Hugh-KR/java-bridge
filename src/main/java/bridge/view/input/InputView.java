package bridge.view.input;

import bridge.view.input.converter.ReadBridgeSizeConverter;
import bridge.view.input.converter.ReadMoveToPositionConverter;
import bridge.view.input.converter.ReadRetryConverter;
import bridge.view.output.OutputView;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final OutputView outputView;

    public InputView(final OutputView outputView) {
        this.outputView = outputView;
    }


    public String readLine() {
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        outputView.printReadBridgeSizeMessage();
        return ReadBridgeSizeConverter.convertBridgeSize(readLine());
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printReadMoveToPositionMessage();
        return ReadMoveToPositionConverter.convertMoveToPosition(readLine());
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printRetryMessage();
        return ReadRetryConverter.convertRetryCommend(readLine());
    }
}
