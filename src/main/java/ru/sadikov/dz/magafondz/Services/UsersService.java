package ru.sadikov.dz.magafondz.Services;


import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import ru.sadikov.dz.magafondz.models.Users;

import java.util.List;

@Service
public interface UsersService {
    List<Users> getAllUsers();
    void saveUsers(Users users);
    Users getUsersById(Integer id);

    void deleteUsersById(Integer id);
    Page<Users> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
