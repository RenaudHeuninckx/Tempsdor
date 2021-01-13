package org.larnak.Tempsdor.presentation;

import org.larnak.Tempsdor.exception.ElementAlreadyExistException;
import org.larnak.Tempsdor.exception.ElementNotFoundException;
import org.larnak.Tempsdor.metier.DTO.BookingDTO;
import org.larnak.Tempsdor.metier.DTO.Container.BookingContainer;
import org.larnak.Tempsdor.metier.service.BookingService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/booking")
public class BookingController {

    private BookingService service;

    public BookingController(BookingService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody BookingDTO toCreate) throws ElementAlreadyExistException {
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<BookingContainer> getAll(){
        List<BookingDTO> list = service.getALl();
        return ResponseEntity.ok(new BookingContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookingDTO> getOne(@PathVariable int id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<BookingContainer> getAllByUser(@PathVariable int id) throws ElementNotFoundException{
        List<BookingDTO> list = service.getByUser(id);
        return ResponseEntity.ok(new BookingContainer(list, list.size()));
    }

    @GetMapping("/owner/{id}")
    public ResponseEntity<BookingContainer> getAllByOwner(@PathVariable int id) throws ElementNotFoundException{
        List<BookingDTO> list = service.getByOwner(id);
        return ResponseEntity.ok(new BookingContainer(list, list.size()));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody BookingDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Un élément à été modifié");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<BookingDTO> delete(@PathVariable int id) throws ElementNotFoundException{
        BookingDTO toDelete = service.getOne(id);
        return ResponseEntity.ok(toDelete);
    }
}
