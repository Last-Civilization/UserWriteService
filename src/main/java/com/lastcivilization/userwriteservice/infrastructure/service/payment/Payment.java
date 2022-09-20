package com.lastcivilization.userwriteservice.infrastructure.service.payment;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Payment(
        @JsonProperty("id")
        long id
){}
