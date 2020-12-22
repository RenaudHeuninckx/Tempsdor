package org.larnak.Tempsdor.metier.service;

import org.larnak.Tempsdor.exception.ElementAlreadyExistException;
import org.larnak.Tempsdor.exception.ElementNotFoundException;

import java.util.List;

public interface CrudService<DTO, ID> {

    void create(DTO toCreate) throws ElementAlreadyExistException;
    DTO getOne(ID id) throws ElementNotFoundException;
    List<DTO> getALl();
    void update(DTO toUpdate) throws ElementNotFoundException;
    void delete(ID toDelete) throws ElementNotFoundException;

}
