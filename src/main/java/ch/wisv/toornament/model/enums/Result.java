package ch.wisv.toornament.model.enums;

import com.fasterxml.jackson.annotation.JsonProperty;

public enum Result {
    @JsonProperty("1")
    WIN,
    @JsonProperty("2")
    DRAW,
    @JsonProperty("3")
    LOSS;
}
