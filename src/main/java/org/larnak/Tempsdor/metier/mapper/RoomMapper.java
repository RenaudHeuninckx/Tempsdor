package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Activity;
import org.larnak.Tempsdor.DAL.entity.Booking;
import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.DAL.entity.User;
import org.larnak.Tempsdor.metier.DTO.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class RoomMapper implements Mapper<RoomDTO, Room> {

    @Autowired
    private Mapper<SmallActivityDTO, Activity> mapperActivity;

    @Autowired
    private Mapper<SmallBookingDTO, Booking> mapperBooking;

    @Autowired
    private Mapper<SmallUserDTO, User> mapperUser;

    @Override
    public RoomDTO toDTO(Room room) {

        if (room == null) return null;

        RoomDTO roomDTO = new RoomDTO();

        roomDTO.setId(room.getId());
        roomDTO.setCapacity(room.getCapacity());
        roomDTO.setAddress(room.getAddress());
        roomDTO.setCity(room.getCity());
        roomDTO.setUser(mapperUser.toDTO(room.getUser()));
        if(room.getActivities() != null)
            roomDTO.setActivities(room.getActivities().stream()
                    .map(mapperActivity::toDTO).collect(Collectors.toList()));
        if (room.getBookings() != null)
            roomDTO.setBookings(room.getBookings().stream()
                    .map(mapperBooking::toDTO).collect(Collectors.toList()));

        return roomDTO;
    }

    @Override
    public Room toENTITY(RoomDTO roomDTO) {

        if (roomDTO == null) return null;

        Room room = new Room();

        room.setId(roomDTO.getId());
        room.setCapacity(roomDTO.getCapacity());
        room.setAddress(roomDTO.getAddress());
        room.setCity(roomDTO.getCity());
        room.setUser(mapperUser.toENTITY(roomDTO.getUser()));
        if(roomDTO.getActivities() != null)
            room.setActivities(roomDTO.getActivities().stream()
                    .map(mapperActivity::toENTITY).collect(Collectors.toList()));
        if(roomDTO.getBookings() != null)
            room.setBookings(roomDTO.getBookings().stream()
                    .map(mapperBooking::toENTITY).collect(Collectors.toList()));

        return room;
    }
}
