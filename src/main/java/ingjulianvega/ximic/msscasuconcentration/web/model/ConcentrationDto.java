package ingjulianvega.ximic.msscasuconcentration.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConcentrationDto implements Serializable {

    static final long serialVersionUID = -1564318625715019859L;

    private UUID id;
    private String name;
    private String abbreviation;

}
