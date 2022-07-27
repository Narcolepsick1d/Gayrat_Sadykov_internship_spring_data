package ru.sadikov.dz.magafondz.Reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.Optional;

@Repository
public interface IUsersRepository extends JpaRepository<Users,String> {
    Optional<Users>findByEmail(String email);

    Optional<Users>deleteByEmail(String email);
}
