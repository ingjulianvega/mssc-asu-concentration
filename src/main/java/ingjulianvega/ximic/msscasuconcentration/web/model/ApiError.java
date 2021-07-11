package ingjulianvega.ximic.msscasuconcentration.web.model;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ApiError {

    private LocalDateTime timestamp;
    private String api;
    private String apiCode;
    private String error;
    private String message;
    private String solution;
}
