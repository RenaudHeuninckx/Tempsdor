package org.larnak.Tempsdor.metier.service;

import org.larnak.Tempsdor.DAL.entity.User;
import org.larnak.Tempsdor.DAL.repository.UserRepository;
import org.larnak.Tempsdor.exception.ElementAlreadyExistException;
import org.larnak.Tempsdor.exception.ElementNotFoundException;
import org.larnak.Tempsdor.exception.UserAlreadyExistException;
import org.larnak.Tempsdor.exception.UserNotFoundException;
import org.larnak.Tempsdor.metier.DTO.PresUserDTO;
import org.larnak.Tempsdor.metier.DTO.UserDTO;
import org.larnak.Tempsdor.metier.mapper.PresUserMapper;
import org.larnak.Tempsdor.metier.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService implements CrudService<UserDTO,Integer> {

    @Autowired
    private UserMapper mapper;
    @Autowired
    private PresUserMapper presMapper;
    @Autowired
    private UserRepository repo;

    @Override
    public void create(UserDTO toCreate) throws ElementAlreadyExistException {
        if(repo.existsById(toCreate.getId()))
            throw new UserAlreadyExistException(toCreate.getId());
        repo.save(mapper.toENTITY(toCreate));
    }

    @Override
    @Transactional
    public UserDTO getOne(Integer id) throws ElementNotFoundException {
        return null;
    }

    @Transactional
    public PresUserDTO getOnePres(Integer id) throws ElementNotFoundException {
        User entity = repo.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));
        return presMapper.toDTO(entity);
    }

    @Override
    @Transactional
    public List<UserDTO> getALl() {
        return null;
    }

    @Transactional
    public List<PresUserDTO> getAllPres(){
        return repo.findAll()
                .stream()
                .map(presMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void update(UserDTO toUpdate) throws ElementNotFoundException {
        if (!repo.existsById(toUpdate.getId()))
            throw new UserNotFoundException(toUpdate.getId());
        repo.save(mapper.toENTITY(toUpdate));
    }

    @Override
    public void delete(Integer toDelete) throws ElementNotFoundException {
        if (!repo.existsById(toDelete))
            throw new UserNotFoundException(toDelete);
        repo.deleteById(toDelete);
    }
}
