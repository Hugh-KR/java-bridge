package bridge.view.output;

import bridge.dto.PositionDto;
import bridge.view.output.message.OutputMessage;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printMessage(final String message) {
        System.out.println(message);
    }

    private void printMessage(final OutputMessage outputMessage) {
        this.printMessage(outputMessage.getMessage());
    }

    public void printReadBridgeSizeMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_BRIDGE_SIZE_MESSAGE);
    }

    public void printReadMoveToPositionMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_MOVE_POSITION_MESSAGE);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(final PositionDto positionDto) {
        printMessage(positionDto.toString());
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printRetryMessage() {
        printEmptyLine();
        printMessage(OutputMessage.READ_GAME_RE_TRY_MESSAGE);
    }

    public void printFailResult(final PositionDto positionDto) {
        printEmptyLine();
        printMessage(String.format(
                OutputMessage.PRINT_GAME_FAIL_MESSAGE.getMessage(),
                positionDto.toString(),
                positionDto.getCount()
        ));
    }

    public void printEmptyLine() {
        System.out.println();
    }
}
