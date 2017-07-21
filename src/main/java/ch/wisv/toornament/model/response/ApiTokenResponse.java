package ch.wisv.toornament.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ApiTokenResponse {

    @JsonProperty("access_token")
    String accessToken;
    @JsonProperty("expires_in")
    String expiresIn;
    @JsonProperty("token_type")
    String tokenType;
    @JsonProperty("scope")		
      String scope;
    
    public ApiTokenResponse() {
    }

    public String getAccessToken() {
        return this.accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getExpiresIn() {
        return this.expiresIn;
    }

    public void setExpiresIn(String expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getScope() {
        return this.scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }
    

    public String toString() {
        return "ch.wisv.toornament.model.response.ApiTokenResponse(accessToken=" + this
            .getAccessToken()
            + ", expiresIn=" + this.getExpiresIn() + ", tokenType=" + this.getTokenType()
            + ", scope="
            + this.getScope() + ")";
    }
}
