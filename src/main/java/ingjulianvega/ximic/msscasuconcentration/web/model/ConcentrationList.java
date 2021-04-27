package ingjulianvega.ximic.msscasuconcentration.web.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ConcentrationList implements Serializable {

    static final long serialVersionUID = -3987431600553712387L;

    public ArrayList<ConcentrationDto> concentrationList;
}
