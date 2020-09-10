package com.undec.reserva.service;

import com.undec.reserva.dto.Response;
import com.undec.reserva.dto.ReservaDTO;
import com.undec.reserva.model.Reserva;
import com.undec.reserva.model.Restaurante;
import com.undec.reserva.repository.ReservaRepository;
import com.undec.reserva.repository.RestauranteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class ReservaService {

    private static final Logger LOG = LoggerFactory.getLogger(ReservaService.class);

    @Autowired
    ReservaRepository reservaRepository;
    @Autowired
    RestauranteRepository restauranteRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        List<Reserva> reservaList = reservaRepository.findAll();
        List<ReservaDTO> reservaDTOList = new ReservaDTO().getReservaDTOList(reservaList);
        response.setData(reservaDTOList);
        return response;
    }

    public Response findOneById(Integer id) throws Exception {
        Response response = new Response();
        Reserva reserva = reservaRepository.findById(id).get();
        ReservaDTO reservaDTO = new ReservaDTO().getReservaDTO(reserva);
        response.setData(reservaDTO);
        return response;
    }

    public Response findByFechaHoraBetween(String dateFrom, String dateTo) throws Exception {
        Response response = new Response();
        String pattern = "yyyy-MM-ddHH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);
        Date convertedDateFrom = df.parse(dateFrom);
        Date convertedDateTo = df.parse(dateTo);

        List<Reserva> reservaList = reservaRepository.findByFechaHoraBetween(convertedDateFrom, convertedDateTo);
        List<ReservaDTO> reservaDTOList = new ReservaDTO().getReservaDTOList(reservaList);
        response.setData(reservaDTOList);
        return response;
    }

    public Response save(ReservaDTO reservaDTO) throws Exception {
        Response response = new Response();
        Restaurante restaurante = restauranteRepository.findById(reservaDTO.getRestauranteId()).get();
        Reserva reserva = new ReservaDTO().getReserva(reservaDTO, restaurante);
        reserva = reservaRepository.save(reserva);
        response.setData(reserva);
        return response;
    }
}
