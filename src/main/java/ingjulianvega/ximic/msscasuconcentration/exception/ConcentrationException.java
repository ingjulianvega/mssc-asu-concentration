package ingjulianvega.ximic.msscasuconcentration.exception;

import lombok.Getter;

@Getter
public class ConcentrationException extends RuntimeException {

    private final String code;

    public ConcentrationException(final String code, final String message) {
        super(message);
        this.code = code;
    }
}

