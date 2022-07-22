package ru.sadikov.dz.magafondz.Reprository;

import org.springframework.data.jpa.repository.JpaRepository;


import ru.sadikov.dz.magafondz.models.Intern;

import java.util.List;

public interface IInterReprository extends JpaRepository<Intern,Long> {
    List<Intern> findAll();
}
