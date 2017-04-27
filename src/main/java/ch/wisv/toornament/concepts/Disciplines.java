package ch.wisv.toornament.concepts;

import ch.wisv.toornament.ToornamentClient;
import ch.wisv.toornament.model.Discipline;
import ch.wisv.toornament.model.DisciplineDetails;
import ch.wisv.toornament.model.Tournament;
import java.io.IOException;
import java.util.ArrayList;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import okhttp3.Request;

public class Disciplines extends Concept {

    private String endpoint = "/disciplines/";

    public Disciplines(ToornamentClient client) {
        super(client);
    }

    public List<Discipline> getDisciplines() throws IOException {
        // TODO: PLACEHOLDER
         Request request = client.getAuthenticatedRequestBuilder().get().url("https://api.toornament.com/v1"+endpoint).build();
         String responseBody = client.executeRequest(request).body().string();
        return mapper.readValue(responseBody, mapper.getTypeFactory().constructCollectionType(List.class, Discipline.class));
    }

    public DisciplineDetails getDiscipline(String id) throws IOException {
        // TODO: PLACEHOLDER
        List<Discipline> disciplines = getDisciplines();
        
        List<Discipline> result = disciplines.stream().filter(a -> Objects.equals(a.getID(),id)).collect(Collectors.toList());
        DisciplineDetails details = (DisciplineDetails) result.get(0);
        return details;
    }
}
