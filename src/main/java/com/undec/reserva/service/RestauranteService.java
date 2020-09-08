package com.undec.reserva.service;

import com.undec.reserva.dto.Response;
import com.undec.reserva.dto.RestauranteDTO;
import com.undec.reserva.model.Restaurante;
import com.undec.reserva.repository.RestauranteRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestauranteService {

    private static final Logger LOG = LoggerFactory.getLogger(RestauranteService.class);

    @Autowired
    RestauranteRepository restauranteRepository;

    public Response findAll() throws Exception {
        Response response = new Response();
        List<Restaurante> restauranteList = restauranteRepository.findAll();
        List<RestauranteDTO> restauranteDTOList = new RestauranteDTO().getRestauranteDTOList(restauranteList);
        response.setData(restauranteDTOList);
        return response;
    }
}
