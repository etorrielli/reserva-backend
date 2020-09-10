package com.undec.reserva.dto;

import com.undec.reserva.model.Reserva;
import com.undec.reserva.model.Restaurante;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ReservaDTO {
    private Integer id;
    private String email;
    private String fechaHora;
    private Integer restauranteId;
    private String restauranteNombre;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getRestauranteNombre() {
        return restauranteNombre;
    }

    public void setRestauranteNombre(String restauranteNombre) {
        this.restauranteNombre = restauranteNombre;
    }

    public Integer getRestauranteId() {
        return restauranteId;
    }

    public void setRestauranteId(Integer restauranteId) {
        this.restauranteId = restauranteId;
    }

    public List<ReservaDTO> getReservaDTOList(List<Reserva> reservaList) {
        List<ReservaDTO> reservaDTOList = new ArrayList<>();
        for (Reserva reserva : reservaList) {
            String pattern = "dd/MM/yyyy HH:mm:ss";
            DateFormat df = new SimpleDateFormat(pattern);

            ReservaDTO reservaDTO = new ReservaDTO();
            reservaDTO.setId(reserva.getId());
            reservaDTO.setEmail(reserva.getEmail());
            reservaDTO.setFechaHora(df.format(reserva.getFechaHora()));
            reservaDTO.setRestauranteId(reserva.getRestaurante().getId());
            reservaDTO.setRestauranteNombre(reserva.getRestaurante().getNombre());
            reservaDTOList.add(reservaDTO);
        }
        return reservaDTOList;
    }

    public ReservaDTO getReservaDTO(Reserva reserva) {
        ReservaDTO reservaDTO = new ReservaDTO();
        return reservaDTO;
    }

    public Reserva getReserva(ReservaDTO reservaDTO, Restaurante restaurante) throws Exception {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        DateFormat df = new SimpleDateFormat(pattern);

        Reserva reserva = new Reserva();
        reserva.setEmail(reservaDTO.getEmail());
        reserva.setRestaurante(restaurante);
        reserva.setFechaHora(df.parse(reservaDTO.getFechaHora()));
        return reserva;
    }
}
