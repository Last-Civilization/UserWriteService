package com.lastcivilization.userwriteservice.infrastructure.service.stats;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Stats(
        @JsonProperty("id")
        long id
) {

}
