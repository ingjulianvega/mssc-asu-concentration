package ingjulianvega.ximic.msscasuconcentration.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Concentration implements Serializable {

    static final long serialVersionUID = 1427006055748264308L;

    private String name;
    private String abbreviation;

}
