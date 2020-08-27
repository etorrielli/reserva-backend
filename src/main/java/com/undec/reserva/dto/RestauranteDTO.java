package com.undec.reserva.dto;

import com.undec.reserva.model.Restaurante;

import java.util.ArrayList;
import java.util.List;

public class RestauranteDTO {
    private Integer id;
    private String nombre;
    private String direccion;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<RestauranteDTO> getRestauranteDTOList(List<Restaurante> restauranteList) {
        List<RestauranteDTO> restauranteDTOList = new ArrayList<>();
        for (Restaurante item : restauranteList) {
            RestauranteDTO restauranteDTO = new RestauranteDTO();
            restauranteDTO.setId(item.getId());
            restauranteDTO.setNombre(item.getNombre());
            restauranteDTO.setDireccion(item.getDireccion());
            restauranteDTOList.add(restauranteDTO);
        }
        return restauranteDTOList;
    }

    public RestauranteDTO getRestauranteDTO(Restaurante item) {
        RestauranteDTO restauranteDTO = new RestauranteDTO();
        restauranteDTO.setId(item.getId());
        restauranteDTO.setNombre(item.getNombre());
        restauranteDTO.setDireccion(item.getDireccion());
        return restauranteDTO;
    }
}
