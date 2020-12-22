package org.larnak.Tempsdor.metier.service;

import org.larnak.Tempsdor.DAL.entity.Booking;
import org.larnak.Tempsdor.DAL.entity.Room;
import org.larnak.Tempsdor.DAL.entity.User;
import org.larnak.Tempsdor.DAL.repository.ActivityRepository;
import org.larnak.Tempsdor.DAL.repository.RoomRepository;
import org.larnak.Tempsdor.DAL.repository.UserRepository;
import org.larnak.Tempsdor.exception.*;
import org.larnak.Tempsdor.metier.DTO.PresRoomDTO;
import org.larnak.Tempsdor.metier.DTO.RoomDTO;
import org.larnak.Tempsdor.metier.mapper.PresRoomMapper;
import org.larnak.Tempsdor.metier.mapper.RoomMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class RoomService implements CrudService<RoomDTO,Integer> {

    @Autowired
    private RoomMapper mapperRoom;
    @Autowired
    private PresRoomMapper mapperPresRoom;
    @Autowired
    private RoomRepository repoRoom;
    @Autowired
    private ActivityRepository repoActivity;
    @Autowired
    private UserRepository repoUser;

    @Override
    public void create(RoomDTO toCreate) throws ElementAlreadyExistException {
        if(repoRoom.existsById(toCreate.getId()))
            throw new RoomAlreadyExistException(toCreate.getId());
        repoRoom.save(mapperRoom.toENTITY(toCreate));
    }

    @Override
    public RoomDTO getOne(Integer integer) throws ElementNotFoundException {
        return null;
    }

    @Transactional
    public PresRoomDTO getOnePres(Integer id) throws ElementNotFoundException {
        Room room = repoRoom.findById(id)
                .orElseThrow(() -> new RoomNotFoundException(id));
        return mapperPresRoom.toDTO(room);
    }

    @Override
    @Transactional
    public List<RoomDTO> getALl() {
        return null;
    }

    @Transactional
    public List<PresRoomDTO> getAllPres() {
        return repoRoom.findAll()
                .stream()
                .map(mapperPresRoom::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(RoomDTO toUpdate) throws ElementNotFoundException {
        if(!repoRoom.existsById(toUpdate.getId()))
            throw new RoomNotFoundException(toUpdate.getId());
        repoRoom.save(mapperRoom.toENTITY(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoRoom.existsById(toDelete))
            throw new RoomNotFoundException(toDelete);
        repoRoom.deleteById(toDelete);
    }

    @Transactional
    public List<PresRoomDTO> getAllByActivity(int activityId){
        List<Room> rooms = (List<Room>) repoActivity.getOne(activityId).getRooms();
        return rooms.stream().map(mapperPresRoom::toDTO).collect(Collectors.toList());
    }

    @Transactional
    public boolean checkAvailability(int roomId, Date start, Date end){
        List<Booking> bookings = (List<Booking>) repoRoom.getOne(roomId).getBookings();
        return bookings.stream()
                .noneMatch( booking -> start.after(booking.getDeparture())
                                    && end.before(booking.getArrival())    );
    }

    public void changeOwner(int roomId, int userId) throws ElementNotFoundException {
        if (!repoRoom.existsById(roomId))
            throw new RoomNotFoundException(roomId);
        if (!repoUser.existsById(userId))
            throw new UserNotFoundException(userId);
        User user = repoUser.getOne(userId);
        Room room = repoRoom.getOne(roomId);
        room.setUser(user);
        repoRoom.save(room);
    }
}
