package bridge.domain;

import bridge.BridgeNumberGenerator;
import bridge.constant.Constant;
import bridge.domain.validator.BridgeValidator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final List<String> defaultBridge;
    private final BridgeNumberGenerator bridgeNumberGenerator;
    private final int size;

    public BridgeMaker(final BridgeNumberGenerator bridgeNumberGenerator, final int size) {
        BridgeValidator.validateBridge(size);
        this.bridgeNumberGenerator = bridgeNumberGenerator;
        this.size = size;
        this.defaultBridge = makeBridge(size);
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(final int size) {
        final List<String> defaultBridge = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            final int randomNumber = bridgeNumberGenerator.generate();
            defaultBridge.add(makeDefaultPosition(randomNumber));
        }
        return defaultBridge;
    }

    public String makeDefaultPosition(final int randomNumber) {
        if (randomNumber == Constant.CONDITION_OF_MOVE_TO_UP) {
            return Constant.POSITION_OF_MOVE_TO_UP;
        }
        return Constant.POSITION_OF_MOVE_TO_DOWN;
    }

    public List<String> makeUserPosition(final List<String> positions) {
        String upPosition = "";
        String downPosition = "";
        for (String position : positions) {
            System.out.println(position);
            upPosition += position.charAt(0);
            downPosition += position.charAt(1);
        }
        return List.of(upPosition, downPosition);
    }



    public List<String> getDefaultBridge() {
        return this.defaultBridge;
    }

    public BridgeNumberGenerator getBridgeNumberGenerator() {
        return this.bridgeNumberGenerator;
    }

    public int getSize() {
        return this.size;
    }
}
