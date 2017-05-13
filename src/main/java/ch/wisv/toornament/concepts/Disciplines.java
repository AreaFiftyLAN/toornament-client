<<<<<<< HEAD
package ch.wisv.toornament.concepts;

import java.util.Collections;
import java.util.List;

import ch.wisv.toornament.ToornamentClient;
import ch.wisv.toornament.model.Discipline;
import ch.wisv.toornament.model.DisciplineDetails;
import java.io.IOException;
import okhttp3.Request;

public class Disciplines extends Concept {

    private String endpoint = "/disciplines/";

    public Disciplines(ToornamentClient client) {
        super(client);
    }

    public List<Discipline> getDisciplines() throws IOException {
        // TODO: PLACEHOLDER
        Request request = client.getAuthenticatedRequestBuilder().get().url("https://api.toornament.com/v1/disciplines").build();
         String responseBody = client.executeRequest(request).body().string();
        return mapper.readValue(responseBody, mapper.getTypeFactory().constructCollectionType(List.class, Discipline.class));
    }

    public DisciplineDetails getDiscipline(String id) throws IOException {
        // TODO: PLACEHOLDER
        Request request = client.getAuthenticatedRequestBuilder().get().url("https://api.toornament.com/v1/disciplines"+ id ).build();
         String responseBody = client.executeRequest(request).body().string();
         
        return mapper.readValue(responseBody, mapper.getTypeFactory().constructType(DisciplineDetails.class));
    }
}
=======
package ch.wisv.toornament.concepts;

import java.util.Collections;
import java.util.List;

import ch.wisv.toornament.ToornamentClient;
import ch.wisv.toornament.model.Discipline;
import ch.wisv.toornament.model.DisciplineDetails;

public class Disciplines extends Concept {

    private String endpoint = "/disciplines/";

    public Disciplines(ToornamentClient client) {
        super(client);
    }

    public List<Discipline> getDisciplines() {
        // TODO: PLACEHOLDER
        return Collections.emptyList();
    }

    public DisciplineDetails getDiscipline(String id) {
        // TODO: PLACEHOLDER
        return new DisciplineDetails();
    }
}
>>>>>>> parent of 0b5adf4... Revert "Remove Lombok dependency and apply editorconfig"
