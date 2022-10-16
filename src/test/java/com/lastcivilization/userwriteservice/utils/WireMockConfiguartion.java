package com.lastcivilization.userwriteservice.utils;

import com.github.tomakehurst.wiremock.WireMockServer;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.lastcivilization.userwriteservice.infrastructure.service.equipment.EquipmentClient;
import com.lastcivilization.userwriteservice.infrastructure.service.payment.PaymentClient;
import com.lastcivilization.userwriteservice.infrastructure.service.stats.StatsClient;
import feign.Client;
import feign.Contract;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.cloud.openfeign.FeignClientsConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;

import static com.github.tomakehurst.wiremock.client.WireMock.aResponse;
import static com.github.tomakehurst.wiremock.client.WireMock.post;
import static com.github.tomakehurst.wiremock.client.WireMock.put;
import static com.github.tomakehurst.wiremock.client.WireMock.get;
import static org.springframework.http.HttpStatus.OK;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@TestConfiguration
class WireMockConfiguartion {

    @Bean(initMethod = "start", destroyMethod = "stop")
    public WireMockServer wireMockServer(){
        WireMockServer wireMockServer = new WireMockServer(9561);
        mockEquipment(wireMockServer);
        mockPayments(wireMockServer);
        mockStats(wireMockServer);
        mockSage(wireMockServer);
        return wireMockServer;
    }

    private void mockSage(WireMockServer wireMockServer){
        wireMockServer.stubFor(put(WireMock.urlMatching("/users/workflows/.*/equipments/.*"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("workflowId")));
        wireMockServer.stubFor(put(WireMock.urlMatching("/users/workflows/.*/stats/.*"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("workflowId")));
        wireMockServer.stubFor(put(WireMock.urlMatching("/users/workflows/.*/accounts/.*"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("workflowId")));
        wireMockServer.stubFor(get(WireMock.urlEqualTo("/users/workflows"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("workflowId")));
    }

    private void mockEquipment(WireMockServer wireMockServer){
        wireMockServer.stubFor(post(WireMock.urlEqualTo("/equipments"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("{ \"id\":0}")));
    }

    private void mockStats(WireMockServer wireMockServer){
        wireMockServer.stubFor(post(WireMock.urlEqualTo("/stats"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("{ \"id\":0}")));
    }

    private void mockPayments(WireMockServer wireMockServer){
        wireMockServer.stubFor(post(WireMock.urlEqualTo("/payments"))
                .willReturn(aResponse()
                        .withStatus(OK.value())
                        .withHeader("Content-Type", APPLICATION_JSON_VALUE)
                        .withBody("{ \"id\":0, \"money\":0}")));
    }
}
