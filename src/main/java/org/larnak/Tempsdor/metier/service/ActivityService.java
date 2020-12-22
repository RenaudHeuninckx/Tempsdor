package org.larnak.Tempsdor.metier.service;

import org.larnak.Tempsdor.DAL.entity.Activity;
import org.larnak.Tempsdor.DAL.repository.ActivityRepository;
import org.larnak.Tempsdor.exception.ActivityAlreadyExistException;
import org.larnak.Tempsdor.exception.ActivityNotFoundException;
import org.larnak.Tempsdor.exception.ElementAlreadyExistException;
import org.larnak.Tempsdor.exception.ElementNotFoundException;
import org.larnak.Tempsdor.metier.DTO.ActivityDTO;
import org.larnak.Tempsdor.metier.mapper.ActivityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ActivityService implements CrudService<ActivityDTO,Integer> {

    @Autowired
    private ActivityMapper mapperActivity;
    @Autowired
    private ActivityRepository repoActivity;

    @Override
    public void create(@Valid ActivityDTO toCreate) throws ElementAlreadyExistException {
        if (repoActivity.existsById(toCreate.getId()))
            throw new ActivityAlreadyExistException(toCreate.getId());
        repoActivity.save(mapperActivity.toENTITY(toCreate));
    }

    @Override
    @Transactional
    public ActivityDTO getOne(Integer id) throws ElementNotFoundException {
        Activity activity = repoActivity.findById(id)
                .orElseThrow(()-> new ActivityNotFoundException(id));
        return mapperActivity.toDTO(activity);
    }

    @Override
    @Transactional
    public List<ActivityDTO> getALl() {
        return repoActivity.findAll()
                .stream()
                .map(mapperActivity::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(@Valid ActivityDTO toUpdate) throws ElementNotFoundException {
        if (!repoActivity.existsById(toUpdate.getId()))
            throw new ActivityNotFoundException(toUpdate.getId());
        repoActivity.save(mapperActivity.toENTITY(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repoActivity.existsById(toDelete))
            throw new ActivityNotFoundException(toDelete);
        repoActivity.deleteById(toDelete);
    }
}
