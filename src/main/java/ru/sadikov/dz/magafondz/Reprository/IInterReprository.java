package ru.sadikov.dz.magafondz.Reprository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.sadikov.dz.magafondz.models.Intern;


public interface IInterReprository extends JpaRepository<Intern,Integer> {


}
