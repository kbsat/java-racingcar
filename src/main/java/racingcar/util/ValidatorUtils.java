package racingcar.util;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import static racingcar.constants.output.ErrorOutputMessages.ERROR_BLANK_NOT_ALLOWED;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_DUPLICATE_NAME;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_NOT_POSITIVE_INTEGER;
import static racingcar.constants.output.ErrorOutputMessages.ERROR_OVER_FIVE_CHARACTERS;
import static racingcar.constants.GameConstants.MAX_NAME_LENGTH;
import static racingcar.constants.SystemConstants.NUMBER_ZERO;

public class ValidatorUtils {

    private ValidatorUtils() {
    }

    public static void validatePositiveInt(int integer) {
        if (integer <= NUMBER_ZERO) {
            throw new IllegalArgumentException(ERROR_NOT_POSITIVE_INTEGER);
        }
    }

    public static void validateCarName(String name) {
        validateNotBlank(name);
        validateNotOverFiveCharacters(name);
    }

    private static void validateNotBlank(String string) {
        if (string.isBlank()) {
            throw new IllegalArgumentException(ERROR_BLANK_NOT_ALLOWED);
        }
    }

    private static void validateNotOverFiveCharacters(String string) {
        if (string.length() > MAX_NAME_LENGTH) {
            throw new IllegalArgumentException(ERROR_OVER_FIVE_CHARACTERS);
        }
    }

    public static void validateNoDuplicates(String[] strings) {
        Set<String> carNameSet = new HashSet<>(Arrays.asList(strings));
        if (strings.length != carNameSet.size()) {
            throw new IllegalArgumentException(ERROR_DUPLICATE_NAME);
        }
    }
}
