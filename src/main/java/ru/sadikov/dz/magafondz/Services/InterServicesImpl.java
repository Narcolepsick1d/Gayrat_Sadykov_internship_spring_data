package ru.sadikov.dz.magafondz.Services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import ru.sadikov.dz.magafondz.Reprository.IInterReprository;


import ru.sadikov.dz.magafondz.models.Intern;

import java.util.List;
import java.util.Optional;

@Service
@PreAuthorize("hasRole('ROLE_MENTOR')")
public class InterServicesImpl implements InterService {
    @Autowired
    private IInterReprository iInterReprository;


    @Override
    public List<Intern> getAllInterns() {
        return iInterReprository.findAll();
    }

    @Override
    public void saveIntern(Intern intern) {this.iInterReprository.save(intern);

    }

    @Override
    public Intern getInternById(Integer id) {
        Optional<Intern> optional = iInterReprository.findById(id);
        Intern intern = null;
        if (optional.isPresent()) {
            intern = optional.get();
        } else {
            throw new RuntimeException(" intern not found for id :: " + id);
        }
        return intern;
    }

    @Override
    public void deleteInternById(Integer id) {this.iInterReprository.deleteById(id);

    }

    @Override
    public Page<Intern> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.iInterReprository.findAll(pageable);
    }
}
