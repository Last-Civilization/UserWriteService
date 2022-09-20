package com.lastcivilization.userwriteservice.infrastructure.service.equipment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Equipment (
        @JsonProperty("id")
        long id
) { }
