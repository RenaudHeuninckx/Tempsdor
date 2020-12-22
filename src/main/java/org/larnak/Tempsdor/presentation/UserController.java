package org.larnak.Tempsdor.presentation;

import org.larnak.Tempsdor.exception.ElementAlreadyExistException;
import org.larnak.Tempsdor.exception.ElementNotFoundException;
import org.larnak.Tempsdor.metier.DTO.Container.UserContainer;
import org.larnak.Tempsdor.metier.DTO.PresUserDTO;
import org.larnak.Tempsdor.metier.DTO.UserDTO;
import org.larnak.Tempsdor.metier.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PostMapping
    public void create(@RequestBody UserDTO toCreate) throws ElementAlreadyExistException{
        service.create(toCreate);
    }

    @GetMapping
    public ResponseEntity<UserContainer> getAll(){
        List<PresUserDTO> list = service.getAllPres();
        return ResponseEntity.ok(new UserContainer(list, list.size()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PresUserDTO> getOne(@RequestBody int id) throws ElementNotFoundException {
        return ResponseEntity.ok(service.getOnePres(id));
    }

    @PutMapping
    public ResponseEntity<String> update(@RequestBody UserDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Utilisateur modifié");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDTO> delete(@PathVariable int id) throws ElementNotFoundException{
        UserDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
