package ru.sadikov.dz.magafondz.Services;

import org.springframework.data.domain.Page;

import ru.sadikov.dz.magafondz.models.Intern;

import java.util.List;

public interface InterService  {
    List<Intern> getAllInterns();
    void saveIntern(Intern intern);
    Intern getInternById(Integer id);
    void deleteInternById(Integer id);
    Page<Intern> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
