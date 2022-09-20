package com.lastcivilization.userwriteservice.utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

class FeignClientMocks {

    public static void mockEquipment(WireMockServer wireMockServer){
        wireMockServer.stubFor(post(WireMock.urlEqualTo("/equipments"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("{ \"id\":0}")));
    }

    public static void mockStats(WireMockServer wireMockServer){
        wireMockServer.stubFor(post(WireMock.urlEqualTo("/stats"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("{ \"id\":0}")));
    }

    public static void mockPayments(WireMockServer wireMockServer){
        wireMockServer.stubFor(post(WireMock.urlEqualTo("/payments"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("{ \"id\":0}")));
    }
}
