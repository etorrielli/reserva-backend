package com.undec.reserva.repository;

import com.undec.reserva.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ReservaRepository extends JpaRepository<Reserva, Integer> {

    List<Reserva> findByFechaHoraBetween(Date dateFrom, Date dateTo);
}
