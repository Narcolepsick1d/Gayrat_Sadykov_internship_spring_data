package ru.sadikov.dz.magafondz.Reprository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sadikov.dz.magafondz.models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role,Integer> {
    @Query("SELECT r FROM Role r WHERE r.role = ?1")
    public Role findByName(String name);
}
