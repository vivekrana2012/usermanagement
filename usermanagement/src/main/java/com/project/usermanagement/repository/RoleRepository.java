package com.project.usermanagement.repository;

import com.project.usermanagement.model.Role;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {

    public Optional<Role> findByName(String name);

    @Query(value = "select * from role where name in ?1", nativeQuery = true)
    public Set<Role> findByNameIn(List<String> names);

    public Optional<Set<Role>> findByIdIn(List<Long> ids);
}
