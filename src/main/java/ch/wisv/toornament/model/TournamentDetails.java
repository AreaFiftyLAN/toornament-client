package ch.wisv.toornament.model;

<<<<<<< HEAD
import com.fasterxml.jackson.annotation.JsonProperty;

=======
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

>>>>>>> parent of 0b5adf4... Revert "Remove Lombok dependency and apply editorconfig"
public class TournamentDetails extends Tournament {

    @JsonProperty("participant_type")
    ParticipantType participantType;
    @JsonProperty("match_type")
    MatchType matchType;
    String organization;
    String website;
    String description;
    String rules;
    String prize;
    @JsonProperty("team_size_min")
    Integer teamSizeMin;
    @JsonProperty("team_size_max")
    Integer teamSizeMax;
    // TODO: Stream model
    Object[] streams;
    @JsonProperty("check_in")
    Boolean checkIn;
    @JsonProperty("participant_nationality")
    Boolean participantNationality;
    @JsonProperty("match_format")
    MatchFormat matchFormat;
}
