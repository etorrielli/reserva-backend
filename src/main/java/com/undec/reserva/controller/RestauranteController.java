package com.undec.reserva.controller;

import com.undec.reserva.dto.Response;
import com.undec.reserva.service.RestauranteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {

    private static final Logger LOG = LoggerFactory.getLogger(RestauranteController.class);

    @Autowired
    private RestauranteService restauranteService;

    @GetMapping
    public ResponseEntity<Response> list() throws Exception {
        LOG.info("list");
        Response response = restauranteService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
