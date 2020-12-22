package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Booking;
import org.larnak.Tempsdor.metier.DTO.SmallBookingDTO;
import org.springframework.stereotype.Component;

@Component
public class SmallBookingMapper implements Mapper<SmallBookingDTO, Booking> {


    @Override
    public SmallBookingDTO toDTO(Booking booking) {

        if (booking == null) return null;

        SmallBookingDTO smallBookingDTO = new SmallBookingDTO();

        smallBookingDTO.setId(booking.getId());
        smallBookingDTO.setNbPersonnes(booking.getNbPersonnes());
        smallBookingDTO.setArrival(booking.getArrival());
        smallBookingDTO.setDeparture(booking.getDeparture());

        return smallBookingDTO;
    }

    @Override
    public Booking toENTITY(SmallBookingDTO smallBookingDTO) {

        if (smallBookingDTO == null) return null;

        Booking booking = new Booking();

        booking.setId(smallBookingDTO.getId());
        booking.setNbPersonnes(smallBookingDTO.getNbPersonnes());
        booking.setArrival(smallBookingDTO.getArrival());
        booking.setDeparture(smallBookingDTO.getDeparture());

        return booking;
    }
}
