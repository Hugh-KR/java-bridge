package bridge.view.output.message;

public enum OutputMessage {

    READ_BRIDGE_SIZE_MESSAGE(
            """
            다리 건너기 게임을 시작합니다.
                                        
            다리의 길이를 입력해주세요."""
    ),
    READ_MOVE_POSITION_MESSAGE("이동할 칸을 선택해주세요. (위: U, 아래: D)"),
    READ_GAME_RE_TRY_MESSAGE("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)"),

    PRINT_GAME_CLEAR_MESSAGE(
            """
            최종 게임 결과
            %s
                              
            게임 성공 여부: 성공
            총 시도한 횟수: %d"""),
    PRINT_GAME_FAIL_MESSAGE("""
            최종 게임 결과
            %s
                              
            게임 성공 여부: 실패
            총 시도한 횟수: %d""");

    private final String message;

    OutputMessage(final String message) {
        this.message = message;
    }

    public String getMessage() {
        return this.message;
    }
}
