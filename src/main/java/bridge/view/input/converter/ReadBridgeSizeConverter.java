package bridge.view.input.converter;

import bridge.exception.BridgeExceptionStatus;
import bridge.exception.CustomIllegalArgumentException;

public class ReadBridgeSizeConverter {

    static final ReadBridgeSizeConverter READ_BRIDGE_SIZE_CONVERTER = new ReadBridgeSizeConverter();

    private ReadBridgeSizeConverter() {
    }

    public static int convertBridgeSize(final String size) {
        return READ_BRIDGE_SIZE_CONVERTER.parseNumber(size);
    }

    private int parseNumber(final String size) {
        try {
            return Integer.parseInt(isNull(size));
        } catch (NumberFormatException e) {
            throw new CustomIllegalArgumentException(BridgeExceptionStatus.SIZE_IS_OUT_OF_RANGE);
        }
    }

    private String isNull(final String size) {
        try {
            return size.trim();
        } catch (NullPointerException e) {
            throw new CustomIllegalArgumentException(BridgeExceptionStatus.SIZE_IS_OUT_OF_RANGE);
        }
    }
}
