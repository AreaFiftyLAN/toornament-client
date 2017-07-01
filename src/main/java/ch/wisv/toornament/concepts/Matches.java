package ch.wisv.toornament.concepts;

import ch.wisv.toornament.ToornamentClient;
import ch.wisv.toornament.exception.ToornamentException;
import ch.wisv.toornament.model.Match;
import ch.wisv.toornament.model.MatchDetails;
import ch.wisv.toornament.model.TournamentDetails;
import ch.wisv.toornament.model.enums.MatchSort;
import okhttp3.Request;

import java.io.IOException;
import java.util.List;

public class Matches extends Concept {
    private TournamentDetails tournament;

    public Matches(ToornamentClient client, TournamentDetails tournament) {
        super(client);
        this.tournament = tournament;
    }

    public List<Match> getMatches() {
        return getMatches(false, null, null, null, MatchSort.SCHEDULE, null, false);
    }

    public List<Match> getMatches(boolean hasResult, Integer stageNumber, Integer groupNumber, Integer roundNumber,
                                  MatchSort sort, String participantId, boolean withGames) {
        try {
            StringBuilder urlBuilder = new StringBuilder("https://api.toornament.com/v1/tournaments/");
            urlBuilder
                .append(tournament.getId())
                .append("/matches")
                .append("?has_result=").append(hasResult ? "1" : "0");
            if (stageNumber != null) {
                urlBuilder.append("&stage_number=").append(stageNumber);
            }
            if (groupNumber != null) {
                urlBuilder.append("&group_number=").append(groupNumber);
            }
            if (roundNumber != null) {
                urlBuilder.append("&round_numer=").append(roundNumber);
            }
            urlBuilder.append("&sort=").append(sort.getName());
            if (participantId != null) {
                urlBuilder.append("&participant_id=").append(participantId);
            }
            urlBuilder.append("&with_games=").append(withGames ? "1" : "0");

            Request request = client.getAuthenticatedRequestBuilder()
                .get()
                .url(urlBuilder.toString())
                .build();
            String responseBody = client.executeRequest(request).body().string();
            return mapper.readValue(responseBody, mapper.getTypeFactory().constructCollectionType(List.class, Match.class));
        } catch (IOException e) {
            e.printStackTrace();
            throw new ToornamentException("Got IOExcption getting matches");
        }
    }

    public MatchDetails getMatch(String matchId, boolean withGames) {
        try {
            Request request = client.getAuthenticatedRequestBuilder()
                .get()
                .url("https://api.toornament.com/v1/tournaments/" + tournament.getId()
                    + "/matches/" + matchId
                    + "?with_games=" + (withGames ? "1" : "0"))
                .build();
            String responseBody = client.executeRequest(request).body().string();
            return mapper.readValue(responseBody, MatchDetails.class);
        } catch (IOException e) {
            e.printStackTrace();
            throw new ToornamentException("Got IOException getting match with ID " + matchId);
        }
    }
}
