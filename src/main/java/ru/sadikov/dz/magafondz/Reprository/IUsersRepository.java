package ru.sadikov.dz.magafondz.Reprository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.Optional;

@Repository
public interface IUsersRepository extends JpaRepository<Users,Integer> {


    @Query("SELECT u FROM Users u WHERE u.email = ?1")
    public Users findByEmail(String email);
    @Query("SELECT u FROM Users u WHERE u.id = ?1")
    public void deleteById(Integer id);


}
