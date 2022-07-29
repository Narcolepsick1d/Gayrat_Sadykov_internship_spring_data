package ru.sadikov.dz.magafondz.Services;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.sadikov.dz.magafondz.models.Intern;

import java.util.List;
@Service
public interface InterService  {
    List<Intern> getAllInterns();
    void saveIntern(Intern intern);
    Intern getInternById(Integer id);
    void deleteInternById(Integer id);
    Page<Intern> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
