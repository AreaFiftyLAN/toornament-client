<<<<<<< HEAD
package ch.wisv.toornament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class DisciplineDetails extends Discipline {
    
    @JsonProperty("team_size")
    TeamSize teamSize;
    @JsonProperty("additional_fields")
    List<Map<String, Object>> additionalFields;

    private class TeamSize {
        int min;
        int max;
    }
}
=======
package ch.wisv.toornament.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;
import java.util.Map;

public class DisciplineDetails extends Discipline {

    @JsonProperty("team_size")
    TeamSize teamSize;
    @JsonProperty("additional_fields")
    List<Map<String, Object>> additionalFields;

    private class TeamSize {
        int min;
        int max;
    }
}
>>>>>>> parent of 0b5adf4... Revert "Remove Lombok dependency and apply editorconfig"
