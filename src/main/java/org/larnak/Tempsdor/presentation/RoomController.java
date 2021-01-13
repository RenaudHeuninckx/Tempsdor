package org.larnak.Tempsdor.presentation;

import org.larnak.Tempsdor.exception.ElementAlreadyExistException;
import org.larnak.Tempsdor.exception.ElementNotFoundException;
import org.larnak.Tempsdor.metier.DTO.Container.RoomContainer;
import org.larnak.Tempsdor.metier.DTO.PresRoomDTO;
import org.larnak.Tempsdor.metier.DTO.RoomDTO;
import org.larnak.Tempsdor.metier.service.RoomService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/room")
public class RoomController {

    private RoomService service;

    public RoomController(RoomService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody RoomDTO toCreate) throws ElementAlreadyExistException {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<RoomContainer> getAll(){
        List<PresRoomDTO> list = service.getAllPres();
        return ResponseEntity.ok(new RoomContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresRoomDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOnePres(id));
    }

    @GetMapping("/activity/{id}")
    public ResponseEntity<RoomContainer> getByActivity(@PathVariable int id) throws ElementNotFoundException{
        List<PresRoomDTO> list = service.getAllByActivity(id);
        return ResponseEntity.ok(new RoomContainer(list, list.size()));
    }

    @GetMapping("/availability/{id}/{start}/{end}")
    public ResponseEntity<Boolean> getAvailability(@PathVariable int id, @PathVariable Date start, @PathVariable Date end){
        return ResponseEntity.ok(service.checkAvailability(id, start, end));
    }


    @PutMapping
    public ResponseEntity<String> update(@RequestBody RoomDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Une chambre à été modifiée.");
    }

    @PutMapping("/changeowner/{room}/{user}")
    public ResponseEntity<String> chanceOwner(@PathVariable int roomId, @PathVariable int userId )  throws ElementNotFoundException{
        service.changeOwner(roomId, userId);
        return ResponseEntity.ok("Le propriétaire de la chambre à été changé.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RoomDTO> delete(@PathVariable int id) throws ElementNotFoundException{
        RoomDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }


}
