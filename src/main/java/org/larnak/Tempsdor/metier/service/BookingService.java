package org.larnak.Tempsdor.metier.service;

import org.larnak.Tempsdor.DAL.entity.Booking;
import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.DAL.entity.User;
import org.larnak.Tempsdor.DAL.repository.BookingRepository;
import org.larnak.Tempsdor.DAL.repository.RoomRepository;
import org.larnak.Tempsdor.DAL.repository.UserRepository;
import org.larnak.Tempsdor.exception.*;
import org.larnak.Tempsdor.metier.DTO.BookingDTO;
import org.larnak.Tempsdor.metier.mapper.BookingMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService implements CrudService<BookingDTO, Integer> {

    @Autowired
    private BookingMapper mapperBooking;
    @Autowired
    private BookingRepository repoBooking;
    @Autowired
    private UserRepository repoUser;
    @Autowired
    private RoomRepository repoRoom;

    @Override
    public void create(BookingDTO toCreate) throws ElementAlreadyExistException {
        if (repoBooking.existsById(toCreate.getId()))
            throw new BookingAlreadyExistException(toCreate.getId());
        repoBooking.save(mapperBooking.toENTITY(toCreate));
    }

    @Override
    @Transactional
    public BookingDTO getOne(Integer id) throws ElementNotFoundException {
        Booking booking = repoBooking.findById(id)
                .orElseThrow(() -> new BookingNotFoundException(id));
        return mapperBooking.toDTO(booking);
    }

    @Override
    @Transactional
    public List<BookingDTO> getALl() {
        return repoBooking.findAll().stream()
                .map(mapperBooking::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(BookingDTO toUpdate) throws ElementNotFoundException {
        if (!repoBooking.existsById(toUpdate.getId()))
            throw new BookingNotFoundException(toUpdate.getId());
        repoBooking.save(mapperBooking.toENTITY(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoBooking.existsById(toDelete))
            throw new BookingNotFoundException(toDelete);
        repoBooking.deleteById(toDelete);
    }

    @Transactional
    public List<BookingDTO> getByUser(int userId) throws ElementNotFoundException {
        if ( ! repoUser.existsById(userId)) throw new UserNotFoundException(userId);
        return repoUser.getOne(userId)
                .getBookings()
                .stream()
                .map(mapperBooking::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public List<BookingDTO> getByOwner(int ownerId) throws ElementNotFoundException {
        if ( ! repoUser.existsById(ownerId)) throw new UserNotFoundException(ownerId);
        Collection<Room> rooms = repoRoom.findAll()
                .stream()
                .filter(room -> room.getUser().getId() == ownerId)
                .collect(Collectors.toList());
        List<BookingDTO> bookingDTOS = null;
        for (Room room : rooms) {
            for (Booking booking : room.getBookings()) {
                bookingDTOS.add(mapperBooking.toDTO(booking));
            }
        }
        return bookingDTOS;
    }

}
