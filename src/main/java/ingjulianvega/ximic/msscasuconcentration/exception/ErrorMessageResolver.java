package ingjulianvega.ximic.msscasuconcentration.exception;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ingjulianvega.ximic.msscasuconcentration.configuration.ConcentrationParameters;
import ingjulianvega.ximic.msscasuconcentration.web.model.ApiError;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import static org.apache.commons.lang3.StringUtils.isEmpty;

@Getter
@Setter
@Component
@Slf4j
@ConfigurationProperties
@PropertySources({
        @PropertySource(value = "classpath:error-messages.properties", name = "error-messages", ignoreResourceNotFound = true)
})
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class ErrorMessageResolver {

    private final Environment environment;

    private final ObjectMapper mapper;

    private final ConcentrationParameters concentrationParameters;


    public ApiError resolveApiException(final String response) {
        ApiError apiError;
        try {
            apiError = mapper.readValue(response, ApiError.class);
            final String key = StringUtils.remove(apiError.getCode(), "API-")
                    .replace(":", "-");
            String property = environment.getProperty(key);
            if (isEmpty(property)) {
                return getApiGenericError();
            }

            apiError.setDescription(property);
        } catch (JsonProcessingException e) {
            log.error("Error to read value", e);
            apiError = getApiGenericError();
        }
        return apiError;
    }

    public ApiError resolveException(final String key) {
        final String property = environment.getProperty(key);
        if (isEmpty(property)) {
            return getApiGenericError();
        }
        final String[] errorArr = property.split("\\|");
        return ApiError.builder().code(concentrationParameters.getPrefix() + errorArr[0]).description(errorArr[1]).build();
    }

    private ApiError getApiGenericError() {
        final String message = "UNKNOWN ERROR";
        return ApiError.builder()
                .code(concentrationParameters.getPrefix() + "500:199")
                .description(message)
                .build();
    }
}

