package ch.wisv.toornament.model.request;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

import ch.wisv.toornament.model.MatchFormat;
<<<<<<< HEAD
import ch.wisv.toornament.model.MatchType;
import ch.wisv.toornament.model.ParticipantType;
import ch.wisv.toornament.model.Status;
=======
import ch.wisv.toornament.model.ParticipantType;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
>>>>>>> parent of 0b5adf4... Revert "Remove Lombok dependency and apply editorconfig"

public class TournamentRequest {

    String id;
    String discipline;
    String name;
    @JsonProperty("full_name")
    String fullName;
    Status status;
    @JsonProperty("date_start")
    Date dateStart;
    @JsonProperty("date_end")
    Date dateEnd;
    String timezone;
    Boolean online;
    @JsonProperty("public")
    Boolean isPublic;
    String location;
    String country;
    Integer size;
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
    @JsonProperty("check_in")
    Boolean checkIn;
    @JsonProperty("participant_nationality")
    Boolean participantNationality;
    @JsonProperty("match_format")
    MatchFormat matchFormat;
}
