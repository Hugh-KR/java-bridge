package bridge.view.input.converter;

import bridge.constant.Constant;
import bridge.exception.BridgeExceptionStatus;
import bridge.exception.CustomIllegalArgumentException;

public class ReadRetryConverter {

    static final ReadRetryConverter READ_RETRY_CONVERTER = new ReadRetryConverter();

    private ReadRetryConverter() {
    }

    public static String convertRetryCommend(final String commend) {
        return READ_RETRY_CONVERTER.validateRetryCommend(isNull(commend));
    }

    private String validateRetryCommend(final String commend) {
        if (!isAvailable(commend)) {
            throw new CustomIllegalArgumentException(BridgeExceptionStatus.RETRY_COMMEND_IS_NOT_AVAILABLE);
        }
        return commend;
    }

    private boolean isAvailable(final String commend) {
        return commend.equals(Constant.COMMEND_OF_RETRY)
                || commend.equals(Constant.COMMEND_OF_EXIT);
    }

    private static String isNull(final String commend) {
        try {
            return commend.trim();
        } catch (NullPointerException e) {
            throw new CustomIllegalArgumentException(BridgeExceptionStatus.RETRY_COMMEND_IS_NOT_AVAILABLE);
        }
    }
}
