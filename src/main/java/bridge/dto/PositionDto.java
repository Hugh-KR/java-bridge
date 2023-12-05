package bridge.dto;

import java.util.List;

public class PositionDto {

    private final String userUpPositions;
    private final String userDownPositions;
    private final int count;

    public PositionDto(final List<String> userUpPositions, final List<String> userDownPositions, final int count) {
        this.userUpPositions = convertUserPosition(userUpPositions);
        this.userDownPositions = convertUserPosition(userDownPositions);
        this.count = count;
    }

    private String convertUserPosition(final List<String> userPositions) {
        return String.join(" | ", userPositions);
    }

    public int getCount() {
        return this.count;
    }

    @Override
    public String toString() {
        final String formatedUserPosition =
                String.format("[ %s ]", this.userUpPositions) + "\n"
                + String.format("[ %s ]", this.userDownPositions);
        return formatedUserPosition;
    }
}
