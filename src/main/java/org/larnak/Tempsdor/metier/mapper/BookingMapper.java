package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Booking;
import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.DAL.entity.User;
import org.larnak.Tempsdor.metier.DTO.BookingDTO;
import org.larnak.Tempsdor.metier.DTO.SmallRoomDTO;
import org.larnak.Tempsdor.metier.DTO.SmallUserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookingMapper implements Mapper<BookingDTO, Booking> {

    @Autowired
    private Mapper<SmallRoomDTO, Room> mapperRoom;

    @Autowired
    private Mapper<SmallUserDTO, User> mapperUser;

    @Override
    public BookingDTO toDTO(Booking booking) {

        if (booking == null) return null;

        BookingDTO bookingDTO = new BookingDTO();

        bookingDTO.setId(booking.getId());
        bookingDTO.setNbPersonnes(booking.getNbPersonnes());
        bookingDTO.setArrival(booking.getArrival());
        bookingDTO.setDeparture(booking.getDeparture());
        bookingDTO.setUser(mapperUser.toDTO(booking.getUser()));
        bookingDTO.setRoom(mapperRoom.toDTO(booking.getRoom()));

        return bookingDTO;
    }

    @Override
    public Booking toENTITY(BookingDTO bookingDTO) {

        if (bookingDTO == null) return null;

        Booking booking = new Booking();

        booking.setId(bookingDTO.getId());
        booking.setNbPersonnes(bookingDTO.getNbPersonnes());
        booking.setArrival(bookingDTO.getArrival());
        booking.setDeparture(bookingDTO.getDeparture());
        booking.setUser(mapperUser.toENTITY(bookingDTO.getUser()));
        booking.setRoom(mapperRoom.toENTITY(bookingDTO.getRoom()));

        return booking;
    }
}
