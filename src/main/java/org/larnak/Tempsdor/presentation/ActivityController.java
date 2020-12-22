package org.larnak.Tempsdor.presentation;

import org.larnak.Tempsdor.exception.ElementAlreadyExistException;
import org.larnak.Tempsdor.exception.ElementNotFoundException;
import org.larnak.Tempsdor.metier.DTO.ActivityDTO;
import org.larnak.Tempsdor.metier.DTO.Container.ActivityContainer;
import org.larnak.Tempsdor.metier.DTO.Container.ElementsContainer;
import org.larnak.Tempsdor.metier.service.ActivityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/activity")
public class ActivityController {
    
    private ActivityService service;

    public ActivityController(ActivityService service) {
        this.service = service;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ActivityDTO toCreate) throws ElementAlreadyExistException {
        service.create(toCreate);
    }
    
    @GetMapping
    public ResponseEntity<ActivityContainer> getAll(){
        List<ActivityDTO> list = service.getALl();
        return ResponseEntity.ok(new ActivityContainer(list, list.size()));
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<ActivityDTO> getOne(@PathVariable Integer id) throws ElementNotFoundException{
        return ResponseEntity.ok(service.getOne(id));
    }

    @PutMapping
    public ResponseEntity<String> update(ActivityDTO toUpdate) throws ElementNotFoundException{
        service.update(toUpdate);
        return ResponseEntity.ok("Un élément à été modifié.");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ActivityDTO> delete(@PathVariable Integer id) throws ElementNotFoundException{
        ActivityDTO deleted = service.getOne(id);
        service.delete(id);
        return ResponseEntity.ok(deleted);
    }
}
