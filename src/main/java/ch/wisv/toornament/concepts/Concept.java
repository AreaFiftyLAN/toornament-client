package ch.wisv.toornament.concepts;

<<<<<<< HEAD
import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD

import ch.wisv.toornament.ToornamentClient;
=======
>>>>>>> parent of 0b5adf4... Revert "Remove Lombok dependency and apply editorconfig"
=======
import ch.wisv.toornament.ToornamentClient;
import com.fasterxml.jackson.databind.ObjectMapper;
>>>>>>> refs/remotes/origin/master

abstract class Concept {
    ToornamentClient client;
    ObjectMapper mapper;

    public Concept(ToornamentClient client) {
        this.client = client;
        mapper = client.getMapper();
    }
}
