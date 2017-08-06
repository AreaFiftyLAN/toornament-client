package ch.wisv.toornament.model;

import ch.wisv.toornament.model.enums.MatchStatus;

import java.util.List;

public class Game {
    private int number;
    private MatchStatus status;
    private List<Opponent> opponents;
}
