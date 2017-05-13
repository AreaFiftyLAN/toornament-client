package ch.wisv.toornament.concepts;

import com.fasterxml.jackson.databind.ObjectMapper;
<<<<<<< HEAD

import ch.wisv.toornament.ToornamentClient;
=======
>>>>>>> parent of 0b5adf4... Revert "Remove Lombok dependency and apply editorconfig"

abstract class Concept {
    ToornamentClient client;
    ObjectMapper mapper;

    public Concept(ToornamentClient client) {
        this.client = client;
        mapper = new ObjectMapper();
    }
}
