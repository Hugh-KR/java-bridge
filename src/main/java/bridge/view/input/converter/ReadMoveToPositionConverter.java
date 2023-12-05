package bridge.view.input.converter;

import bridge.constant.Constant;
import bridge.exception.BridgeExceptionStatus;
import bridge.exception.CustomIllegalArgumentException;

public class ReadMoveToPositionConverter {

    static final ReadMoveToPositionConverter READ_MOVE_TO_POSITION_CONVERTER = new ReadMoveToPositionConverter();

    private ReadMoveToPositionConverter() {
    }

    public static String convertMoveToPosition(final String commend) {
        return READ_MOVE_TO_POSITION_CONVERTER.validateMoveCommend(isNull(commend));
    }

    private String validateMoveCommend(final String commend) {
        if (!isAvailable(commend)) {
            throw new CustomIllegalArgumentException(BridgeExceptionStatus.MOVE_COMMEND_IS_NOT_AVAILABLE);
        }
        return commend;
    }

    private boolean isAvailable(final String commend) {
        return commend.equals(Constant.COMMEND_OF_MOVE_TO_UP)
                || commend.equals(Constant.COMMEND_OF_MOVE_TO_DOWN);
    }

    private static String isNull(final String commend) {
        try {
            return commend.trim();
        } catch (NullPointerException e) {
            throw new CustomIllegalArgumentException(BridgeExceptionStatus.MOVE_COMMEND_IS_NOT_AVAILABLE);
        }
    }
}
