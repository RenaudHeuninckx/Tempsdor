package org.larnak.Tempsdor.DAL.repository;

import org.larnak.Tempsdor.DAL.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}
