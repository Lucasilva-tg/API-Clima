package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
public class Service {
    public String preverTempo() {
        String dadosMeteorologicos = "";
        String apiUrl = "http://apiadvisor.climatempo.com.br/api/v1/anl/synoptic/locale/BR?token=e555565852d621174dcc1d89b181ce9c";

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(apiUrl, String.class);

        if (responseEntity.getStatusCode().is2xxSuccessful()) {
            dadosMeteorologicos = responseEntity.getBody();
        } else {
            dadosMeteorologicos = "falha ao obter dados meteorologicos. Código de status: " + responseEntity.getStatusCode();

        }
        return dadosMeteorologicos;
    }
}
