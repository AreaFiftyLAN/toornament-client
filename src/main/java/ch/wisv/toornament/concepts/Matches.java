package ch.wisv.toornament.concepts;

import ch.wisv.toornament.ToornamentClient;
import ch.wisv.toornament.exception.ToornamentException;
import ch.wisv.toornament.model.Match;
import ch.wisv.toornament.model.MatchDetails;
import ch.wisv.toornament.model.TournamentDetails;
import ch.wisv.toornament.model.enums.MatchSort;
import okhttp3.HttpUrl;
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
            HttpUrl.Builder urlBuilder = new HttpUrl.Builder()
                .scheme("https")
                .host("api.toornament.com")
                .addPathSegment("v1/tournaments")
                .addPathSegment(tournament.getId())
                .addPathSegment("matches")
                .addQueryParameter("has_result", hasResult ? "1" : "0");

            if (stageNumber != null) {
                urlBuilder.addQueryParameter("stage_number", String.valueOf(stageNumber));
            }
            if (groupNumber != null) {
                urlBuilder.addQueryParameter("group_number", String.valueOf(groupNumber));
            }
            if (roundNumber != null) {
                urlBuilder.addQueryParameter("round_number", String.valueOf(roundNumber));
            }
            urlBuilder.addQueryParameter("sort", sort.getName());
            if (participantId != null) {
                urlBuilder.addQueryParameter("participant_id", participantId);
            }
            urlBuilder.addQueryParameter("with_games", withGames ? "1" : "0");

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
