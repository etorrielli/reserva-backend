package com.undec.reserva.controller;

import com.undec.reserva.dto.ReservaDTO;
import com.undec.reserva.dto.Response;
import com.undec.reserva.service.ReservaService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reservas")
public class ReservaController {

    private static final Logger LOG = LoggerFactory.getLogger(ReservaController.class);

    @Autowired
    private ReservaService reservaService;

    @GetMapping
    public ResponseEntity<Response> list() throws Exception {
        LOG.info("list");
        Response response = reservaService.findAll();
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/id/{id}")
    public ResponseEntity<Response> getOneById(@PathVariable("id") Integer id) throws Exception {
        Response response = reservaService.findOneById(id);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @GetMapping(value = "/datefrom/{datefrom}/dateto/{dateto}")
    public ResponseEntity<Response> getReservasByFechaHora(@PathVariable("datefrom") String dateFrom, @PathVariable("dateto") String dateTo) throws Exception {
        Response response = reservaService.findByFechaHoraBetween(dateFrom, dateTo);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Response> save(@RequestBody ReservaDTO reservaDTO) throws Exception {
        Response response = reservaService.save(reservaDTO);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
