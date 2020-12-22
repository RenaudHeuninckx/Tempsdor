package org.larnak.Tempsdor.metier.mapper;

import org.larnak.Tempsdor.DAL.entity.Booking;
import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.DAL.entity.User;
import org.larnak.Tempsdor.metier.DTO.SmallBookingDTO;
import org.larnak.Tempsdor.metier.DTO.SmallRoomDTO;
import org.larnak.Tempsdor.metier.DTO.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class UserMapper implements Mapper<UserDTO, User> {

    @Autowired
    private Mapper<SmallBookingDTO, Booking> mapperBooking;

    @Autowired
    private Mapper<SmallRoomDTO, Room> mapperRoom;

    @Override
    public UserDTO toDTO(User user) {

        if (user == null) return null;

        UserDTO userDTO = new UserDTO();

        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setPasswd(user.getPasswd());
        userDTO.setLastName(user.getLastName());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setEmail(user.getEmail());
        if (user.getBookings() != null)
            userDTO.setBookings(user.getBookings().stream()
                    .map(mapperBooking::toDTO).collect(Collectors.toList()));
        if (user.getRooms()!= null)
            userDTO.setRooms(user.getRooms().stream()
                    .map(mapperRoom::toDTO).collect(Collectors.toList()));

        return userDTO;
    }

    @Override
    public User toENTITY(UserDTO userDTO) {

        if (userDTO == null) return null;

        User user = new User();

        user.setId(userDTO.getId());
        user.setName(userDTO.getName());
        user.setPasswd(userDTO.getPasswd());
        user.setLastName(userDTO.getLastName());
        user.setFirstName(userDTO.getFirstName());
        user.setEmail(userDTO.getEmail());
        if (userDTO.getBookings() != null)
            user.setBookings(userDTO.getBookings().stream()
                    .map(mapperBooking::toENTITY).collect(Collectors.toList()));
        if (userDTO.getRooms() != null)
            user.setRooms(userDTO.getRooms().stream()
                    .map(mapperRoom::toENTITY).collect(Collectors.toList()));

        return user;
    }
}
