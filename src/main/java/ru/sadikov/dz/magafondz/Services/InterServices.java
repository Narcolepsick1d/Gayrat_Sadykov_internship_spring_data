package ru.sadikov.dz.magafondz.Services;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.sadikov.dz.magafondz.Reprository.IInterReprository;

import ru.sadikov.dz.magafondz.models.Intern;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class InterServices  {
    private final IInterReprository iInterReprository;

    public InterServices(IInterReprository iInterReprository) {
        this.iInterReprository = iInterReprository;

    }
    public List<Intern> findAll() {
        return iInterReprository.findAll();
    }
}
