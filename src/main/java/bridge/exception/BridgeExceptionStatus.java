package bridge.exception;

public enum BridgeExceptionStatus implements ExceptionStatus {

    SIZE_IS_OUT_OF_RANGE("3 이상 20 이하의 숫자만 입력 가능합니다."),
    MOVE_COMMEND_IS_NOT_AVAILABLE("U 혹은 D만 입력 가능합니다."),
    RETRY_COMMEND_IS_NOT_AVAILABLE("R 혹은 Q만 입력 가능합니다.");



    private final String message;

    BridgeExceptionStatus(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
