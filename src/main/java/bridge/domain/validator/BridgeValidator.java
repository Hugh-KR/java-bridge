package bridge.domain.validator;

import bridge.constant.Constant;
import bridge.exception.BridgeExceptionStatus;
import bridge.exception.CustomIllegalArgumentException;

public class BridgeValidator {

    static final BridgeValidator BRIDGE_VALIDATOR = new BridgeValidator();

    private BridgeValidator() {
    }

    public static void validateBridge(final int size) {
        BRIDGE_VALIDATOR.validateSizeIsOutOfRange(size);
    }

    private void validateSizeIsOutOfRange(final int size) {
        if (isOutOfRange(size)) {
            throw new CustomIllegalArgumentException(BridgeExceptionStatus.SIZE_IS_OUT_OF_RANGE);
        }
    }

    private boolean isOutOfRange(final int size) {
        return size < Constant.MINIMUM_BRIDGE_SIZE
                || size > Constant.MAXIMUM_BRIDGE_SIZE;
    }
}
